package imb.pr3.estetica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.estetica.entities.Empleado;
import imb.pr3.estetica.service.iface.EmpleadoServiceIface;

@RestController
@RequestMapping("/api/cosmetica")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoServiceIface service;
	
	@GetMapping("/empleados")
	public List<Empleado> verEmpleados() {
		return service.obtenerTodosLosEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	@ResponseBody
	public Empleado empleadoId(@PathVariable int id) {
		return service.obtenerEmpleadoPorId(id);
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado empleadoModificado(@RequestBody Empleado empleado , @PathVariable int id) {
		service.modificarEmpleado(id,empleado);
		return empleado;
	}
	
	
	@PostMapping("/empleados/nuevo-empleado")
	public Empleado nuevoEmpleado(@RequestBody Empleado empleado) {
		service.crearEmpleado(empleado);
		return empleado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public String empleadoEliminado(@PathVariable int id) {
		service.eliminarEmpleado(id);
		return "Empleado Despedido";
	}
	
	
	
	
}
