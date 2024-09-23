package com.reina.madre.pruebaDS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_prioridades")
public class PrioridadesModel {
	@Id
	@Column(name = "id")
	private Integer id; 
	
	@Column(name = "nombre")
	private String nombre;
}
