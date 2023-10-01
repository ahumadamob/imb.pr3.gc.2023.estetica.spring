package imb.pr3.estetica.controller;

import imb.pr3.estetica.entity.MetodoDePago;
import imb.pr3.estetica.entity.Servicio;
import imb.pr3.estetica.service.IMetodoDePagoService;
import imb.pr3.estetica.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "estetica/metodo_de_pago")
public class MetodoDePagoController {
    @Autowired
    private IMetodoDePagoService metodoDePagoService;

    @GetMapping("")
    public ResponseEntity<APIResponse<List<MetodoDePago>>> traerTodosMetodoDePagos() {
        List<MetodoDePago> metodoDePagos = metodoDePagoService.buscarTodos();
        return metodoDePagos.isEmpty() ? ResponseUtil.notFound("No hay elementos en Cargados ahun")
                : ResponseUtil.success(metodoDePagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> traerUnMetodoDePago(@PathVariable Integer id) {
        MetodoDePago metodoDePago = metodoDePagoService.buscarPorId(id);
        return metodoDePago == null ? ResponseUtil.notFound("Elemento no encontrado")
                : ResponseUtil.success(metodoDePago);
    }

    @PostMapping("")
    public ResponseEntity<APIResponse<MetodoDePago>> guardarUnMetodoDePago(@RequestBody MetodoDePago metodoDePago) {
        return metodoDePagoService.existe(metodoDePago.getId()) ? ResponseUtil.badRequest("Ya existe el medio de pago")
                : ResponseUtil.success(metodoDePago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> actualizarUnMetodoDePago(@PathVariable Integer id, @RequestBody MetodoDePago metodoDePago) {
        return metodoDePagoService.existe(id) ? ResponseUtil.success(metodoDePagoService.guardar(metodoDePago))
                : ResponseUtil.badRequest("No se actualizo el método de pago");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> borrarUnMetodoDePago(@PathVariable Integer id) {
        if (metodoDePagoService.existe(id)) {
            metodoDePagoService.eliminar(id);
            return ResponseUtil.success(null);

        } else {
            return ResponseUtil.badRequest("No se pudo eliminar el Método de pago");
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