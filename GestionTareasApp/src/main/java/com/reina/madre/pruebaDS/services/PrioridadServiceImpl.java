package com.reina.madre.pruebaDS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reina.madre.pruebaDS.interfaces.IPrioridadesService;
import com.reina.madre.pruebaDS.model.PrioridadesModel;
import com.reina.madre.pruebaDS.repository.PrioridadesRepository;

@Service
public class PrioridadServiceImpl implements IPrioridadesService {

	@Autowired
	private PrioridadesRepository prioridadRepository;

	@Override
	public List<PrioridadesModel> listaPrioridades() {
		List<PrioridadesModel> listPriodades = new ArrayList<>();
		listPriodades = (List<PrioridadesModel>) prioridadRepository.findAll();
		return listPriodades;
	}

}
