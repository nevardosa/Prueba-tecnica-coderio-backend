package com.reina.madre.pruebaDS.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reina.madre.pruebaDS.interfaces.IGestionTareaService;
import com.reina.madre.pruebaDS.model.EstadosModel;
import com.reina.madre.pruebaDS.model.PrioridadesModel;
import com.reina.madre.pruebaDS.model.TareaModel;
import com.reina.madre.pruebaDS.repository.EstadosRepository;
import com.reina.madre.pruebaDS.repository.GestionTareaRepository;
import com.reina.madre.pruebaDS.repository.PrioridadesRepository;

@Service
public class GestionTareaServiceImpl implements IGestionTareaService {

	@Autowired
	private GestionTareaRepository tareaRepository;
	
	@Autowired
	private EstadosRepository estadoRepository;
	
	@Autowired
	private PrioridadesRepository prioridadRepository;

	@Override
	public void crearTarea(TareaModel tarea) {
		
		tareaRepository.save(tarea);
	}

	@Override
	public List<TareaModel>  listTareaPorEstado(int idEstado) {		
		return tareaRepository.findByEstadoId(idEstado);
	}

	@Override
	public List<TareaModel>  listTareaPorPrioridad(int idPrioridad) {
		List<TareaModel> listTareas = new ArrayList<>();
		return tareaRepository.findByPrioridadId(idPrioridad);
	}
	
	@Override
	public TareaModel actualizarTarea(TareaModel tarea) {
		return tareaRepository.save(tarea);
	}

	@Override
	public void eliminarTarea(int idTarea) {
		tareaRepository.deleteById(idTarea);
	}

	@Override
	public List<TareaModel> listar() {
		List<TareaModel> listarTareas = new ArrayList<>();
		listarTareas = (List<TareaModel>) tareaRepository.findAll();		
		return (List<TareaModel>) listarTareas;
	}

	@Override
	public List<EstadosModel> listaEstados() {
		Iterable<EstadosModel> listEstados = new ArrayList<>();
		listEstados = estadoRepository.findAll();
		return (List<EstadosModel>) listEstados;
	}

	@Override
	public List<PrioridadesModel> listaPrioridades() {
		Iterable<PrioridadesModel> listaPrioridades = new ArrayList<>();
		listaPrioridades = prioridadRepository.findAll();
		return (List<PrioridadesModel>) listaPrioridades;
	}

	@Override
	public TareaModel consultarTareaPorId(int idTarea) {
		return tareaRepository.findById(idTarea).orElseThrow();	
	}

}
