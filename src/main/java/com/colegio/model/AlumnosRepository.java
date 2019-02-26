package com.colegio.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlumnosRepository extends CrudRepository<Alumnos,Long>{
	List<Alumnos> findByCourseId(long courseID);
	
	Alumnos findById(long alumnoID);

}
