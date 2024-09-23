package com.reina.madre.pruebaDS.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		
		/*Random random = new Random();
		int id = 0, min = 0, max = 9999;
		id = random.nextInt(max - min) + min;
		*/
		System.out.println("------------------------ >> "+tarea);
		//tarea.setIdTarea(id);
		tareaRepository.save(tarea);
	}

	@Override
	public TareaModel consultarTarea(int idTarea) {
		return tareaRepository.findById(idTarea).orElseThrow();
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
		
	/*	listarTareas = (List<TareaModel>) listarTareas.stream()
				.filter( t -> t.getPrioridad()
						.
			);*/
		
		
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

}
