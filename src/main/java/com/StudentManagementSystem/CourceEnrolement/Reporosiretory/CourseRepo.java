package com.StudentManagementSystem.CourceEnrolement.Reporosiretory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>  {
List<Course> findByInstructorId(int id);
}
