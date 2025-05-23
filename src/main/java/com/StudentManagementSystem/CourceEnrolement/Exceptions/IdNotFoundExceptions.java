package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class IdNotFoundExceptions extends RuntimeException {
	@Override
	public String getMessage() {
		return "id not found ";
	}
}
