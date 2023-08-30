# API - Sistema de Monitoramento de Presenças

## Tecnologias Utilizadas
- Java 20
- Spring Boot 3.1.2
- Hibernate ORM
- PostgreSQL
- Spring Data JPA

## Sobre a API

A API tem como objetivo disponibilizar recursos para uma aplicação de manutenção de presenças em encontros de monitorias. Para isso, matém Monitorias e Alunos e seus relacionamentos.

## Funcionalidades/Rotas

Foram feitas rotas para manter Monitorias e Alunos, bem como para adicionar/remover presenças.

![Requisições](https://drive.google.com/uc?export=view&id=1S57NVVab1vKtSpfTJNux4iYv5Uv0uOZ5)

### Rotas:

- ```POST /monitoria/{idMonitoria}/aluno/{idAluno}```. 
    - Dar presença em uma monitoria para um aluno.
- ```DELETE /monitoria/{idMonitoria}/aluno/{idAluno}```. 
    - Retirar presença de uma monitoria de um aluno.

- ```POST /aluno```. 
    - Criar um aluno.
- ```GET /aluno```.
    - Listar todas as alunos.
- ```GET /aluno/{id}```.
    - Listar aluno por ID.
- ```PUT /aluno/{id}```.
    - Atualizar um aluno por ID.
- ```DELETE /aluno/{id}```.
    - Listar aluno por ID.

- ```POST /monitoria```. 
    - Criar uma monitoria.
- ```GET /monitoria```.
    - Listar todas as monitorias.
- ```GET /monitoria/{id}```.
    - Listar monitoria por ID.
- ```PUT /monitoria/{id}```.
    - Atualizar uma monitoria por ID.
- ```DELETE /monitoria/{id}```.
    - Listar monitoria por ID.

Abaixo, segue um exemplo de adição de presença para um aluno:

![Requisições](https://drive.google.com/uc?export=view&id=1guicuPOslWIgxsfLAnhMyuFhqLRHF0Bv)


## Autor

| [<img src="https://avatars3.githubusercontent.com/u/31678236?s=400&v=4" width=115><br><sub>@PauloVLB</sub>](https://github.com/PauloVLB) | 
| :---: | 