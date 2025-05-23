package com.StudentManagementSystem.CourceEnrolement.DaoLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.Reporosiretory.Studentrepo;

@Repository
public class StudentDao {
	@Autowired
    private Studentrepo repo;
	
	public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repo.findById(id);
    }
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return repo.getCourceByStudentId(studentId);
    }
}
