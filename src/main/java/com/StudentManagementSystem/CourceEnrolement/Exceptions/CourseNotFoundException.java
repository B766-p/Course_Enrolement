package com.StudentManagementSystem.CourceEnrolement.Exceptions;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	public CourseNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Course Data Didn't Found";
	}

}
