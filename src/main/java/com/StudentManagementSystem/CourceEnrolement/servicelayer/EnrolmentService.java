package com.StudentManagementSystem.CourceEnrolement.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.CourceEnrolement.DaoLayer.CourseDao;
import com.StudentManagementSystem.CourceEnrolement.DaoLayer.EnrolmentDao;
import com.StudentManagementSystem.CourceEnrolement.DaoLayer.StudentDao;
import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Enrolment;
import com.StudentManagementSystem.CourceEnrolement.Entity.Student;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.CourseNotFoundException;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.EnrolementNotFoundException;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.IdNotFoundExceptions;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.StudentNotFoundException;

@Service
public class EnrolmentService {

    @Autowired
    private EnrolmentDao dao;
    @Autowired
    private StudentDao dao1;
    @Autowired
    private CourseDao dao2;

    public ResponseEntity<ResponseStructure<Enrolment>> saveEnrolment(Enrolment enrolment) {
    	Student student = enrolment.getStudent();
        if (student == null || (Integer)student.getId() == null) {
            throw new StudentNotFoundException("Student ID is required");
        }

        Course course = enrolment.getCourse();
        if (course == null || course.getId() == 0) {
            throw new CourseNotFoundException("Course ID is required");
        }

        // Fetch Student
        Optional<Student> optionalStudent = dao1.getStudentById(student.getId());
        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException("Student not found with ID: " + student.getId());
        }
 Optional<Course> optionalCourse = dao2.getCourseById(course.getId());
        if (optionalCourse.isEmpty()) {
            throw new CourseNotFoundException("Course not found with ID: " + course.getId());
        }

        // Set actual entities to enrolment
        enrolment.setStudent(optionalStudent.get());
        enrolment.setCourse(optionalCourse.get());

        // Save
        Enrolment saved = dao.saveEnrolment(enrolment);
        ResponseStructure<Enrolment> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Enrolment saved successfully");
        structure.setData(saved);
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Enrolment>> getEnrolmentById(int id) {
    	
        Optional<Enrolment> enrolment = dao.getEnrolmentById(id);
        ResponseStructure<Enrolment> structure = new ResponseStructure<>();

        if (enrolment.isPresent()) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Enrolment found");
            structure.setData(enrolment.get());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundExceptions();
        }
    }

    public ResponseEntity<ResponseStructure<List<Enrolment>>> getAllEnrolments() {
        List<Enrolment> enrolments = dao.getAllEnrolments();
        ResponseStructure<List<Enrolment>> structure = new ResponseStructure<>();
        if(enrolments.isEmpty()) {
        	throw new EnrolementNotFoundException();
        }else {
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("All enrolments fetched");
        structure.setData(enrolments);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }

    public ResponseEntity<ResponseStructure<Enrolment>> updateEnrolment( Enrolment enrolment) {
        ResponseStructure<Enrolment> structure = new ResponseStructure<>();

            Enrolment updated = dao.updateEnrolment(enrolment);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Enrolment updated successfully");
            structure.setData(updated);
            return new ResponseEntity<>(structure, HttpStatus.OK);
   
    }

    public ResponseEntity<ResponseStructure<Void>> deleteEnrolment(int id) {
        Optional<Enrolment> existing = dao.getEnrolmentById(id);
        ResponseStructure<Void> structure = new ResponseStructure<>();

        if (existing.isPresent()) {
            dao.deleteEnrolment(id);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Enrolment deleted successfully");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
        	 throw new IdNotFoundExceptions();
        }
    }

    public ResponseEntity<ResponseStructure<List<Enrolment>>> getEnrolmentsByStudentId(int studentId) {
        List<Enrolment> enrolments = dao.getEnrolmentsByStudentId(studentId);
        if(enrolments.isEmpty()) {
        	throw new EnrolementNotFoundException();
        }else {
        ResponseStructure<List<Enrolment>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Enrolments for student fetched");
        structure.setData(enrolments);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }

    public ResponseEntity<ResponseStructure<List<Enrolment>>> getEnrolmentsByCourseId(int courseId) {
        List<Enrolment> enrolments = dao.getEnrolmentsByCourseId(courseId);
        if(enrolments.isEmpty()) {
        	throw new EnrolementNotFoundException();
        }else {
        ResponseStructure<List<Enrolment>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Enrolments for course fetched");
        structure.setData(enrolments);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }
}