package com.prueba.primera.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.primera.model.Alumno;
import com.prueba.primera.service.AlumnoService;
import com.prueba.primera.utils.AlumnoExcelExport;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/api/alumno/")
public class AlumnoREST {

	@Autowired
	private AlumnoService alumnoService;
	
	@ApiOperation (value = "Agrega un nuevo alumno")
	@PostMapping
	private ResponseEntity<Alumno> guardarAlumno (@RequestBody Alumno alumno){
		Alumno tmp = alumnoService.create(alumno);
		
		try {
			return ResponseEntity.created(new URI("/api/alumno"+tmp.getId())).body(tmp);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation (value = "Actualiza informacion del alumno")
	@PutMapping (value = "{id}")
	private ResponseEntity<?> actualizarAlumno (@PathVariable("id") Long id, @RequestBody Alumno alumno){		
		Optional<Alumno> tmp = alumnoService.findById(id);

	    if (tmp.isPresent()) {
	    	Alumno alumnotmp = tmp.get();
	    	alumnotmp.setNombre(alumno.getNombre());
	    	alumnotmp.setCedula(alumno.getCedula());
	    	alumnotmp.setApellido(alumno.getApellido());
	    	alumnotmp.setGrado(alumno.getGrado());
	    	alumnotmp.setFechaDeNacimiento(alumno.getFechaDeNacimiento());
	    	alumnotmp.setFechaDeRegistro(alumno.getFechaDeRegistro());
	    	return new ResponseEntity<>(alumnoService.update(alumnotmp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@ApiOperation (value = "Lista todos los alumnos")
	@GetMapping
	private ResponseEntity<List<Alumno>> listarAlumnos (){
		return ResponseEntity.ok(alumnoService.getAllAlumnos());
	}
	
/*	@ApiOperation (value = "Exporta la lista de todos los alumnos desde una vista")
	@GetMapping ("/export")
	public void exportExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement: filename=Alumnos.xlsx";
		response.setHeader(headerKey, headerValue);
		List<Alumno> listAlumno = alumnoService.getAllAlumnos();
		
		AlumnoExcelExport excel = new AlumnoExcelExport(listAlumno);
		excel.export(response);
	}
	*/
	@ApiOperation (value = "Elimina el alumno por id")
	@DeleteMapping (value = "{id}")
	private ResponseEntity<Void> eliminarAlumno (@PathVariable ("id") Long id){
		alumnoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation (value = "Busca el alumno por id")
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Alumno>> listarAlumnoPorId (@PathVariable ("id") Long id){
		Optional<Alumno> tmp = alumnoService.findById(id);
		if (tmp.isPresent()) {
			return ResponseEntity.ok(alumnoService.findById(id));
		} 
		else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
