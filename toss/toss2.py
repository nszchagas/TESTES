import time
import csv

from typing import List
from selenium import webdriver
from selenium.webdriver.edge.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains


class TestCase:
    code: str
    c_id: str
    c_name:str 
    c_institute:str
    c_timezone: str
    error: bool
    result: str
    
    def __init__(self, code, id, name, institute, timezone, error):
        self.code = code
        self.c_id = id
        self.c_name = name
        self.c_institute = institute
        self.c_timezone = timezone
        self.error = bool(error)
    def __str__(self):
        return '\n{'\
            f'code: {self.code}, c_id: {self.c_id}, c_name: {self.c_name}, institute {self.c_institute}, c_timezone: {self.c_timezone}, expect error: {self.error}' \
        '}\n'
    
    

def create_instructors() -> List[str]:
    instructors: List[str] = [f'Instrutor 1 | {login_email} | UnB',
                              f'Instrutor 1 | {login_email} | FGA', 'Instrutor 2 | instrutor2@email.com | Católica ']
    driver = webdriver.Edge()
    driver.get(url)
    actions = ActionChains(driver)

    dropdown_selector: str = 'a.dropdown-toggle.nav-link'

    for x in driver.find_elements(By.CSS_SELECTOR, dropdown_selector):
        if 'Login' in x.get_attribute('innerHTML'):
            login_menu = x

    login_btn = driver.find_element(By.CSS_SELECTOR, 'a#instructor-login-btn')

    actions.move_to_element(x).click((x)).move_to_element(
        login_btn).click(login_btn).perform()

    input_email = driver.find_element(By.CSS_SELECTOR, 'input#email')

    input_button = driver.find_element(By.CSS_SELECTOR, 'input#btn-login')
    actions.click(input_button).perform()

    driver.implicitly_wait(1000)

    menu = driver.find_element(By.CSS_SELECTOR, dropdown_selector)
    actions.click(menu).perform()

    for x in driver.find_elements(By.CSS_SELECTOR, 'a.dropdown-item'):
        if 'admin pages' in x.get_attribute('innerHTML'):
            admin_page_menu = x

    actions.click(admin_page_menu).perform()

    input_instructors = driver.find_element(
        By.CSS_SELECTOR, 'textarea#instructor-details-single-line')
    add_instructors_btn = driver.find_element(
        By.CSS_SELECTOR, 'button#add-instructor-single-line')

    input_instructors.send_keys('\n'.join(instructors))
    actions.click(add_instructors_btn).perform()

    for x in range(len(instructors)):
        actions.click(driver.find_element(By.CSS_SELECTOR,
                      f'button#add-instructor-{x}')).perform()

    join_links = []
    driver.implicitly_wait(1000)

    for link in driver.find_elements(By.CSS_SELECTOR, 'a'):
        if link.get_attribute('innerHTML'):
            if 'join link' in link.get_attribute('innerHTML'):
                join_links.append(link.get_attribute('href'))    
    
    driver.quit()
    return join_links
    

def activate_instructor(join_links: List[str]):
    driver = webdriver.Edge()
    actions = ActionChains(driver)
    for link in join_links:
        try: 
            driver.get(link)
            actions = ActionChains(driver)

            input_email = driver.find_element(By.CSS_SELECTOR, 'input#email')
            input_email.clear()
            input_email.send_keys(login_email)

            input_button = driver.find_element(By.CSS_SELECTOR, 'input#btn-login')
            actions.click(input_button).perform()

            driver.implicitly_wait(1000)

            confirm_button = driver.find_element(By.CSS_SELECTOR, 'button#btn-confirm')
            actions.click(confirm_button).perform()
            driver.close()
        except Exception as e: 
            print(e)
    driver.quit()


