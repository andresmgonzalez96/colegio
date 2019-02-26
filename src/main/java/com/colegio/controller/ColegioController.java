package com.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.colegio.model.AlumnosRepository;
import com.colegio.model.Cursos;
import com.colegio.model.CursosRepository;
import com.colegio.services.ColegioServices;

@Controller
@RequestMapping(path = "/colegio")
public class ColegioController {

	@Autowired
	private ColegioServices colegioService;
	
	@Autowired
	private AlumnosRepository studentRepository;
	
	@Autowired
	private CursosRepository courseRepository;
	
	@PostMapping("/course")
	ResponseEntity<?>course(@RequestBody Cursos course,UriComponentsBuilder	ucBuilder){
		
		//courseRepository.save(course);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/materiaController/course/{id}").buildAndExpand(course.getId()).toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/all/{id}")
	public @ResponseBody Iterable<String> getAllUsers(@PathVariable("id") Long courseId){
		
		return colegioService.getAllCourseStudents(courseId);
	}

}
