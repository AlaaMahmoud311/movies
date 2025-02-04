#Movie App
Overview

This project is a Spring Boot application that provides backend support for user registration, login, and movie management. It features a secure and robust authentication system using JSON Web Tokens (JWT) and role-based access control. The database is implemented using JPA and Hibernate for persistence.

Table of Contents

Project Structure

Features

Entities

Endpoints

Technologies Used

Setup

Project Structure

The application is organized into the following layers:

Controller Layer: Handles HTTP requests and responses (e.g., AuthController, UserController).

Service Layer: Contains business logic (e.g., AuthService, UserService, RoleService).

Repository Layer: Interfaces with the database using JPA repositories (e.g., UserRepository, RoleRepository, MovieRepository).

Security Layer: Configures authentication and authorization using Spring Security and JWT.

Entity Layer: Defines the database schema and relationships (e.g., UserEntity, Role, Movie).

Features

User Registration: Allows new users to register with a unique email and password. Passwords are hashed using BCrypt.

User Login: Authenticates users and provides a JWT token.

Role-Based Access Control: Assigns roles (e.g., ADMIN, USER) to users and restricts access to endpoints based on roles.

Movie Management: Users can manage a list of movies using the provided API.

Error Handling: Custom exception handling for better user experience.

Entities

1. UserEntity

Fields: id, name, email, password, roles, movies

Relationships:

Many-to-Many with Role

Many-to-Many with Movie

2. Role

Fields: id, name, users

Relationships:

Many-to-Many with UserEntity

3. Movie

Fields: imdbId, title, year, poster

Endpoints

Authentication Endpoints

POST /api/v1/auth/register

Description: Register a new user.

Request Body:

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "confirmPassword": "password123"
}

Response:

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}

POST /api/v1/auth/login

Description: Authenticate a user and return a JWT token.

Request Body:

{
  "email": "john.doe@example.com",
  "password": "password123"
}

Response:

{
  "email": "john.doe@example.com",
  "token": "<JWT_TOKEN>"
}

User Management Endpoints

GET /api/v1/users

Description: Fetch all users. (Admin-only)

Response:

[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
]

GET /api/v1/users/{userId}

Description: Fetch a user by ID.

Technologies Used

Spring Boot: For building the backend application.

Spring Security: For authentication and authorization.

JSON Web Tokens (JWT): For secure token-based authentication.

JPA/Hibernate: For ORM and database interaction.

MySQL: Database for storing user and movie data.

Lombok: For reducing boilerplate code.

Setup

Prerequisites

Java 17 or higher.

MySQL database.

Maven for dependency management.

Steps to Run

Clone the repository:

git clone <repository-url>

Configure application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/dashboard_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
JWT_SECRET=<your-secret-key>
JWT_EXPIRATION=<expiration-time-in-ms>

Build and run the application:

mvn spring-boot:run

The API will be available at http://localhost:8080.

Notes

Use Postman or a similar tool for testing endpoints.

Ensure that the database schema is created before running the application.

