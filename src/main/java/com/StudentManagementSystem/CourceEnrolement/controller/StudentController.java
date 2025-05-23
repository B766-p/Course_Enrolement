package com.StudentManagementSystem.CourceEnrolement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.servicelayer.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Create new student
    @PostMapping
    public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> updateStudent(
            @PathVariable int id, @RequestBody Student student) {
        student.setId(id); // Make sure ID is set for update
        return studentService.updateStudent(student);
    }
    //update Student without id
    @PutMapping
    public ResponseEntity<ResponseStructure<Student>> updateStudent( @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Void>> deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

    // Get courses by student ID
    @GetMapping("/{id}/courses")
    public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}
