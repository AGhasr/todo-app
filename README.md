# Todo List Application

A simple Spring Boot-based web application for managing todo items with CRUD operations.

## 📌 Features

- Create, update, delete, and view todo items
- Uses H2 in-memory database (default)
- Timestamps for creation and update
- Bootstrap for responsive UI
- Validation for required fields

## Prerequisites
- Java 17+
- Maven 3.8+
- Your favorite IDE (IntelliJ, Eclipse, etc.)
- Database (H2 in-memory configured by default)

## Installation & Running
1. Clone the repository
2. Build the project:
```bash
mvn clean install
```
## Run the application:

```bash
mvn spring-boot:run
```
Access the application at: http://localhost:8080

## API Endpoints

| Method | Path         | Description      |
|--------|--------------|------------------|
| GET    | /            | Show all todos   |
| GET    | /create-todo | Show create form |
| POST   | /todo        | Create new todo  |
| GET    | /edit/{id}   | Show edit form   |
| POST   | /todo/{id}   | Update todo      |
| GET    | /delete/{id} | Delete todo      |


## Technology Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (embedded)
- Thymeleaf
- Bootstrap 5
- Maven
