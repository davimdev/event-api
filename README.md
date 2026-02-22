# Event API

REST API built with Spring Boot and PostgreSQL for event management.

## 🚀 Technologies

- Java 21
- Spring Boot
- PostgreSQL
- Maven
- Flyway Migration
- JPA/Hibernate
- HikariCP
- Tomcat

## 📦 Features

- Create event
- List events
- Update event
- Delete event
- Layered architecture

## 🔧 How to run locally

1. Clone the repository:

```bash
git clone https://github.com/davimdev/event-api.git
```

2. Configure your PostgreSQL database in `application.properties`

3. Run the application:

```bash
mvn spring-boot:run
```

## 🧪 Endpoints

- GET /events
- GET /events/{id}
- POST /events
- PUT /events/{id}
- DELETE /events/{id}
