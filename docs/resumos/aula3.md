# Técnicas de Teste Caixa-Preta

## Test-Case Design

Uma vez que a a testagem não garante a ausência completa de erros, a estratégia que deve ser adotada ao elaborar casos de teste é **determinar qual conjunto de casos de testes tem melhores probabilidades de encontrar a maior quantidade de erros**.

Em geral, a metodologia mais ineficiente é o teste com valores aleatórios, pois possui a menor probabilidade de encontrar erros. Uma boa escolha de casos de teste usa conceitos de testes caixa-branca e caixa-preta.

### Testes Caixa-Preta

Testes caixa-preta são derivados a partir das especificações de um programa, e têm como objetivo identificar áreas nas quais o programa não se comporta como especificado.

#### Partições Equivalentes

Já que a testagem exaustiva não é possível, o testador deve selecionar um subconjunto de entradas possíveis para testar um programa, com uma altas probabilidades de encontrar a maior quantidade de erros.

Uma ideia razoável é particionar o conjunto infinito de entradas possíveis em subconjuntos representantes de uma parcela, seguindo duas propriedades:

1. Um caso de teste reduz, em mais do que um, o número de outros casos de teste que devem ser elaborados para atingir algum objetivo pré definido de testagem.
2. Um caso de teste cobra um grande conjunto de outros casos de teste possíveis, ou seja, ele informa sobre a presença ou ausência de erros sobre um conjunto de valores de entrada.

Essas duas considerações compõem a técnica caixa-preta de testagem denominada partição em equivalentes, por meio da seguinte metodologia:

1. Selecionar condições para testagem utilizando a segunda propriedade, gerando classes equivalentes.
2. Determinar o menor número possível de entradas para casos de teste cobrindo essas condições, utilizando a primeira propriedade, definindo casos de teste.

#### Identificando as Classes Equivalentes

São identificadas tomando-se uma condição de entrada e particionando-a em dois ou mais grupos, dentre eles "equivalências válidas" e "equivalências inválidas".

Diretrizes para identificar classes equivalentes:

1. Se uma condição de entrada especifica um intervalo de entrada (1 < x < 50), identifique uma classe equivalente válida (e. g. x = 45) e duas inválidas (e. g. x < 1  e x > 50).
2. Se uma condição de entrada especifica uma quantidade de valores (e. g. "Um aluno pode matricular-se de 1 até 8 matérias por semestre"), identifique uma classe válida e duas inválidas (nenhuma matéria ou mais do que 9 matérias).
3. Se uma condição de entrada especifica um conjunto de valores válidos (e. g. tipo de documento: CPF, RG e PASSAPORTE), provavelmente o tratamento de cada uma delas é diferente, identifique uma classe válida para cada elemento desse conjunto e uma classe inválida (e. g. CDI).
4. Se uma condição de entrada define uma situação obrigatória, como "o primeiro caractere do identificador deve ser uma letra", identifique uma classe válida (satisfazendo a condição) e uma inválida (não satisfazendo a condição).

#### Identificando os Casos de Teste

Depois de identificar as classes de equivalência, os casos de teste são identificados, a partir delas, pelo seguinte processo:

1. Determine um valor único para cada classe de equivalência.
2. Escreva novos casos de teste cobrindo o máximo de classes válidas não cobertas, até que todas as classes válidas sejam cobertas.
3. Escreva um caso de testes para cobrir uma, e apenas uma, das classes inválidas não cobertas, até que todas sejam cobertas.

> A ideia de escrever testes únicos para as classes inválidas é evitar que os resultados dos testes sejam mascarados por outros casos de testes.

### Boundary Value Analysis

### Cause-effect graphing Condition coverage

### Error guessing

## Higher-Order Testing

### Function Testing

### Referências

[1] MYERS, G., et al. The Art of Software Testing. ProQuest Ebook
Central, disponível no [link](http://ebookcentral.proquest.com/lib/univbrasilia-ebooks/detail.action?docID=697721).
