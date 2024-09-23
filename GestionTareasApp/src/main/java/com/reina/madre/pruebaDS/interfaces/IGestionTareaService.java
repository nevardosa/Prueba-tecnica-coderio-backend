package com.reina.madre.pruebaDS.interfaces;

import java.util.List;

import com.reina.madre.pruebaDS.model.EstadosModel;
import com.reina.madre.pruebaDS.model.PrioridadesModel;
import com.reina.madre.pruebaDS.model.TareaModel;

public interface IGestionTareaService {
	
	public abstract void crearTarea(TareaModel tarea);
	
	public abstract List<TareaModel> listar();
	
	public abstract TareaModel consultarTarea(int idTarea);
	
	public abstract TareaModel actualizarTarea(TareaModel tarea);
	
	public abstract void eliminarTarea(int idTarea);
	
	public abstract List<EstadosModel> listaEstados();
	
	public abstract List<PrioridadesModel> listaPrioridades();

}
