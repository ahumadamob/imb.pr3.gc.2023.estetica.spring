package imb.pr3.estetica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.estetica.entity.Cliente;
import imb.pr3.estetica.entity.MetodoDePago;
import imb.pr3.estetica.service.IClienteService;
import imb.pr3.estetica.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;


@RestController
@RequestMapping("api/cosmetica/Cliente")
public class ClienteController {
	
	@Autowired
	IClienteService clienteService;
	
	//buscarTodos
	@GetMapping
	public ResponseEntity<APIResponse<List<Cliente>>> buscarTodosLosClientes(){
		APIResponse<List<Cliente>> response = new APIResponse<List<Cliente>> (HttpStatus.OK.value(), null, clienteService.buscarTodos());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//buscarPorId
	@GetMapping("{id}")
	public ResponseEntity<APIResponse<Cliente>> buscarClientePorId(@PathVariable("id") Integer id){
		Cliente cliente =  clienteService.buscarPorId(id);
		return cliente == null ? ResponseUtil.notFound("No se encontró el cliente con el identificador proporcionado")
				: ResponseUtil.success(cliente);	
	}
	
	//crearNuevo
	
	@PostMapping
    public ResponseEntity<APIResponse<Cliente>> crearMetodoDePago(@RequestBody Cliente cliente, BindingResult result) {
        return clienteService.existe(cliente.getId()) ? ResponseUtil.badRequest("No se puede crear cliente, el ID ingresado ya existe")
        		: ResponseUtil.success(cliente);
     }

	
	//Actualizar
	
	@PutMapping
	public ResponseEntity<APIResponse<Cliente>> modificarCliente(@RequestBody Cliente cliente) {
		return clienteService.existe(cliente.getId()) ? ResponseUtil.success(clienteService.guardar(cliente))
				: ResponseUtil.badRequest("No se puede actualizar cliente, el ID ingresado no ha sido creado");
	}
	
	//Eliminar
	//Anotación que indica que este método manejará solicitudes HTTP DELETE en una URL que utiliza "id" como parámetro que se pasará en el body de la consulta
	@DeleteMapping("{id}")
	//Se define el método "eliminarCliente" que toma como parametro de entrada un "id"
	//La anotación "@PathVariable" indica que el valor de "id" se tomará de la URL
	public ResponseEntity<APIResponse<Cliente>> eliminarCliente(@PathVariable("id") Integer id) {
	    //Se llama al método "existe" del servicio "clienteService" para verificar si el ID del cliente existe
	    // Si la condición "clienteService.existe(id)" es verdadera, quiere decir que el cliente existe, por lo tanto, se elimina al cliente identificado por el ID
	    // No se devuelve ningún contenido en este caso, solo se confirma la eliminación exitosa
	    return clienteService.existe(id) ? ResponseUtil.success(null)
	            // Si la condición "clienteService.existe(id)" es falsa, significa que el cliente no existe, por lo que se genera una respuesta HTTP de error BadRequest con un mensaje que indica que el cliente no existe
	            : ResponseUtil.badRequest("No existe el cliente con el ID ingresado");
	}
		
	// Excepciones
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<MetodoDePago>> handleException(Exception ex) {    	
    	return ResponseUtil.badRequest(ex.getMessage());
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<MetodoDePago>> handleConstraintViolationException(ConstraintViolationException ex) {
    	return ResponseUtil.handleConstraintException(ex);
    } 
   
}