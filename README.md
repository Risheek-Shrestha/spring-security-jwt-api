# 🔐 Secure REST API — Spring Boot JWT Authentication

A production-ready Spring Boot REST API with JWT-based authentication and authorization. Users can register, login, and access protected endpoints using Bearer tokens.

## 🌐 Live Demo
Test with Postman or any HTTP client at `http://localhost:8080` after running locally.

## 🛠️ Tech Stack

Java 21 · Spring Boot 3.5.14 · Spring Security · JWT (jjwt 0.11.5)
Spring Data JPA · PostgreSQL · Lombok · Maven

## 🔑 How JWT Authentication Works
1. User registers → password hashed with BCrypt → stored in DB
2. User logs in → credentials verified → JWT token returned
3. User sends token in every request → Authorization: Bearer <token>
4. JwtAuthFilter validates token → request allowed or rejected

## 📌 API Endpoints

| Method | Endpoint | Auth Required | Description |
|--------|----------|---------------|-------------|
| POST | /api/auth/register | ❌ No | Register new user |
| POST | /api/auth/login | ❌ No | Login and get JWT token |
| GET | /api/books | ✅ Yes | Get all books |

## 📁 Project Structure
src/main/java/com/risheek/secureapi/
├── SecureapiApplication.java        # Entry point
├── User.java                        # User entity
├── UserRepository.java              # Database layer
├── CustomUserDetailsService.java    # Spring Security bridge
├── GlobalExceptionHandler.java      # Handle 403 response during login
├── JwtUtil.java                     # Token generation & validation
├── JwtAuthFilter.java               # Intercepts every request
├── SecurityConfig.java              # Security rules & filter chain
└── AuthController.java              # Register & Login endpoints

## ⚙️ Setup & Run Locally

1. Clone the repository
```bash
git clone https://github.com/Risheek-Shrestha/secureapi.git
```

2. Create PostgreSQL database
```sql
CREATE DATABASE securedb;
```

3. Create `application.properties` from the example
```bash
cp src/main/resources/application.properties.example \
   src/main/resources/application.properties
```

4. Fill in your credentials in `application.properties`

5. Run the application
```bash
./mvnw spring-boot:run
```

## 🧪 Testing with HTTP Client

**Step 1 — Register:**
POST /api/auth/register
Content-Type: application/json
{
"username": "risheek",
"password": "password123"
}

**Step 2 — Login (copy the token from response):**
POST /api/auth/login
Content-Type: application/json
{
"username": "risheek",
"password": "password123"
}

**Step 3 — Access protected endpoint:**
GET /api/books
Authorization: Bearer <paste token here>

**Without token → 401 Unauthorized**
**With valid token → 200 OK**

## 🔒 Security Implementation

| Component | Purpose |
|---|---|
| `BCryptPasswordEncoder` | Hashes passwords — one way, never decrypted |
| `JwtUtil` | Generates and validates JWT tokens |
| `JwtAuthFilter` | Runs before every request, validates Bearer token |
| `SecurityConfig` | Defines public vs protected routes |
| `CustomUserDetailsService` | Bridges Spring Security with database |

## 👨‍💻 Author

**Risheek Shrestha**
- GitHub: [@Risheek-Shrestha](https://github.com/Risheek-Shrestha)
- Email: shrestharisheek@gmail.com