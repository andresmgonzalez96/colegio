package com.colegio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colegio.model.Alumnos;
import com.colegio.model.AlumnosRepository;
import com.colegio.model.Cursos;
import com.colegio.model.CursosRepository;

public class ColegioServicesImpl implements ColegioServices{

	@Autowired
	private AlumnosRepository alumnoRepository;
	
	@Autowired
	private CursosRepository cursoRepository;
	
	public List<String> getAllCourseStudents(long courseId){
		List<String> result = new ArrayList<String>();
		List<Alumnos> estudiantes = alumnoRepository.findByCourseId(courseId);
		for(Alumnos alumno : estudiantes) {
			result.add(alumno.getName());
		}
		return result;
	}
	
	public void addStudentToCourse(String name, Long courseId) {
		Cursos course = cursoRepository.findByCourseId(courseId);
		Alumnos nuevoEstudiante = new Alumnos();
		nuevoEstudiante.setName(name);
		nuevoEstudiante.setCourse(course);
		alumnoRepository.save(nuevoEstudiante);
	}


}
