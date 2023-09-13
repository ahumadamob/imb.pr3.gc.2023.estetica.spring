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
		APIResponse<List<Cliente>> response = new APIResponse<List<Cliente>> (HttpStatus.OK.value(), null, clienteService.buscarCliente());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//buscarPorId
	@GetMapping("{id}")
	public ResponseEntity<APIResponse<Cliente>>mostrarClientePorId(@PathVariable Integer id) {
		Cliente cliente =  clienteService.buscarClientePorId(id);
		if(cliente == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No se encontró el Cliente con id " + id.toString());
			APIResponse<Cliente> response = new APIResponse<Cliente> (HttpStatus.BAD_REQUEST.value(), messages, cliente);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			APIResponse<Cliente> response = new APIResponse<Cliente> (HttpStatus.OK.value(), null, cliente);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}			
		
	}
	
	//crearNuevo
	@PostMapping
	public ResponseEntity<APIResponse<Cliente>> crearCliente(@RequestBody Cliente cliente) {
		if (cliente.getId()!= null) {
			Cliente buscaCliente =  clienteService.buscarClientePorId(cliente.getId());
			if (buscaCliente != null) {
				List <String> messages = new ArrayList<>();
				messages.add("Ya existe un cliente con el ID " + cliente.getId().toString());
				messages.add("Para actualizar debe utilizar el verbo PUT");
				APIResponse<Cliente> response = new APIResponse<Cliente> (HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
			}
			
		}
		clienteService.guardarCliente(cliente);
		APIResponse<Cliente> response = new APIResponse<Cliente> (HttpStatus.CREATED.value(), null, cliente);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//Actualizar
	@PutMapping
	public ResponseEntity<APIResponse<Cliente>> actualizarCliente(@RequestBody Cliente cliente) {
		if(this.existe(cliente.getId())){
			clienteService.crearCliente(cliente);
			APIResponse<Cliente> response = new APIResponse <Cliente>(HttpStatus.OK.value(),null,cliente);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List <String> messages = new ArrayList<>();
			 messages.add("No existe un cliente con id especificado");
			 messages.add("Para crear un nuevo cliente debe utiliza verbo POST");
			 APIResponse<Cliente> response = new APIResponse <Cliente>(HttpStatus.BAD_REQUEST.value(),messages,cliente);
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		}
	}
	
	

	//Eliminar
	@DeleteMapping("{id}")
	public ResponseEntity<APIResponse<Cliente>> eliminarCliente(@PathVariable("id") Integer id){
		if(this.existe(id)) {
			clienteService.eliminarCliente(id);
			List <String> messages = new ArrayList<>();
			messages.add("El cliente ha sido eliminado correctamente");
			APIResponse<Cliente> response = new APIResponse <Cliente>(HttpStatus.OK.value(),messages,null);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
			
		}else {
			List <String> messages = new ArrayList<>();
		    messages.add("No se encontró el cliente con id =" + id.toString());
		    APIResponse<Cliente> response = new APIResponse <Cliente>(HttpStatus.BAD_REQUEST.value(),messages,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	private boolean existe(Integer id) {
		if (id == null) {
			return false;
		}else {
		    Cliente cliente = clienteService.buscarClientePorId(id);
		    if(cliente == null) {
		    	return false;
		    }else {
		    	return true;
		    }
		}	
	}
	
   
}