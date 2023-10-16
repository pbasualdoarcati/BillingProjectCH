# Final billing project

![Java 17](https://img.shields.io/badge/Java-17-red) ![Spring Boot 3.1.3](https://img.shields.io/badge/Spring%20Boot-3.1.3-green)

## Project Description

This Java Spring Boot project is based on the Java programming course offered by Coder House. You can find more information about the course [here](https://www.coderhouse.com/online/programacion-con-java). The primary goal of this project is to implement an invoicing system using Spring Boot technologies.

## Author

[**Pablo Basualdo Arcati**](https://github.com/pbasualdoarcati)

## Technologies Used

- Spring Boot Starter Actuator
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database (runtime)
- SpringDoc OpenAPI Starter WebMvc UI (version 2.1.0)

The following describes the purpose of each dependency used in the project:

- `spring-boot-starter-actuator`: Provides endpoints for monitoring the Spring Boot application.
- `spring-boot-starter-data-jpa`: Facilitates integration with databases using JPA (Java Persistence API).
- `spring-boot-starter-web`: Offers tools to build web applications.
- `h2`: In-memory database used for development (runtime).
- `springdoc-openapi-starter-webmvc-ui` (version 2.1.0): Generates OpenAPI documentation for the web API.

## Endpoints

### Product

- **POST** `/api/product/`: Save a product.
- **GET** `/api/product/{id}`: Get a product by its ID.
- **GET** `/api/product/all`: Get all products.

### Invoice

- **GET** `/api/invoice/`: Get all invoices.
- **POST** `/api/invoice/`: Create an invoice with details.
- **GET** `/api/invoice/{id}`: Get an invoice by its ID.

### Client

- **GET** `/api/client/`: Get all clients.
- **POST** `/api/client/`: Save a client.
- **GET** `/api/client/{id}`: Get a client by its ID.

## Examples of POST Requests

Here are examples of POST requests to create clients, products, and invoices:

**Example of POST to create a client:**

```json
POST /api/client/
{
  "clientName": "Test",
  "clientLastname": "Test apellido",
  "docnumber": "1231546"
}

POST /api/product/
{
  "description": "widget",
  "code": "W002",
  "stock": 100,
  "price": 2.25
}

POST /api/invoice/
{
  "client": {
    "clientId": 2
  },
  "invoiceDetails": [
    {
      "amount": 5,
      "product": {
        "productId": 1
      }
    },
    {
      "amount": 3,
      "product": {
        "productId": 2
      }
    }
  ]
}

```
