package com.StudentManagementSystem.CourceEnrolement.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.CourceEnrolement.DaoLayer.InstructorDao;
import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Instructor;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.IdNotFoundExceptions;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.InstructorNotFoundException;

@Service
public class InstructorService {

    @Autowired
    private InstructorDao dao;

    public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(Instructor instructor) {
        Instructor saved = dao.saveInstructor(instructor);
        ResponseStructure<Instructor> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Instructor saved successfully");
        structure.setData(saved);
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(int id) {
        Optional<Instructor> instructor = dao.getInstructorById(id);
        ResponseStructure<Instructor> structure = new ResponseStructure<>();
        if (instructor.isPresent()) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Instructor found");
            structure.setData(instructor.get());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundExceptions(); 
        }
    }

    public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructors() {
        List<Instructor> instructors = dao.getAllInstructors();
        if(instructors.isEmpty()) {
        	throw new InstructorNotFoundException();
        }else {
        ResponseStructure<List<Instructor>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("All instructors fetched");
        structure.setData(instructors);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }

    public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(Instructor instructor) {
        ResponseStructure<Instructor> structure = new ResponseStructure<>();
            Instructor updated = dao.updateInstructor(instructor);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Instructor updated successfully");
            structure.setData(updated);
            return new ResponseEntity<>(structure, HttpStatus.OK);

    }

    public ResponseEntity<ResponseStructure<Void>> deleteInstructor(int id) {
        Optional<Instructor> existing = dao.getInstructorById(id);
        ResponseStructure<Void> structure = new ResponseStructure<>();
        if (existing.isPresent()) {
            dao.deleteInstructor(id);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Instructor deleted successfully");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
           throw new IdNotFoundExceptions();
        }
    }

    public ResponseEntity<ResponseStructure<List<Student>>> getStudentsByInstructorId(int instructorId) {
        List<Student> students = dao.getStudentsByInstructorId(instructorId);
        ResponseStructure<List<Student>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Students for instructor fetched");
        structure.setData(students);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
}