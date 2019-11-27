# Trabalho para a disciplina de Engenharia de Software III do IFRS Campus Porto Alegre

## Dependências
- JDK 8
- CLI do Angular
- Node 12

## Como executar
Para executar o projeto basta executar o comando a seguir:
```
./mvnw spring-boot:run
```

## Como acessar
Acessar a aplicação pela seguinte URL:

http://localhost:8080/

## Documentação da API
A documentação pode ser acessada pela seguinte URL:

http://localhost:8080/swagger-ui.html

## Ambientes

__Produção__

Endereço: https://gerenciador-proposta-api.herokuapp.com/swagger-ui.html#/


### Regras para Commit, Branch e Pull Request

Nosso padrão de commit consiste no número da história no github e quem desenvolveu:

```sh
03/@fulana,@ciclana: Adiciona header
```

A nomenclatura segue um padrão similar, com o número da história e uma breve descrição:

```sh
03/configura-layout
```

O repositório não permite fazer push direto para a `master`. Todas mudanças devem ser feitas através de Pull Requests, passando por uma revisão de código por parte do time. Sugerimos adicionar uma descrição ao pull request, descrevendo quais mudanças foram feitas.
