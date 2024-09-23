package com.reina.madre.pruebaDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reina.madre.pruebaDS.interfaces.IEstadosService;
import com.reina.madre.pruebaDS.model.EstadosModel;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
//@ApiOperation(value = "Gestión de tareas")
@RequestMapping("/api/v1/estados")
public class EstadosController {
	
	@Autowired
	private IEstadosService estadosService;
	
	@GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstadosModel> listarEstados() {
		List<EstadosModel> listEstados = new ArrayList<>();
		try {
			listEstados =  estadosService.listarEstados();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return listEstados;
	}

}
