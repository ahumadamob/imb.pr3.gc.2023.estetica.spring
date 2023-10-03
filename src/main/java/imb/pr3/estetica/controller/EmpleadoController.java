package imb.pr3.estetica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.estetica.entity.Empleado;
import imb.pr3.estetica.service.jpa.EmpleadoServiceImplJpa;

@RestController
@RequestMapping("/api/cosmetica")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoServiceImplJpa service;
	
	@GetMapping("/empleados")
	public ResponseEntity<?> verEmpleados() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.busquedaGeneral());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.\"}");
		}
		
	}
	
	@GetMapping("/empleados/{id}")
	@ResponseBody
	public Empleado empleadoId(@PathVariable int id) {
		return service.busquedaId(id);
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado empleadoModificado(@RequestBody Empleado empleado , @PathVariable int id) {
		service.objetoModificado(id, empleado);
		return empleado;
	}
	
	
	@PostMapping("/empleados")
	public Empleado nuevoEmpleado(@RequestBody Empleado empleado) {
		service.save(empleado);
		return empleado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public String empleadoEliminado(@PathVariable int id) {
		service.eliminarObjeto(id);
		return "Empleado Despedido";
	}
	
	
	
	
}
