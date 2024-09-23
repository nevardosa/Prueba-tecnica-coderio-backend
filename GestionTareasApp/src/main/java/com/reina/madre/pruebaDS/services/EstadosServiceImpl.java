package com.reina.madre.pruebaDS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reina.madre.pruebaDS.interfaces.IEstadosService;
import com.reina.madre.pruebaDS.model.EstadosModel;
import com.reina.madre.pruebaDS.repository.EstadosRepository;

@Service
public class EstadosServiceImpl implements IEstadosService {

	@Autowired
	private EstadosRepository estadoRepository;
	
	@Override
	public List<EstadosModel> listarEstados() {
		List<EstadosModel> listEstados = new ArrayList<>();
		try {
			listEstados = (List<EstadosModel>) estadoRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEstados;
	}

}
