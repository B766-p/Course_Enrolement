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
import com.StudentManagementSystem.CourceEnrolement.Entity.Instructor;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.servicelayer.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @PostMapping
    public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(@RequestBody Instructor instructor) {
        return service.saveInstructor(instructor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(@PathVariable int id) {
        return service.getInstructorById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructors() {
        return service.getAllInstructors();
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Instructor>> updateInstructor( @RequestBody Instructor instructor) {
        return service.updateInstructor(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Void>> deleteInstructor(@PathVariable int id) {
        return service.deleteInstructor(id);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByInstructorId(@PathVariable int id) {
        return service.getStudentsByInstructorId(id);
    }
}