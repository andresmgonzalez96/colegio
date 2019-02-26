package com.colegio.model;

import org.springframework.data.repository.CrudRepository;

public interface MateriaRepository extends CrudRepository<Materias,Long>{
	Materias findById(long studentId);

}
