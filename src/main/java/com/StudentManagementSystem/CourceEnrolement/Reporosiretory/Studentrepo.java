package com.StudentManagementSystem.CourceEnrolement.Reporosiretory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;

public interface Studentrepo extends JpaRepository<Student, Integer> {
@Query("SELECT e.course FROM Enrolment e WHERE e.student.id =?1")
List<Course> getCourceByStudentId(int id);
}
