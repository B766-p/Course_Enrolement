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
import com.StudentManagementSystem.CourceEnrolement.Entity.Enrolment;
import com.StudentManagementSystem.CourceEnrolement.servicelayer.EnrolmentService;

@RestController
@RequestMapping("/enrolments")
public class EnrolmentController {

    @Autowired
    private EnrolmentService service;

    @PostMapping
    public ResponseEntity<ResponseStructure<Enrolment>> saveEnrolment(@RequestBody Enrolment enrolment) {
        return service.saveEnrolment(enrolment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Enrolment>> getEnrolmentById(@PathVariable int id) {
        return service.getEnrolmentById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Enrolment>>> getAllEnrolments() {
        return service.getAllEnrolments();
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Enrolment>> updateEnrolment(@PathVariable int id, @RequestBody Enrolment enrolment) {
        return service.updateEnrolment(enrolment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Void>> deleteEnrolment(@PathVariable int id) {
        return service.deleteEnrolment(id);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ResponseStructure<List<Enrolment>>> getEnrolmentsByStudentId(@PathVariable int studentId) {
        return service.getEnrolmentsByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<ResponseStructure<List<Enrolment>>> getEnrolmentsByCourseId(@PathVariable int courseId) {
        return service.getEnrolmentsByCourseId(courseId);
    }
}