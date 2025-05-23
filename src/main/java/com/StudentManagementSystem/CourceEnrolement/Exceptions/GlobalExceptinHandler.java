package com.StudentManagementSystem.CourceEnrolement.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.StudentManagementSystem.CourceEnrolement.DtoLayer.ResponseStructure;


@ControllerAdvice
public class GlobalExceptinHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundExceptions.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(IdNotFoundExceptions e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("id not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(CourseNotFoundException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Course not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler(StudentIdAlredyPresentException.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(StudentIdAlredyPresentException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Course not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(StudentNotFoundException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Student not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler(InstructorNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(InstructorNotFoundException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Instructor not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler(EnrolementNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handelIdnfo(EnrolementNotFoundException e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Instructor not found");
		rs.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
		
	}

}