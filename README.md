# Course Management API for LMS

## Overview

This project is a RESTful API for a Course Management System within a Learning Management System (LMS). The API supports user authentication, course management (CRUD operations), and progress tracking. 
It demonstrates the ability to manage databases, secure endpoints, and handle relationships between different entities.

## Features

- **User Authentication**: Register, login.
- **Course Management**: Create, read, update, and delete courses (CRUD operations).
- **Progress Tracking**: Track and update user progress in courses.

## Technologies Used

- **Backend**: Spring Boot
- **Database**: MySQL
- **Security**: Login Authentication
- **Dependencies**: Maven

## API Endpoints

### User Authentication

- `POST /register`: Register a new user (student or teacher).
- `POST /login`: Authenticate a user.

### Course Management

- `GET /courses`: Retrieve a list of all courses.
- `GET /courses/:id`: Retrieve details of a specific course.
- `POST /courses`: Create a new course.
- `PUT /courses/:id`: Update a course.
- `DELETE /courses/:id`: Delete a course.

### Progress Tracking

- `GET /users/:id/progress`: Retrieve progress for a specific user.
- `POST /users/:id/progress`: Update progress for a specific user.

## Database Schema

- **Users**: Stores user information, roles, and authentication details.
- **Courses**: Stores course details and links to lessons.
- **Lessons**: Stores individual lesson details.
- **Progress**: Tracks user progress in various courses.

### Relationships

- One-to-Many: Courses to Lessons.
- Many-to-Many: Users to Courses.

## Validation and Error Handling

- **Validation**: Request data is validated for all endpoints to ensure data integrity.
- **Error Handling**: Comprehensive error handling is implemented to return appropriate HTTP status codes and messages.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven/Gradle
- PostgreSQL/MySQL (choose one)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/course-management-api.git
    cd course-management-api
    ```

2. Configure the database:
    - Set up your PostgreSQL/MySQL database.
    - Update the `application.properties` or `application.yml` file with your database credentials.

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

5. The API will be available at `http://localhost:8080`.

### Running Tests

- Run the test suite:
    ```bash
    mvn test
    ```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.
