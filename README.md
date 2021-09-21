## Considerações gerais

A escolha da linguagem é deixada para você, utilize **a que você se sente mais confortável**. A entrada deverá ser por `STDIN` (*standard input*) e a saída por `STDOUT` (*standard output*) na linguagem que você escolher. 

Forneça as instruções de instalação e execução do seu sistema, observaremos **principalmente seu *design* de código**. Aspectos como coesão, baixo acoplamento e legibilidade são os principais pontos.

Escolha um dos desafios abaixo para resolver, caso já tenha participado do processo seletivo, por favor escolha um desafio diferente do que foi feito anteriormente.

## DESAFIO 1 - Conversão de medidas

Você terá que criar um sistema que **formate a saída** de uma **dada entrada** para as três unidades de dados: **tempo, bytes e porcentagem**.

### Regras para formatação

#### Tempo

A entrada provida deve ser no formato `<numero> <ms>`, ex: `1340 ms`. A unidade usada para entrada será milisegundo.
* Quando a entrada for menor que 1 segundo a saída deve continuar em milisegundos `ms`.
* Quando a entrada for menor que 60 segundos a saída deve ser em segundos `s`.
* Quando a entrada for menor que 60 minutos a saída deve ser em minutos `min`.
* Quando a entrada for maior ou igual a 60 minutos a saída deve ser em horas `h`.

#### *Bytes*

A entrada provida deve ser no formato `<numero> <bytes>`, ex: `16 B`. A unidade usada para entrada será bytes (8 bits).
* Quando a entrada for menor que 1000 bytes a saída deve continuar em `B`.
* Quando a entrada for menor que 1000 elevado a 2 a saída deve ser em kilobyte `kB`.
* Quando a entrada for maior ou igual a 1000 elevado a 2 a saída deve ser em megabyte `MB`.

#### Porcentagem

A entrada provida deve ser no formato `<numero flutuante>`, ex: `0.16`. A unidade usada para entrada será um número flutuante onde, por exemplo, `0.1` significa `10%` e `0.98` significa `98%`.

### Exemplos de entradas e saídas esperadas pelo seu programa

| Entrada | Saída |
| ------ | ------ |
| 30 ms | `30 ms` |
| 5000 ms | `5 s` |
| 5400000 ms | `1.5 h` |
| 0.14 | `14%` |
| 50 B | `50 B` |
| 2000 B | `2 kB` |


## DESAFIO 2 - Árvore Genealógica

Você terá que criar um sistema que, dado um arquivo de entrada contendo uma lista de nome de pessoas seguido do nome de seus filhos, seja capaz de responder quais os pais de uma determinada pessoa.

### Arquivo de entrada

O formato do arquivo de entrada é o seguinte:

```
<nome da pessoa>|<nome do filho>,<nome do filho>,...
```

Exemplo:

```
Silvana Nunes|Pedrinho Nunes Augusto,Júlia Nunes Augusto,Clara Nunes Augusto
José Augusto|Pedrinho Nunes Augusto,Júlia Nunes Augusto,Clara Nunes Augusto
Igor Almeida|João Silva Almeida,Diego Nunes Almeida
Joana Silva|João Silva Almeida
Clara Nunes Augusto|Cecília Nunes Oliveira,Diego Nunes Almeida
Alberto Oliveira|Cecília Nunes Oliveira
```

### Execução e pesquisas

O programa deve ser executado recebendo como parâmetro "input-file" o arquivo de entrada e, dado um nome, retornar o nome dos pais.

Exemplo:

```
$ ./arvore_genealogica --input-file=input.txt
Digite o nome de uma pessoa:
João Silva Almeida
Os pais dessa pessoa são:
Igor Almeida e Joana Silva

Digite o nome de uma pessoa:
Leandro Moreira
Pessoa não existente.

Digite o nome de uma pessoa:
Cecília Nunes Oliveira
Os pais dessa pessoa são:
Alberto Oliveira e Clara Nunes Augusto

Digite o nome de uma pessoa:
^C
$ _
```

O programa termina quando for digitado fim ou Ctrl+C.


# Instruções para execução do desafio

<br/>

