package com.reina.madre.pruebaDS.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="tbl_tareas")
public class TareaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public TareaModel() {
		
	}
	
	public TareaModel(String nombre, int prioridad, int estado) {
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.estado = estado;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TAREA")
    @SequenceGenerator(name = "SQ_TAREA", sequenceName = "SQ_TAREA", allocationSize = 1)
	@Column(name = "id_tarea")
	private Integer idTarea;
	
	@Column(name = "nombre",nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "prioridad",nullable = false, length = 1)
	private int prioridad;
	
	@Column(name = "estado",nullable = false, length = 1)
	private int estado;

}
