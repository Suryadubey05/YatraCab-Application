# 🚖 YatraCab_App - Backend (Spring Boot)

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-informational)](LICENSE)

**YatraCab_App** is a cab booking application built to provide fast, reliable, and user-friendly taxi services.  
This repository contains the **backend system** developed using **Spring Boot (Java)**, which handles user management, cab booking, ride history, driver data, and secure authentication.

---

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA
- **Security:** Spring Security with JWT
- **Email Integration:** JavaMailSender
- **Build Tool:** Maven
- **API Documentation:** Swagger (OpenAPI)

---

## 📦 Features

- ✅ User registration 
- ✅ Role-based access (Driver, Customer)
- ✅ Book, cancel, and track cab rides
- ✅ View ride history & cab availability
- ✅ Manage drivers and cab information
- ✅ Swagger API documentation
- ✅ Email notifications (e.g. booking confirmation)

---

## 🔐 API Endpoints Overview

- `POST /auth/register/customer` – Register a new user
- `POST /auth/register/driver` – Login and receive JWT token
- `GET /customer/rides` – Get customer ride history
- `POST /booking/book` – Book a new cab
- `PUT /driver/update/{id}` – Update driver details
- `DELETE /booking/cancel/{id}` – Cancel a ride
- …and many more!

- 📘 **Full documentation is available at Swagger UI (localhost):**
- ```
  http://localhost:8080/swagger-ui/index.html
  ```

---

## 🖼️ Screenshots

### 🔍 Swagger UI – All API Endpoints

###Customer API's
<img width="743" height="203" alt="Customer API's" src="https://github.com/user-attachments/assets/ff6d311f-5c6a-4eda-b2e9-d3a12d698630" />

###Driver API's
<img width="719" height="112" alt="Driver API's" src="https://github.com/user-attachments/assets/773108d3-cbd9-4fb6-b5f0-e863439d24ef" />

###Cab API's
<img width="725" height="53" alt="Cab API's" src="https://github.com/user-attachments/assets/76832f2f-0a5a-409f-915f-30356db5e58a" />

###Booking API's
<img width="714" height="52" alt="Booking API's" src="https://github.com/user-attachments/assets/4504c849-7f38-4ad7-b9a2-45c331e2eefe" />

### Schemas of all API's
<img width="734" height="284" alt="Schemas" src="https://github.com/user-attachments/assets/2a910ff2-0788-425f-9262-86da763849ea" />




### 🗃️ Database Entity Relationship Diagram

###Customer Database
<img width="265" height="88" alt="CustomerDB" src="https://github.com/user-attachments/assets/ef2bac85-65ef-4c25-87f8-a9a6e14267b3" />

###Driver Database
<img width="259" height="79" alt="DriverDB" src="https://github.com/user-attachments/assets/9720792f-38c2-4b13-b0bd-351e6afceaed" />

###Cab Database
<img width="252" height="122" alt="CabDB" src="https://github.com/user-attachments/assets/1970976d-bb81-4dd3-adc4-926ea2a11f32" />

###Bookings Database
<img width="650" height="113" alt="BookingDB" src="https://github.com/user-attachments/assets/8e1c1434-fbda-42f3-bbf6-fd91f3c98858" />




  
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
