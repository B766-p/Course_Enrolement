package com.StudentManagementSystem.CourceEnrolement.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.CourceEnrolement.DaoLayer.CourseDao;
import com.StudentManagementSystem.CourceEnrolement.DaoLayer.InstructorDao;
import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;
import com.StudentManagementSystem.CourceEnrolement.Entity.Course;
import com.StudentManagementSystem.CourceEnrolement.Entity.Instructor;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.IdNotFoundExceptions;
import com.StudentManagementSystem.CourceEnrolement.Exceptions.InstructorNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseDao dao;
    @Autowired
    private InstructorDao dao1;

    public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course) {
    	Instructor instructor = course.getInstructor();
    	if (instructor == null || (Integer)instructor.getId() == null) {
            throw new InstructorNotFoundException("Instructor ID is required");
        }

        Optional<Instructor> optionalInstructor = dao1.getInstructorById(instructor.getId());
        if (!optionalInstructor.isPresent()) {
            throw new InstructorNotFoundException("Instructor not found with ID: " + instructor.getId());
        }
        course.setInstructor(optionalInstructor.get());
        Course saved = dao.saveCourse(course);
        ResponseStructure<Course> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Course added successfully");
        structure.setData(saved);
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses() {
        List<Course> list = dao.getAllCourses();
        if(list.isEmpty()) {
        	throw new InstructorNotFoundException();
        }else {
        ResponseStructure<List<Course>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("All courses fetched successfully");
        structure.setData(list);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }

    public ResponseEntity<ResponseStructure<Course>> getCourseById(int id) {
        Optional<Course> optional = dao.getCourseById(id);
        ResponseStructure<Course> structure = new ResponseStructure<>();
        if (optional.isPresent()) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Course found");
            structure.setData(optional.get());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
        	throw new IdNotFoundExceptions();
        }
    }
    public ResponseEntity<ResponseStructure<Course>> updateCourse( Course course) {
        ResponseStructure<Course> structure = new ResponseStructure<>();
            Course updated = dao.updateCourse(course);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Course updated successfully");
            structure.setData(updated);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        
    }


    public ResponseEntity<ResponseStructure<Void>> deleteCourse(int id) {
        boolean deleted = dao.deleteCourse(id);
        ResponseStructure<Void> structure = new ResponseStructure<>();
        if (deleted) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Course deleted successfully");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
    		throw new IdNotFoundExceptions();

        }
    }

    public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByInstructorId(int instructorId) {
    	 List<Course> courses = dao.getCoursesByInstructorId(instructorId);
    	if(courses.isEmpty()) {
    		throw new InstructorNotFoundException();
    	}
    	else {
        ResponseStructure<List<Course>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Courses fetched by instructor ID");
        structure.setData(courses);
        return new ResponseEntity<>(structure, HttpStatus.OK);}
    }
}
