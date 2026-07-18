# 🚀 DevForge AI

> AI-Powered Multi-Language Code Review Platform

DevForge AI is an AI-powered backend application that helps developers receive instant code reviews for multiple programming languages using Large Language Models (LLMs).

The application analyzes submitted source code, generates intelligent suggestions, stores review history in PostgreSQL, and exposes REST APIs documented with Swagger.


🌐 **Live Demo:** https://devforge-ai-backend-2.onrender.com

📖 **Swagger UI:** https://devforge-ai-backend-2.onrender.com/wagger-ui/index.html



---

# 🌟 Features

- 🤖 AI-powered code review
- 💻 Multi-language support (Java, Python, JavaScript, C++, etc.)
- 📄 Instant code improvement suggestions
- 🗄️ Stores review history in PostgreSQL
- 📚 Swagger/OpenAPI documentation
- ☁️ Cloud deployed on Render
- 🐳 Dockerized deployment
- ⚡ RESTful API architecture

---

# 🛠 Tech Stack

| Technology | Usage |
|------------|-------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Layer |
| PostgreSQL (Neon) | Cloud Database |
| OpenRouter API | AI Code Review |
| Docker | Containerization |
| Render | Cloud Deployment |
| Swagger/OpenAPI | API Documentation |
| Maven | Build Tool |

---

# 🏗 System Architecture

```

Developer
│
▼
POST /api/reviews
│
▼
Spring Boot Backend
│
▼
Review Service
├──────────────┐
▼ ▼
OpenRouter AI PostgreSQL
│ │
└──────┬───────┘
▼
AI Review Response
│
▼
Render Deployment

```

---

# 📌 API Endpoints

## Generate AI Review

POST

```

/api/reviews

```

Request

```json
{
  "language": "Java",
  "code": "public class Test { public static void main(String[] args){ System.out.println(\"Hello\"); }}"
}
```

Response

```json
{
  "review": "AI generated review..."
}
```

---

## Get All Reviews

GET

```

/api/reviews

```

---

# 📖 API Documentation

Swagger UI

```

/swagger-ui/index.html

```

---

# 🚀 Deployment

- Backend deployed on **Render**
- Database hosted on **Neon PostgreSQL**
- AI powered by **OpenRouter**

---

# 📂 Project Structure

```

src
├── controller
├── service
├── repository
├── entity
├── dto
├── ai
├── config
└── exception

```

---

# ⚙ Environment Variables

```properties
DB_URL=

DB_USERNAME=

DB_PASSWORD=

OPENROUTER_API_KEY=
```

---

# ▶ Running Locally

```bash
git clone -  https://github.com/ashikaushik9955-ai/devforge-ai-backend

cd devforge-ai-backend

./mvnw spring-boot:run
```

---

# 🔮 Future Enhancements

- JWT Authentication
- Role-Based Authorization
- User Dashboard
- Review History UI
- GitHub Integration
- VS Code Extension
- Team Collaboration
- Resume & Code Quality Analytics

---

# 👩‍💻 Author

**Ashi Kaushik**

Java Backend Developer | AI Enthusiast

---

# ⭐ If you found this project interesting, consider giving it a star!
