package com.prueba.primera.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.prueba.primera.model.Alumno;

public class AlumnoExcelExport {
	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	
	private List<Alumno> listAlumnos;
	
	
	public AlumnoExcelExport(List<Alumno> listAlumnos) {
		this.listAlumnos = listAlumnos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Alumnos");
	}

	private void escribirEncabezado() {
		Row row = hoja.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("id");
		
		cell = row.createCell(1);
		cell.setCellValue("Nombre");
		
		cell = row.createCell(2);
		cell.setCellValue("Apellido");
		
		cell = row.createCell(3);
		cell.setCellValue("Cedula");
		
		cell = row.createCell(3);
		cell.setCellValue("Fecha Registro");
	}
	
	private void escribirInformacion() {
		
	}
	
	public void export(HttpServletResponse response) throws IOException {
		escribirEncabezado();
		escribirInformacion();
		
		ServletOutputStream outputStream = response.getOutputStream();
		libro.write(outputStream);
		libro.close();
		outputStream.close();
	}
}