- Clonar o repositório
- Acessar pelo terminal o diretório raiz do projeto
- Executar os seguintes comandos:
    - make setup
    - make challenge INPUT-FILE=${caminho-para-arquivo-de-input}
- Fornecer os dados para validação do mesmo
- Pressionar CTRL + C para encerrar

<br/><br/>
**Notas importantes**

<ul>
<li>O desafio escolhido foi o da árvore Genealógica.</li>

<li> Foi utilizada a linguagem Java na versão 11.0.2 para o desenvolvimento, certificar que a versão utilizada na máquina para o teste é a mesma.</li>

<li>O nome do arquivo contendo as informações a serem utilizadas no desafio deve **OBRIGATORIAMENTE** ser `input.txt`, caso contrário uma exceção será lançada.</li>

<li>O código foi escrito utilizando a IDE Eclipse na versão: **2021-06 (4.20.0)**</li>
</ul>

<br/><br/>
Qualquer dúvida estou a disposição.



# DESAFIO 3

Você deverá criar um aplicativo, chamado de "Brasileirão", para acompanhamento de jogos de futebol.

O aplicativo deverá funcionar em dispositivos iOS, Android ou em browsers desktop (com javascript), dependendo da vaga para a qual você está aplicando (Player iOS, Player Android ou Player JS, respectivamente)

Você também deverá fornecer a API que provê os dados para o aplicativo com a tecnologia de sua escolha. Essa API não será avaliada, podendo ser implementada utilizando soluções prontas para backend. Apenas a implementação do aplicativo (incluindo a comunicação com o backend escolhido) será avaliada.

## Considerações Gerais

Você deverá usar este repositório como o principal do projeto. Todos os seus commits devem estar registrados aqui.

**Registre tudo**: Ideias que gostaria de implementar se tivesse mais tempo (explique como você as resolveria), decisões tomadas e seus porquês, arquiteturas testadas e os motivos de terem sido modificadas ou abandonadas.

Sinta-se livre para incluir ferramentas e bibliotecas open source.

Para ajudar, disponibilizamos uma máquina na Amazon caso você precise de uma infraestrutura para o seu código backend (veja o README dentro do diretório amazon_keypair).

Avaliaremos sua submissão como se fosse um produto mínimo viável (MVP), pronto para ser publicado em produção, mas que continuará sendo expandido e mantido no futuro. A avaliação terá como foco as seguintes características:

* se atende aos requisitos básicos.
* a qualidade do código, do projeto de software, da arquitetura.
* os testes.
* a automação.
* a escalabilidade.

Em caso de dúvidas, pergunte.

## O Aplicativo

O aplicativo possui duas telas: uma listagem de jogos e o detalhe de cada jogo.

### Tela Inicial

- Lista de jogos
  - Nome dos times
  - Escudos
  - Placar
  - Data e horário

Considere as seguintes condições:

- A lista de jogos deve estar disponível offline

- O usuário pode querer atualizar a lista de jogos

- Clicar sobre um jogo leva o usuário para a tela de detalhe daquele jogo

Exemplo de uma lista de jogos na web (lado direito): [brasileirão série a](http://globoesporte.globo.com/futebol/brasileirao-serie-a/).

### Detalhe do Jogo

- Detalhe do jogo
  - Nome dos times
  - Escudos
  - Placar
  - Data e horário
  - Local

- Lance a Lance
  - Lista de momentos importantes do jogo
    - Tempo no jogo
    - Descrição

- Atalho para voltar para a tela inicial

## Imagens

Escudos dos times

```
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/vasco_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/avai_60x60_.png
http://s.glbimg.com/es/sde/f/equipes/2014/09/15/sport_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/internacional_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/palmeiras_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2015/05/06/chapecoense_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/atletico_mg_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/coritiba_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/gremio_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2015/04/29/cruzeiro_65.png
http://s.glbimg.com/es/sde/f/equipes/2015/06/24/atletico-pr_2015_65.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/sao_paulo_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/flamengo_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/corinthians_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/ponte_preta_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/figueirense_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/goias_60x60.png
http://s.glbimg.com/es/sde/f/equipes/2015/05/05/fluminense-escudo-65x65.png
http://s.glbimg.com/es/sde/f/equipes/2014/04/14/santos_60x60.png
```
