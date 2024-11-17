
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto

Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 17 e Spring Boot 3.2.5.

## Funcionalidades

- **Consulta de Produtos**: Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
- **Integração com `OpenFeign`**: Utiliza `Feign Clients` para realizar chamadas HTTP.
- **Validação de Dados**: Validação de dados de entrada usando Bean Validation (`javax.validation`).
- **Testes Unitários**: Inclui testes de integração utilizando `@SpringBootTest` e testes  unitários desenvolvidos com JUnit 5 e Mockito.

## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── RestTemplateConfig.java
│   │   │       ├── controller
│   │   │       │   └── ProductController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.yaml
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── config
│       │       │   └── RestTemplateConfigTest.java
│       │       └── controller
│       │       │   └── ProductControllerTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
│       │       └── service
│       │           └── ProductServiceTest.java
│       └── resources
└── pom.xml
```

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven 3.8.x**

### Clone o repositório:

    ```bash
    git clone https://github.com/ChristianSangenito/code-challenge-migration.git
    cd code-challenge-migration
    ```

### Executar a Aplicação no Eclipse

Importar a aplicação no Eclipse:

    -> Botão direito em Project Explorer
    -> Import
    -> Existing Maven Project
    -> Procure a pasta do seu projeto e clique em 'Finish'
 
Adicionar variáveis de ambiente no Eclipse:

    -> Pressione Ctrl+3
    -> Escreva 'Debug Configurations'
    -> Selecione a opção sob "menus"
    -> Na janela a seguir, clique na aba Environment
    -> Adicione os seguintes valores:

**Variable** dummyjson.server.url<br>
**Value** https://dummyjson.com<br>

**Variable** management.endpoint.health.enabled<br>
**Value** true<br>

**Variable** management.endpoints.web.base-path<br>
**Value** /actuator<br>

**Variable** server.port<br>
**Value** 8080<br>

Executar a aplicação no Eclipse:

    -> Clicar com o botão direito na DummyJsonClientApplication.java
    -> Run As
    -> Java Application

Acesse o serviço:

    endpoint health:
    http://localhost:8080/actuator/health

    endpoint get all products:
    http://localhost:8080/api/products

    endpoint get product by id:
    http://localhost:8080/api/products/1s


### Executar a Aplicação no CMD

Compile o projeto:

    ```
    mvn clean install
    ```
Execute os seguintes comandos para adicionar as variáveis de ambiente

	```
	SET SERVER_PORT=8080
	SET MANAGEMENT_ENDPOINT_HEALTH_ENABLED=true
	SET MANAGEMENT_ENDPOINTS_WEB_BASE-PATH=/actuator
	SET DUMMYJSON_SERVER_URL=https://dummyjson.com 
	```
   
execute o projeto:

    ```
    mvn spring-boot:run
    ```

Acesse o serviço:

    endpoint health:
    http://localhost:8080/actuator/health

    endpoint get all products:
    http://localhost:8080/api/products

    endpoint get product by id:
    http://localhost:8080/api/products/1


### Executar a Aplicação no Docker

No diretório raiz da aplicação:

Gerar o JAR da aplicação
     
     mvn clean package

Construir a Imagem Docker

	 docker build -t dummyjson-client .

Rodar o contêiner

    docker run --env-file .env -p 8080:8080 dummyjson-client
    
Acesse o serviço:

    endpoint health:
    http://localhost:8080/actuator/health

    endpoint get all products:
    http://localhost:8080/api/products

    endpoint get product by id:
    http://localhost:8080/api/products/1

### Executar Testes

Para executar os testes unitários:

```bash
mvn clean test
```