package com.prueba.primera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.primera.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
