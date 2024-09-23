package com.reina.madre.pruebaDS.dto;

import java.util.List;

import com.reina.madre.pruebaDS.model.TareaModel;

import lombok.Data;

@Data
public class TareaEntityResponse {
	private int codigo;
	private String descripcion;
	private List<TareaModel> listTareaModel;
}
