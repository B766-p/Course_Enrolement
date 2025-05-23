package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Student not Found";
	}
}
