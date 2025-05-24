# 🎓 Course Enrollment System (Spring Boot)

This is a RESTful Spring Boot project for managing an educational course enrollment system. It handles core entities such as Students, Courses, Instructors, and Enrollments with full CRUD functionality and proper entity relationships.

---

## 📌 Features

- Full CRUD operations for Students, Courses, Instructors, and Enrollments
- Enroll students into courses
- Get all students under an instructor
- Get all courses taught by an instructor
- Get all enrollments for a student or a course
- Proper RESTful API design and separation of concerns

---

## 🧩 Entity Relationship Diagram

+------------------+ +--------------------+ +------------------+
| Student | | Course | | Instructor |
+------------------+ +--------------------+ +------------------+
| id |<--------->| id |<--------->| id |
| name | | name | | name |
| enrollments(List)| | instructor_id | | courses (List) |
+------------------+ | enrollments(List) | +------------------+
| | |
| One-to-Many | One-to-Many | One-to-Many
v v v
+--------------------+
| Enrollment |
+--------------------+
| id |
| student_id |
| course_id |
| enrollment_date |
+--------------------+

---

## 🌐 API Endpoints

### 📚 CourseController

| Method | Endpoint                                | Description                                |
|--------|-----------------------------------------|--------------------------------------------|
| POST   | `/courses`                              | Add a new course                           |
| GET    | `/courses`                              | Get all courses                            |
| GET    | `/courses/{id}`                         | Get a specific course by ID                |
| PUT    | `/courses`                              | Update a course                            |
| DELETE | `/courses/{id}`                         | Delete a course by ID                      |
| GET    | `/courses/instructor/{instructorId}`    | Get all courses taught by an instructor    |

---

### 👨‍🏫 InstructorController

| Method | Endpoint                              | Description                            |
|--------|---------------------------------------|----------------------------------------|
| POST   | `/instructors`                        | Add a new instructor                   |
| GET    | `/instructors`                        | Get all instructors                    |
| GET    | `/instructors/{id}`                   | Get a specific instructor by ID        |
| PUT    | `/instructors`                        | Update an instructor                   |
| DELETE | `/instructors/{id}`                   | Delete an instructor by ID             |
| GET    | `/instructors/{id}/students`          | Get all students under an instructor   |

---

### 👨‍🎓 StudentController

| Method | Endpoint                            | Description                              |
|--------|-------------------------------------|------------------------------------------|
| POST   | `/students`                         | Add a new student                        |
| GET    | `/students`                         | Get all students                         |
| GET    | `/students/{id}`                    | Get a specific student by ID             |
| PUT    | `/students/{id}`                    | Update student by ID                     |
| PUT    | `/students`                         | Update student (alternative method)      |
| DELETE | `/students/{id}`                    | Delete a student by ID                   |
| GET    | `/students/{id}/courses`            | Get all courses enrolled by a student    |

---

### 📝 EnrolmentController

| Method | Endpoint                              | Description                            |
|--------|---------------------------------------|----------------------------------------|
| POST   | `/enrolments`                         | Add a new enrollment                   |
| GET    | `/enrolments`                         | Get all enrollments                    |
| GET    | `/enrolments/{id}`                    | Get enrollment by ID                   |
| PUT    | `/enrolments/{id}`                    | Update enrollment by ID                |
| DELETE | `/enrolments/{id}`                    | Delete enrollment by ID                |
| GET    | `/enrolments/student/{studentId}`     | Get all enrollments for a student      |
| GET    | `/enrolments/course/{courseId}`       | Get all enrollments for a course       |

---

## ⚙️ Technologies Used

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Maven**
- **H2 Database** *(or MySQL, configurable in `application.properties`)*

---

## 🛠 How to Run

### 📦 Prerequisites

- Java JDK 17+
- Maven
- IDE (IntelliJ / Eclipse / VS Code)

### 🚀 Steps to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/B766-p/Course_Enrolement.git
   cd Course_Enrolement
   mvn spring-boot:run
