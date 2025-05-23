package com.StudentManagementSystem.CourceEnrolement.Reporosiretory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentManagementSystem.CourceEnrolement.Entity.Student;

public interface InstructorRp extends JpaRepository<com.StudentManagementSystem.CourceEnrolement.Entity.Instructor, Integer> {
	@Query("SELECT DISTINCT e.student FROM Enrolment e WHERE e.course.instructor.id =?1")
	List<Student> getStudentsByInstructorId(int Id);
}
