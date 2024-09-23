package com.reina.madre.pruebaDS.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.reina.madre.pruebaDS.model.EstadosModel;

public interface IEstadosService {
	
	public abstract List<EstadosModel> listarEstados();

}
