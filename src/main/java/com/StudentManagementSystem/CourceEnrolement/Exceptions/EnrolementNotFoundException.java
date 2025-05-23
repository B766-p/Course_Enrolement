package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class EnrolementNotFoundException extends RuntimeException  {
	@Override
	public String getMessage() {
		return "Enrolement Not Found";
	}
}
