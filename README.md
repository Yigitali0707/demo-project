# 🛡️ RESTful API with JWT Authentication | Java + Spring Boot

This project is a secure RESTful API built with Java 17 and Spring Boot 2.7.x. It includes full CRUD operations and JWT-based authentication.

## 📌 Entities

- `User`
- `Role`
- `Country`
- `Region` (belongs to Country)
- `District` (belongs to Region)

---

## 🚀 Technologies Used

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT
- Lombok
- Swagger / OpenAPI
- Maven

---

## 🔐 Authentication

### ✅ Register

`POST /auth/register`

**Request:**
```json
{
  "username": "newuser",
  "password": "yourPassword"
}
```

> The user will be automatically assigned the role `ROLE_USER`.

---

### ✅ Login

`POST /auth/login`

**Request:**
```json
{
  "username": "newuser",
  "password": "yourPassword"
}
```

**Response:**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR..."
}
```

---

## 🔑 How to Use JWT Token

Include the token in each request header:

```
Authorization: Bearer <your_token>
```

### In Swagger UI:

1. Open Swagger at: `/swagger-ui.html` or `/swagger-ui/index.html`
2. Click the `Authorize` button
3. When using Swagger UI, simply paste the JWT token only (without Bearer prefix) into the Authorize dialog. The Bearer prefix will be added automatically.
4. Enter your token like this: 

eyJhbGciOiJIUzI1NiIsInR...(just the token)
```

---

## 🌐 Swagger Documentation

Access the API docs here:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🧾 API Endpoints (for each entity)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /api/{entity}       | Get paginated list |
| GET    | /api/{entity}/{id}  | Get by ID |
| POST   | /api/{entity}       | Create new entity |
| PUT    | /api/{entity}/{id}  | Update entity |
| DELETE | /api/{entity}/{id}  | Delete entity |

---

## 🧰 Features

✅ DTO and Mapper structure  
✅ Centralized error handling using `@ControllerAdvice`  
✅ Role-based authentication  
✅ Public `/auth/register` and `/auth/login` endpoints  
✅ All other endpoints are protected via JWT  
✅ Username must be unique

---

## 🗃️ Database Configuration (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/demo-project
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

> You can switch to a different DB engine by changing the connection string.

---

## ▶️ Run the Project

```bash
git clone https://github.com/yigitali0707/demo-project.git
cd demo-project
./mvnw clean install
./mvnw spring-boot:run
```

---

## 🧑 Author

**Name:** Yigitali Dalaboyev
**Email:** YigitaliDalaboyev@gmail.com  
**GitHub:** [github.com/yigitali0707](https://github.com/yigitali0707)

---

## ✅ Completed Requirements

- [✅] Register/Login with JWT
- [✅] CRUD operations for all entities
- [✅] Swagger UI documentation
- [✅] Token-based security
- [✅] DTO & Mapper usage
- [✅] Global Exception Handler
- [✅] Role-based access
