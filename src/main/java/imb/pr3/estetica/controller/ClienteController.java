package imb.pr3.estetica.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.estetica.entity.Cliente;
import imb.pr3.estetica.service.IClienteService;

@RestController
@RequestMapping("/api/cosmetica")
public class ClienteController {
	
	@Autowired
	IClienteService clienteService;
	
	//buscarTodos
	@GetMapping
	public ResponseEntity<APIResponse<List<Cliente>>> buscarTodos(){
		APIResponse<List<Cliente>> response = new APIResponse<List<Cliente>> (200, null, clienteService.buscarCliente());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//buscarPorId
	@GetMapping("{id}")
	public ResponseEntity<APIResponse<Cliente>>mostrarClientePorId(@PathVariable Integer id) {
		Cliente cliente =  clienteService.buscarClientePorId(id);
		if(cliente == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No se encontró el Cliente con id " + id.toString());
			APIResponse<Cliente> response = new APIResponse<Cliente> (400, messages, cliente);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			APIResponse<Cliente> response = new APIResponse<Cliente> (200, null, cliente);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}			
		
	}
	
	//crearNuevo
	@PostMapping
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		clienteService.guardarCliente(cliente);
		return cliente;
		
	}
	
	//Actualizar
	@PutMapping
	public Cliente updateCliente(@RequestBody Cliente cliente) {
		clienteService.guardarCliente(cliente);
		return cliente;
	}
	
	//Eliminar
	@DeleteMapping("{id}")
	public void eliminarCliente(@PathVariable Integer id) {
		clienteService.eliminarCliente(id);
	}
	
	
}

