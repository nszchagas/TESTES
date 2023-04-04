# Fundamentos de Testes

Problemas de software não se limitam à pequenos inconvenientes, eles podem ser a causa de acidentes nos mais diversos
níveis, inclusive fatalidades. A testagem correta de software é necessária para evitar frustrações, perdas financeiras,
gasos necessários, danos à propriedade e até a morte de pessoas envolvidas, provenientes de falhas em software.

Atualmente a vida humana depende intimamente de software, e para garantir uma qualidade de vida é necessário fazer a
testagem rigorosa dos softwares e sistemas, incluindo suas documentações.

## Causas de defeitos em software

A causa inicial (_root cause_) dos defeitos geralmente encontra-se nas ações (ou ausência de ações) humanas, como falha
na especificação de requisitos. Já outras falhas não são causadas diretamente por seres humanos, mas sim por interações
entre o objeto de teste e seu ambiente, como uma falha de software em detrimento do aquecimento de componentes
eletrônicos.

Uma ampla nomenclatura descreve o comportamento incorreto de software, mas o ISTQS (_International
Software Testing Qualifications Board_) determina a utilização dos termos:

- Erro (_error_): ação humana na raiz de um defeito.
- Defeito (_defect_): resultado, presente no objeto de teste, de uma ação humana.
- Falha (_failure_): resultado da execução de um defeito por um processo.

> Defeitos podem estar presentes em software e também em documentos.

## Testes e Qualidade

Testes e QA não são noções identicas, a saber:

- A qualidade de software garante que os processos definidos pelas organizações são implementados, e da forma correta.
  Além disso, a qualidade de software visa aumentar a eficiência e efetividade desses processos.
- Testes identificam defeitos e falhas e fornecem informações sobre o software e os riscos de lançamento deste no
  mercado.

A comunidade de Testes de Software não é uniforme, existem duas abordagem principais: tradicional e ágil.

Na abordagem tradicional os testes são baseados em requisitos e especificações, e o software é analisado
sistematicamente, com frequência gerando um grande volume de documentação. Essa metodologia baseia-se na definição e
organização de atividades.

Já a abordagem ágil baseia-se nas recomendações do Manifesto Ágil, baseando-se em avaliações pragmáticas de atividades
de teste anteriores à entrega do software.

## Terminologia

As atividades de verificação e validação são complementares, a primeira responde à questão "o que foi especificado foi
produzido?", enquanto a segunda responde se "o que foi construído é o produto correto?".

**Verificação**: confirmação de que os requisitos especificados foram contemplados.
**Validação**: confirmação de que os requisitos especificados foram contemplados para o uso esperado.

## Objetivos

Testes de software focam-se nos seguintes aspectos:

- Detecção de falhas e defeitos;
- Fornecer informação para a tomada de decisões associadas ao nível de risco da entrega de um software ao mercado.

Os objetivos mais específicos dos testes variam de acordo com a fase do desenvolvimento na qual eles são aplicados.

| Fase                            | Objetivo                                                                                                                                                  |
|---------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| _Design_                        | Encontrar o maior número de defeitos e falhas, no menor período de tempo possível, para entregar um software de alta qualidade.                           |
| Aceitação do cliente            | Mostrar que o software funciona de acordo com o esperado para obter aprovação do cliente.                                                                 |
| Fases operacionais              | Enquanto o software está sendo usado, os testes focam em garantir que os requisitos exigidos estão sendo contemplados.                                    |
| Evolução/Manunteção de correção | Garantir que as correções e evoluções não introduzem defeitos no software, além de verificar se não ocorrem efeitos colaterais (via testes de regressão). |
| Descarte/Substituição           | Os testes criam uma _snapshot_ do antigo produto, para que o produto subsequente possua as mesmas funcionalidades.                                        |

<div style="text-align: center"> Tabela 1: Objetivos da testagem de software. Fonte: autor. </div>

## Testes e depuração

De acordo com a ISO 05, Testagem é a identificação de uma ou mais características de acordo com um procedimento
definido. No contexto de testagem de software, um teste possui os seguintes elementos:

- Objetivo (características que serão confirmadas);
- Uma forma de determinar as características (o processo definido e sua execução);
- Uma atividade (a execução do procedimento para obter um resultado);
- Um resultado (a presença ou ausência da característica no nível esperado);

A depuração consiste no conserto de defeitos em software realizado pelos desenvolvedores, por meio da busca e remoção de
causas exatas de falha. Essa tarefa não está envovlida no proceso de testa.

## Paradoxos e Princípios

- Testes identificam a presença de defeitos, mas não podem assegurar a ausência destes;
- Não é possível usar técnicas exaustivas para testar "tudo";
- Quanto mais cedo os testes são realizados, menos custoso será consertar os defeitos encontrados;
- Localidade dos defeitos, i. e., se um defeito foi encontrado em um trecho de código, trechos produzidos no mesmo
  período ou pela mesma pessoa, por exemplo, apresentam uma maior chance de apresentar defeitos.
- Aplicar sempre os mesmos testes ao longo do tempo não é eficiente.
- A testagem depende do contexto;
- Ausência de erros não indica, necessariamente, qualidade do produto.

# Referências

[1] HOMÈS, B. Fundamentals of Software Testings.   
