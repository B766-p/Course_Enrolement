package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class InstructorNotFoundException extends RuntimeException {
	public InstructorNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	public InstructorNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Instructor not found ";
	}
}
