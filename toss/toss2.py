import time
from typing import List
from selenium import webdriver
from selenium.webdriver.edge.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

url: str = 'http://localhost:4200'
login_email: str = 'instrutor@email.com'
admin_email: str = 'app_admin@gmail.com'
testcases_file: str = 'test_cases.csv'

def create_instructors():
    instructors: List[str] = ['Instrutor 1 | instrutor@email.com | UnB',
                              'Instrutor 1 | instrutor@email.com | FGA', 'Instrutor 2 | instrutor2@email.com | Católica ']
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

    driver.close()

    driver = webdriver.Edge()
    driver.get(join_links[0])
    actions = ActionChains(driver)

    input_email = driver.find_element(By.CSS_SELECTOR, 'input#email')
    input_email.clear()
    input_email.send_keys(login_email)

    input_button = driver.find_element(By.CSS_SELECTOR, 'input#btn-login')
    actions.click(input_button).perform()

    driver.implicitly_wait(1000)

    confirm_button = driver.find_element(By.CSS_SELECTOR, 'button#btn-confirm')
    actions.click(confirm_button).perform()

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

class TestCase:
    c_id: str
    c_name:str 
    c_institute:str
    c_timezone: str
    
    def __init__(self, id, name, institute, timezone):
        self.c_id = id.replace('"', '').strip()
        self.c_name = name.replace('"', '').strip()
        self.c_institute = institute.replace('"', '').strip()
        self.c_timezone = timezone.replace('"', '').strip()
    

def get_test_cases(filename) -> List[TestCase]:

    tests: List[TestCase] = []
    with open(filename, 'r', encoding='utf-8') as file:
        test_cases = file.readlines()        
    
    
    for x in test_cases:
        c_id, c_name, c_institute, c_timezone =  x.replace('\n', '').split('","')
        tests.append(TestCase(c_id, c_name, c_institute, c_timezone))    
    return tests
        

def test():

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
      
    
    
    test_cases = get_test_cases(testcases_file)
    
    for t in test_cases[0:1]:
        c_id = driver.find_element(By.CSS_SELECTOR, 'input#course-id')
        c_name = driver.find_element(By.CSS_SELECTOR, 'input#course-name')
        c_institute = driver.find_element(By.CSS_SELECTOR, 'select#course-institute')    
        c_timezone = driver.find_element(By.CSS_SELECTOR, 'select#time-zone')
        
        btn_add_course = driver.find_element(By.CSS_SELECTOR, 'button#btn-submit-course')
    
        c_id.clear()
        c_name.clear()
               
    
        c_id.send_keys(t.c_id)
        time.sleep(3)
        c_name.send_keys(t.c_name)
        time.sleep(3)
        c_institute.send_keys(t.c_institute)
        time.sleep(3)
        c_timezone.send_keys(t.c_timezone)
        time.sleep(3)
        time.sleep(3)
        actions.click(btn_add_course).perform()
        confirmation = driver.find_elements(By.CSS_SELECTOR, '.toast-body')
        
        
        assert len(confirmation) != 0
        assert "The course has been added." in confirmation[0].get_attribute('innerText')

        

    
test()
    

