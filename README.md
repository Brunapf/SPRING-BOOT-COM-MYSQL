# SPRING-BOOT-COM-MYSQL
Sistema com spring-boot + MYSQL + docker-compose e REST para listar, inserir e atualizar informações no banco de dados, usando a linguagem Java.
Através de um script no caminho: \src\main\resources chamado schema.sql o  hibernate vai criar as tabelas no banco ao subir a aplicação.
Para rodar o sistema execute os comandos abaixo na pasta raiz do projeto.

## compilar o projeto (através do maven wrapper)
```sh
./mvnw.cmd clean install
```sh

## Subindo a aplicação com Docker-compose
```sh
docker-compose up --build --force-recreate
```sh
Através do Navegador ou Postman faça as requisições através da porta 8080.
```sh
localhost:8080/
```sh
