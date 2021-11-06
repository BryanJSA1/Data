package com.prueba.primera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Alumno {
	
	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="cedula", length = 10)
	private String cedula;
	
	@Column(name="nombre", length = 20)
	private String nombre;
	
	@Column(name="apellido", length = 20)
	private String apellido;
	
	@Column(name="grado", length = 10)
	private String grado;
	
	@Column(name="fecha_de_nacimiento")
	private String fechaDeNacimiento;
	
	@Column(name="fecha_de_registro")
	private String fechaDeRegistro;
	
	public Alumno() {}

	public Alumno(Long id, String cedula, String nombre, String apellido, String grado, String fechaDeNacimiento,
			String fechaDeRegistro) {
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.grado = grado;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(String fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}
	
	

}
