package com.reina.madre.pruebaDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reina.madre.pruebaDS.interfaces.IGestionTareaService;
import com.reina.madre.pruebaDS.model.TareaModel;
import com.reina.madre.pruebaDS.util.Constantes;

@RestController
//@Api(value = "Controlador de Ejemplo")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
		RequestMethod.DELETE })
//@ApiOperation(value = "Gestión de tareas")
@RequestMapping("/api/v1/gestiontareas")
public class GestionTareasController {

	@Autowired
	private IGestionTareaService tareaService;
	
	
	//@ApiOperation(value = "Este metodo permite crear una nueva tarea, recibe como parametro un objeto de tipo TareaModel")
	@PostMapping(path = "/creartarea")
	public ResponseEntity crearTarea(@RequestBody TareaModel tarea) {
		try {
			if (tarea.getNombre() == "" || tarea.getPrioridad() == 0 || tarea.getEstado() == 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
			}
			tareaService.crearTarea(tarea);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
		}
		return ResponseEntity.ok(Constantes.MSG_EXITOSO);
	}

	//@ApiOperation(value = "Este metodo permite listar todas las tareas creadas en la base de datos")
	@GetMapping(path = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TareaModel> listarTareas() {
		List<TareaModel> tareaEntityResponse = new ArrayList<>();
		try {
			tareaEntityResponse = tareaService.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tareaEntityResponse;
	}

	//@ApiOperation(value = "Este metodo consulta una tarea por id, recibe un parametro de tipo int")
	@GetMapping(path = "/consultar/{idTarea}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity consultar(@PathVariable(value = "idTarea", required = true) Integer idTarea) {
		TareaModel response = new TareaModel(null, 0, 0);
		try {
			if (idTarea != 0) {
				response = tareaService.consultarTarea(idTarea);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
	}

	//@ApiOperation(value = "Este metodo actualiza una tarea por su id, recibe como parametro un objeto de tipo TareaModel")
	@PatchMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity actualizar(@RequestBody TareaModel tarea) {
		TareaModel response = new TareaModel();
		try {
			if (tarea.getNombre() == "" || tarea.getPrioridad() == 0 || tarea.getEstado() == 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
			}
			response = tareaService.actualizarTarea(tarea);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Constantes.MSG_EXITOSO);
	}

	//@ApiOperation(value = "Este metodo elimina una tarea por su id")
	@DeleteMapping(path = "/eliminar/{idTarea}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity eliminar(@PathVariable(value = "idTarea", required = true) Integer idTarea) {
		try {
			if (idTarea == 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
			}
			tareaService.eliminarTarea(idTarea);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constantes.MSG_BADREQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Constantes.MSG_EXITOSO);
	}
}
