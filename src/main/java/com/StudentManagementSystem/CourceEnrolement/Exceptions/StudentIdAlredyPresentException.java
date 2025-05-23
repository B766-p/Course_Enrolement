package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class StudentIdAlredyPresentException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Student Id already Present";
	}
}
