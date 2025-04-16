# 🧠 AI Resume Backend – Microservices Architecture

This project leverages a microservices architecture to build an AI-driven resume builder and analyzer. The backend is powered by Spring Boot, with various services performing distinct tasks like resume generation, subscription management, and authentication/ authorization.

---

## 🚀 Project Structure

The project consists of several services, including:

- **API-Gateway**: Handles routing between services.
- **DB**: Contains the database configurations and data persistence logic.
- **Eureka-Server**: Service registry for microservices discovery.
- **ImageGenerator [Auth Service]**: Responsible for generating resume-related images.
- **Resume-Builder-Service**: Core service for building resumes and providing analysis.
- **Subscription-Service**: Handles user subscriptions and management.


---

## 🛠️ Tech Stack

- **Backend**: Java, Spring Boot, Spring Cloud, Spring Security, Spring Data, Ollama
- **Microservices**: Eureka Server, API Gateway (Spring Cloud Gateway)
- **Database**: PostgreSQL, MongoDB
- **Cache**: Redis
- **Authentication**: JWT, Spring Security
- **Containerization**: Docker
- **API Gateway**: Spring Cloud Gateway
- **Service Discovery**: Eureka
- **Communication**: RESTful APIs (JSON)

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ai-resume-backend.git
cd ai-resume-backend
