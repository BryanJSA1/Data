package com.prueba.primera.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.primera.model.Alumno;
import com.prueba.primera.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public Alumno create(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public List<Alumno> getAllAlumnos() {
		return alumnoRepository.findAll();
	}
	
	public void deleteById(Long id) {
		alumnoRepository.deleteById(id);
	}
	
	public Optional<Alumno> findById(Long id) {
		return alumnoRepository.findById(id);
	}
	
	public Alumno update(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
}