def login(email: str, driver: webdriver):
    actions = ActionChains(driver)
    dropdown_selector: str = 'a.dropdown-toggle.nav-link'
    for x in driver.find_elements(By.CSS_SELECTOR, dropdown_selector):
        if 'Login' in x.get_attribute('innerHTML'):
            login_menu = x

    login_btn = driver.find_element(By.CSS_SELECTOR, 'a#instructor-login-btn')

    actions.move_to_element(x).click((x)).move_to_element(
        login_btn).click(login_btn).perform()

    input_email = driver.find_element(By.CSS_SELECTOR, 'input#email')
    input_email.clear()
    input_email.send_keys(email)

    input_button = driver.find_element(By.CSS_SELECTOR, 'input#btn-login')
    actions.click(input_button).perform()

    driver.implicitly_wait(1000)

    

def get_test_cases(filename) -> List[TestCase]:

    tests: List[TestCase] = []
    
    with open(filename, 'r', encoding='utf-8') as file:
        reader = csv.reader(file, delimiter=',')
        for row in reader:
            [code, c_id, c_name, c_institute, c_timezone, error] =  row
            tests.append(TestCase(code, c_id, c_name, c_institute, c_timezone, error))            
        
    return tests
        

def test(test_cases):

    driver = webdriver.Edge()
    driver.get(url)
    actions = ActionChains(driver)
    login(login_email, driver)

    for b in driver.find_elements(By.CSS_SELECTOR, 'a.btn-success'):
        if b.get_attribute('innerHTML'):
            if 'Add New Course' in b.get_attribute('innerHTML'):
                add_course_btn = b
    
    if not b:
        return
        
    actions.click(b).perform()
      
    
    for t in test_cases:
        c_id = driver.find_element(By.CSS_SELECTOR, 'input#course-id')
        c_name = driver.find_element(By.CSS_SELECTOR, 'input#course-name')
        c_institute = driver.find_element(By.CSS_SELECTOR, 'select#course-institute')    
        c_timezone = driver.find_element(By.CSS_SELECTOR, 'select#time-zone')
        
        btn_add_course = driver.find_element(By.CSS_SELECTOR, 'button#btn-submit-course')
    
        c_id.clear()
        c_name.clear()
               
    
        c_id.send_keys(t.c_id)
        c_name.send_keys(t.c_name)
        c_institute.send_keys(t.c_institute)
        c_timezone.send_keys(t.c_timezone)

        actions.click(btn_add_course).perform()

        driver.implicitly_wait(1000)

        time.sleep(3)

        confirmation = driver.find_elements(By.CSS_SELECTOR, '.toast-body')
        
        assert len(confirmation) != 0
        try: 
            if (not t.error):
                assert "The course has been added." in confirmation[0].get_attribute('innerText')
            else: 
                assert "is not acceptable to TEAMMATES " in confirmation[0].get_attribute('innerHTML')
            t.result = 'Sucesso'
        except AssertionError as e:
            print(f'Erro no caso de teste {t.code}: {e}.\nConteúdo da janela do teammates: {confirmation[0].get_attribute("innerHTML")}')
            print(f'Valores de entrada: {t}')
            t.result = 'Erro'
            
            
    print('|---------------|-----------|')
    print('| Caso de Teste | Resultado |')
    print('|---------------|-----------|')
    
    for t in test_cases:
        print('| {:14s}| {:10s}|'.format(t.code, t.result))
        
    print('|---------------|-----------|')
        

url: str = 'http://localhost:4200'
login_email: str = 'instrutor_testes@email.com'
admin_email: str = 'app_admin@gmail.com'
testcases_file: str = 'test_cases.csv'

# Se for a primeira vez rodando, será necessário criar o instrutor para o teste. Se já estiverem criados, não tem problema rodar.
print('Criando instrutores para realizar os casos de teste.')
join_links = create_instructors()

# Ativar todos os instrutores criados, se tiver algum para ser ativado.
if (len(join_links) > 0):
    print('Ativando os instrutores criados.')
    activate_instructor(join_links)

# Lê os casos de teste do arquivo 
print('Recuperando os casos de teste a serem realizados.')
test_cases = get_test_cases(testcases_file)
print(f'{len(test_cases)} casos de teste para realizar.')

test(test_cases)

    

