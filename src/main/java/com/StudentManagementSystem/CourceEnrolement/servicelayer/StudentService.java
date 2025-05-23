package com.StudentManagementSystem.CourceEnrolement.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.CourceEnrolement.DaoLayer.StudentDao;
import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.CourseNotFoundException;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.IdNotFoundExceptions;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.StudentNotFoundException;



@Service
public class StudentService {

    @Autowired
    private StudentDao dao;

    // Save student
    public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
        Student savedStudent = dao.saveStudent(student);

        ResponseStructure<Student> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Student saved successfully");
        response.setData(savedStudent);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all students
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        List<Student> students = dao.getAllStudents();
        if(students.isEmpty()) {
        	throw new StudentNotFoundException();
        }else {
        ResponseStructure<List<Student>> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("All students fetched successfully");
        response.setData(students);

        return new ResponseEntity<>(response, HttpStatus.OK);}
    }

    // Get student by ID
    public ResponseEntity<ResponseStructure<Student>> getStudentById(int id) {
        Optional<Student> studentOpt = dao.getStudentById(id);

        ResponseStructure<Student> response = new ResponseStructure<>();
        if (studentOpt.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Student found");
            response.setData(studentOpt.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
        throw new IdNotFoundExceptions();
        }
    }

    // Update student
    public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
        Student updated = dao.updateStudent(student);
        ResponseStructure<Student> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Student updated successfully");
        response.setData(updated);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete student
    public ResponseEntity<ResponseStructure<Void>> deleteStudent(int id) {
        dao.deleteStudent(id);
        Optional<Student> stu = dao.getStudentById(id);
        ResponseStructure<Void> response = new ResponseStructure<>();
        if (stu.isPresent()) {
        	 dao.deleteStudent(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Student deleted successfully");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
          throw new IdNotFoundExceptions();
        }
    }

    // Get Courses by Student ID
    public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByStudentId(int studentId) {
        List<Course> courses = dao.getCoursesByStudentId(studentId);
        if(courses.isEmpty()) {
        	throw new CourseNotFoundException();
        }else {
        ResponseStructure<List<Course>> response = new ResponseStructure<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Courses fetched for Student ID: " + studentId);
        response.setData(courses);

        return new ResponseEntity<>(response, HttpStatus.OK);}
    }
}
