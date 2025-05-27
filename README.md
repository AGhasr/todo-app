# Todo List Application

A simple Spring Boot-based web application for managing todo items with CRUD operations.

## 📌 Features
- Create new todo items
- Edit existing items
- Mark items as complete/incomplete
- Delete items
- Validation for required fields
- Responsive UI with Bootstrap
- Persistent storage with JPA/Hibernate

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
Run the application:

```bash
mvn spring-boot:run
```
Access the application at: http://localhost:8080

## API Endpoints

| Method | Path           | Description      |
|--------|----------------|------------------|
| GET    | `/`            | Show all todos   |
| GET    | `/create-todo` | Show create form |
| POST   | `/todo`        | Create new todo  |
| GET    | `/edit/{id}`   | Show edit form   |
| POST   | `/todo/{id}`   | Update todo      |
| GET    | `/delete/{id}` | Delete todo      |


## Technology Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (embedded)
- Thymeleaf
- Bootstrap 5
- Maven

## 📂 Project Structure

```
├── controller     # Web controllers
├── model          # Entity class
├── repository     # Spring Data JPA repo
├── service        # Business logic
├── templates      # Thymeleaf HTML templates
├── TodoApplication.java # Main entry point
```
## ⚙️ Configuration
The app uses an in-memory H2 database with development settings predefined in:
```text
src/main/resources/application.properties
```

Key settings include:

- spring.datasource.url=jdbc:h2:mem:testdb
- spring.h2.console.enabled=true
- spring.jpa.hibernate.ddl-auto=update
- spring.thymeleaf.cache=true

You can access the H2 console at:
http://localhost:8080/h2-console
(Username: sa, Password: leave blank)