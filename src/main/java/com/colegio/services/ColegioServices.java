package com.colegio.services;

import java.util.List;

public interface ColegioServices {
	
	public List<String> getAllCourseStudents(long courseId);
	
	public void addStudentToCourse(String name, Long courseId);

}
