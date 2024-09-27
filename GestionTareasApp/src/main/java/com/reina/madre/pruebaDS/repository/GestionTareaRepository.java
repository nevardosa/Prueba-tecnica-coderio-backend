package com.reina.madre.pruebaDS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reina.madre.pruebaDS.model.TareaModel;

@Repository
public interface GestionTareaRepository extends CrudRepository<TareaModel, Integer>{
	
	@Query(value = "SELECT * FROM tbl_tareas WHERE estado = :estadoId", nativeQuery = true)
	public List<TareaModel> findByEstadoId(@Param("estadoId") Integer estadoId);
	
	@Query(value = "SELECT * FROM tbl_tareas WHERE prioridad = :idPrioridad", nativeQuery = true)
	public List<TareaModel> findByPrioridadId(@Param("idPrioridad") Integer idPrioridad);
		

}
