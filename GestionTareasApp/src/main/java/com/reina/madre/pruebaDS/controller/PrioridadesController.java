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

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
//@ApiOperation(value = "Gestión de tareas")
@RequestMapping("/api/v1/prioridades")
public class PrioridadesController {

	@Autowired
	private IPrioridadesService prioridadService;
	
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
