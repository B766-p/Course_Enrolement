package com.StudentManagementSystem.CourceEnrolement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.servicelayer.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // Create a new course
    @PostMapping
    public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    // Get all courses
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses() {
        return service.getAllCourses();
    }

    //Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Course>> getCourseById(@PathVariable int id) {
        return service.getCourseById(id);
    }
    @PutMapping
    public ResponseEntity<ResponseStructure<Course>> updateCourse( @RequestBody Course course) {
        return service.updateCourse(course);
    }

    //Delete course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Void>> deleteCourse(@PathVariable int id) {
        return service.deleteCourse(id);
    }

    //Get courses by instructor ID
    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByInstructorId(@PathVariable int instructorId) {
        return service.getCoursesByInstructorId(instructorId);
    }
}
