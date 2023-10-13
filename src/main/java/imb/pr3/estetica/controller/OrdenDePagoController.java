package imb.pr3.estetica.controller;

import imb.pr3.estetica.entity.OrdenDePago;
import imb.pr3.estetica.entity.Servicio;
import imb.pr3.estetica.service.IOrdenDePagoService;
import imb.pr3.estetica.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/estetica/orden_de_pago")
public class OrdenDePagoController {
    @Autowired
    private IOrdenDePagoService iOrdenDePagoService;

    @GetMapping("")
    public ResponseEntity<APIResponse<List<OrdenDePago>>> traerTodosOrdenDePagos() {
        List<OrdenDePago> ordenDePagos = iOrdenDePagoService.buscarTodos();
        return ordenDePagos.isEmpty() ? ResponseUtil.notFound("No hay elementos en Cargados ahun")
                : ResponseUtil.success(ordenDePagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<OrdenDePago>> traerUnOrdenDePago(@PathVariable Integer id) {
        OrdenDePago ordenDePago = iOrdenDePagoService.buscarPorId(id);
        return ordenDePago == null ? ResponseUtil.notFound("Elemento no encontrado")
                : ResponseUtil.success(ordenDePago);
    }

    @PostMapping("")
    public ResponseEntity<APIResponse<OrdenDePago>> guardarUnOrdenDePago(@RequestBody OrdenDePago ordenDePago) {
        if (iOrdenDePagoService.existe(ordenDePago.getId())) {
            return ResponseUtil.badRequest("Ya existe el orden de pago");
        } else {
            OrdenDePago metodoGuardado = iOrdenDePagoService.guardar(ordenDePago);
            return ResponseUtil.success(metodoGuardado);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<OrdenDePago>> actualizarOrdenDePago(@PathVariable Integer id, @RequestBody OrdenDePago ordenDePago) {
        return iOrdenDePagoService.existe(id) ? ResponseUtil.success(iOrdenDePagoService.guardar(ordenDePago))
                : ResponseUtil.badRequest("No se actualizo el Orden de pago");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<OrdenDePago>> borrarOrdenDePago(@PathVariable Integer id) {
        if (iOrdenDePagoService.existe(id)) {
            iOrdenDePagoService.eliminar(id);
            return ResponseUtil.success(null);
        } else {
            return ResponseUtil.badRequest("No se pudo eliminar el Orden de pago");
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