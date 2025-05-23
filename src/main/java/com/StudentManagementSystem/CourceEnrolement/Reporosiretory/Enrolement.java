package com.StudentManagementSystem.CourceEnrolement.Reporosiretory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Enrolment;

public interface Enrolement extends JpaRepository<Enrolment, Integer> {
	List<Enrolment> findByStudentId(int id);
	List<Enrolment> findByCourseId(int id);
}
