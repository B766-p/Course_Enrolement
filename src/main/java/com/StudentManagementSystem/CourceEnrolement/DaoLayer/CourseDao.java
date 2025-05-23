package com.StudentManagementSystem.CourceEnrolement.DaoLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Reporosiretory.CourseRepo;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseDao {

    @Autowired
    private CourseRepo courseRepo;

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepo.findById(id);
    }

    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    public boolean deleteCourse(int id) {
        Optional<Course> optional = courseRepo.findById(id);
        if (optional.isPresent()) {
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Course> getCoursesByInstructorId(int instructorId) {
        return courseRepo.findByInstructorId(instructorId);
    }
}
