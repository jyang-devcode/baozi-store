Baozi Store

API REST para gerenciamento de uma loja de baozi, desenvolvida com Java e Spring Boot, utilizando MySQL para persistência dos dados.

Tecnologias utilizadas

Java 26

Spring Boot 4.1.1

Maven

Spring Data JPA

Spring Web MVC

Bean Validation

MySQL

Postman

Funcionalidades

Clientes

Cadastrar clientes.

Listar todos os clientes.

Consultar cliente por ID.

Atualizar dados de clientes.

Excluir clientes.

Validar o preenchimento do nome.

Produtos

Cadastrar produtos.

Listar todos os produtos.

Consultar produto por ID.

Atualizar dados de produtos.

Excluir produtos.

Validar nome e preço.

Impedir pedidos de produtos indisponíveis.

Pedidos

Cadastrar pedidos.

Listar todos os pedidos.

Consultar pedido por ID.

Excluir pedidos.

Validar quantidade e IDs informados.

Verificar a existência do cliente e do produto antes de criar o pedido.

Configuração do banco de dados

Crie um banco de dados MySQL com o nome:
CREATE DATABASE baozi_store;

Configure as credenciais de acesso no arquivo src/main/resources/application.properties.

Exemplo:
spring.datasource.url=jdbc:mysql://localhost:3306/baozi_store
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true




Como executar o projeto

Instale o Java e o MySQL.

Configure o banco de dados e as credenciais.

Abra o terminal na pasta que contém o arquivo pom.xml.

Execute:

No Windows:
.\mvnw.cmd spring-boot:run

A API ficará disponível em:
http://localhost:8080

Endpoints da API

Método
POST        /clientes     Cadastrar cliente
GET        /clientes      Listar clientes
GET       /clientes/{id}  Consultar cliente
PUT      /clientes/{id}   Atualizar cliente
DELETE  /clientes/{id}    Excluir cliente
POST   /produtos          Cadastrar produto
GET   /produtos           Listar produtos
GET  /produtos/{id}       Consultar produto
PUT /produtos/{id}        Atualizar produto
DELETE /produtos/{id}     Excluir produto
POST  /pedidos            Cadastrar pedido
GET  /pedidos             Listar pedidos
GET /pedidos/{id}         Consultar pedido
DELETE /pedidos/{id}      Excluir pedido



Validações e respostas HTTP

A API utiliza validações para impedir dados inválidos, como nomes vazios, preços não positivos e quantidades de pedidos menores que um.

Principais códigos HTTP:

200 OK: consulta ou atualização concluída.
201 Created: registro criado.
204 No Content: registro excluído.
400 Bad Request: dados inválidos.
404 Not Found: cliente, produto ou registro não encontrado.
409 Conflict: produto indisponível para pedidos.


Testes

Os endpoints foram testados no Postman, incluindo cenários de sucesso e de erro de validação.
As evidências dos testes podem ser organizadas em uma pasta de documentação do projeto.


Estrutura do projeto

baozi-store/
── src/
   ├── main/
   │   ├── java/com/baozistore/
   │   │   ├── controller/
   │   │   ├── model/
   │   │   ├── repository/
   │   │   └── BaoziStoreApplication.java
   │   └── resources/
   │       ── application.properties
   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

