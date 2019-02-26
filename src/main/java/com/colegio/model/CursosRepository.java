package com.colegio.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CursosRepository extends CrudRepository<Alumnos,Long>{
	Cursos findByCourseId(long courseId);	

}
