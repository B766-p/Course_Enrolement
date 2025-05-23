package com.StudentManagementSystem.CourceEnrolement.DaoLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.CourceEnrolement.Entity.Instructor;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.Reporosiretory.InstructorRp;

@Repository
public class InstructorDao {

@Autowired
private InstructorRp repo;

public Instructor saveInstructor(Instructor instructor) {
    return repo.save(instructor);
}

public Optional<Instructor> getInstructorById(int id) {
    return repo.findById(id);
}

public List<Instructor> getAllInstructors() {
    return repo.findAll();
}

public Instructor updateInstructor(Instructor instructor) {
    return repo.save(instructor);
}

public void deleteInstructor(int id) {
    repo.deleteById(id);
}

public List<Student> getStudentsByInstructorId(int instructorId) {
    return repo.getStudentsByInstructorId(instructorId);
}
}