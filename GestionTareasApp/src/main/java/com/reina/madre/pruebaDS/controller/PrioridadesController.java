package com.reina.madre.pruebaDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reina.madre.pruebaDS.interfaces.IPrioridadesService;
import com.reina.madre.pruebaDS.model.PrioridadesModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@Tag(name = "Prioridades controller", description = "Controller para gestionar prioridades")
@RequestMapping("/api/v1/prioridades")
public class PrioridadesController {

	@Autowired
	private IPrioridadesService prioridadService;
	
	@Operation(summary = "Este controller carga la lista de todas las prioridades registradas en la base de datos")
	@GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PrioridadesModel> listaPrioridades() {
		List<PrioridadesModel> listPrioridades = new ArrayList<>();
		try {
			listPrioridades =  prioridadService.listaPrioridades();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return listPrioridades;
	}
	
}
