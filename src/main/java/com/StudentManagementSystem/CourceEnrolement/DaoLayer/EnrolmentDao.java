package com.StudentManagementSystem.CourceEnrolement.DaoLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Enrolment;
import com.StudentManagementSystem.CourceEnrolement.Reporosiretory.Enrolement;

@Repository
public class EnrolmentDao {

    @Autowired
    private Enrolement repo;

    public Enrolment saveEnrolment(Enrolment enrolment) {
        return repo.save(enrolment);
    }

    public Optional<Enrolment> getEnrolmentById(int id) {
        return repo.findById(id);
    }

    public List<Enrolment> getAllEnrolments() {
        return repo.findAll();
    }

    public void deleteEnrolment(int id) {
        repo.deleteById(id);
    }

    public Enrolment updateEnrolment(Enrolment enrolment) {
        return repo.save(enrolment);
    }

    public List<Enrolment> getEnrolmentsByStudentId(int studentId) {
        return repo.findByStudentId(studentId);
    }

    public List<Enrolment> getEnrolmentsByCourseId(int courseId) {
        return repo.findByCourseId(courseId);
    }
}