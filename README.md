# Spring Security JPA
This repository is a simple Spring Boot application that shows how to implement security features using Spring Security and JPA authentication and MySQL. The application includes user authentication and role-based authorization, allowing users to access specific endpoints based on their roles.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Folder Structure](#folder-structure)
- [API Endpoints](#api-endpoints)
- [SQL Scripts](#sql-scripts)
- [Postman Collection](#postman-collection)

## Technologies Used

- **Spring Security**: Provides authentication and authorization features.
- **User Authentication**: Users can log in using their username and password.
- **Role-Based Authorization**: Different roles (e.g., USER and ADMIN) can access specific API endpoints.
- **JPA (Java Persistence API)**: Interface for managing relational data.
- **MySQL**: The database used to store user information.
- **Postman**: Tool for testing API endpoints.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Amiraelhoufy/spring-security-jpa.git
   cd spring-security-jpa```

2. **Open the project in your preferred IDE (such as IntelliJ IDEA or Eclipse)**
3. **Run the application:**
   - Execute the main method in the SpringSecurityJpaApplication class.
     
4. **Access the application:**
    - Open your web browser and navigate to ```http://localhost:8080```


## Getting Started

   ```bash
spring-security-jpa/
│
├── src/                         # Source code for the application
│   ├── main/
│   │   ├── java/                # Java source files
│   │   └── resources/           # Configuration files and templates
│   └── test/                    # Test files
│
├── sql/                         # SQL scripts for database setup
│   ├── schema.sql               # SQL schema file
│   └── data.sql                 # Sample data file
│
├── postman/                     # Postman collection files for API testing
│   └── spring-security-jpa.postman_collection.json  # Postman collection file
│
├── .gitignore                   # Git ignore file
└── application.properties        # Configuration file for the application

```



## API Endpoints

- GET ```/api/v1/users``` - Retrieve all users.
- POST ```/api/v1/users``` - Create a new user.
- GET ```/login``` - Login page (handled by Spring Security).
- GET ```/``` - Home page (welcome message).

## SQL Scripts

The sql folder contains SQL scripts for setting up the database. You can execute schema.sql to create the necessary tables and data.sql to insert sample data for testing.


## Postman Collection

A Postman collection is included in the postman folder for easy testing of the API endpoints. You can import this collection into Postman to quickly test the application's functionality.


