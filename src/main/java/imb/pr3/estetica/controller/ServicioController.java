package imb.pr3.estetica.controller;

import imb.pr3.estetica.entity.Servicio;
import imb.pr3.estetica.service.IServicioService;
import imb.pr3.estetica.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "estetica/servicio")
public class ServicioController {
    @Autowired
    private IServicioService servicioService;

    @GetMapping("")
    public ResponseEntity<APIResponse<List<Servicio>>> obtenerServicios() {
        List<Servicio> servicios = servicioService.buscarTodos();
        return servicios.isEmpty() ? ResponseUtil.notFound("No Existen Servicios")
                : ResponseUtil.success(servicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Servicio>> getOne(@PathVariable Integer id) {
        Servicio servicio = servicioService.buscarPorId(id);
        return servicio == null ? ResponseUtil.notFound("No se emcomtró el Servicio solicitado")
                : ResponseUtil.success(servicio);
    }

    @PostMapping("")
    public ResponseEntity<APIResponse<Servicio>> guardarServicio(@RequestBody Servicio servicio) {
        return servicioService.existe(servicio.getId()) ? ResponseUtil.badRequest("Ya existe el servicio")
                : ResponseUtil.created(servicioService.guardar(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Servicio>> actualizarServicio(@PathVariable Integer id, @RequestBody Servicio servicio) {
        return servicioService.existe(servicio.getId()) ? ResponseUtil.success(servicioService.guardar(servicio))
                : ResponseUtil.badRequest("No se pudo actualizar el servicio");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> eliminarServicio(@PathVariable Integer id) {
        if (servicioService.existe(id)) {
            servicioService.eliminar(id);  // Eliminar el servicio con el ID proporcionado
            return ResponseUtil.success(null);  // Se ha eliminado exitosamente
        } else {
            return ResponseUtil.badRequest("No existe el método de pago con el identificador proporcionado");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<Servicio>> handleException(Exception ex) {
        return ResponseUtil.badRequest(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<Servicio>> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseUtil.handleConstraintException(ex);
    }
}