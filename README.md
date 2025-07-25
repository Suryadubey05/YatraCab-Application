# 🚖 YatraCab_App - Backend (Spring Boot)

**YatraCab_App** is a cab booking application built to provide fast, reliable, and user-friendly taxi services.  
This repository contains the **backend system** developed using **Spring Boot (Java)**, which handles user management, cab booking, ride history, driver data, and secure authentication.

---

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA
- **Security:** Spring Security with JWT
- **Build Tool:** Maven
- **API Documentation:** Swagger (OpenAPI)

---

## 📦 Features

- User registration and login with JWT authentication
- Role-based access for users, drivers, and admins
- Book a ride, cancel a ride, and view ride history
- Manage cabs and driver profiles
- RESTful API with Swagger documentation
- Secure password hashing and data validation

---


## Suryakant Dubey
📧 Suryakant231216@gmail.com


## 🚀 Getting Started

### 1. Clone the Repository

## paste code in your application.properties
```
spring.dataSource.url=jdbc:mysql://localhost:3306/yatra_cab?createTableIfNotExists=true
spring.dataSource.username=Enter Your DB Username
spring.dataSource.password= Enter Your DB Password
spring.jpa.hibernate.ddl-auto=update


#SMTP Properties
spring.mail.host = smtp.gmail.com
spring.mail.port = 587
spring.mail.username = Enter Your EmailId
spring.mail.password = Enter your app Password
spring.mail.properties.mail.smtp.auth = true
spring.mail.properties.mail.smtp.starttls.enable = true
```



```bash
git clone https://github.com/yourusername/YatraCab_Application.git
cd YatraCab_Application
