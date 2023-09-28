package imb.pr3.estetica.controller;

import imb.pr3.estetica.entity.MetodoDePago;
import imb.pr3.estetica.service.IMetodoDePagoService;
import imb.pr3.estetica.service.jpa.MetodoDePagoServiceImpJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "estetica/metodo_de_pago")
public class MetodoDePagoController {
    @Autowired
    private IMetodoDePagoService metodoDePagoService;
    List<String> errorMessages = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<APIResponse<List<MetodoDePago>>> traerTodos() {
        try {
            APIResponse<List<MetodoDePago>> response = new APIResponse<List<MetodoDePago>>(200, null, metodoDePagoService.findall());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            errorMessages.add("Error, Por Favor Intente más tarde.");
            APIResponse<List<MetodoDePago>> errorResponse = new APIResponse<>(404, errorMessages, null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> traerUno(@PathVariable Integer id) {
        try {
            APIResponse<MetodoDePago> response = new APIResponse<MetodoDePago>(200, null, metodoDePagoService.findById(id));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            errorMessages.add("No se pudo encontrar su Metodo de pago por id");
            APIResponse<MetodoDePago> errorResponse = new APIResponse<>(404, errorMessages, null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("")
    public ResponseEntity<APIResponse<MetodoDePago>> guardarUno(@RequestBody MetodoDePago entity) {
        try {
            APIResponse<MetodoDePago> response = new APIResponse<>(200, null, metodoDePagoService.save(entity));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            errorMessages.add("No se pudo guardar su método de pago");
            APIResponse<MetodoDePago> errorResponse = new APIResponse<>(404, errorMessages, null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> actualizarUno(@PathVariable Integer id, @RequestBody MetodoDePago entity) {
        try {
            APIResponse<MetodoDePago> response = new APIResponse<>(200, null, metodoDePagoService.save(entity));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            errorMessages.add("No se pudo Actualizar su método de pago");
            APIResponse<MetodoDePago> errorResponse = new APIResponse<>(404, errorMessages, null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<MetodoDePago>> borrarUno(@PathVariable Integer id) {
        try {
            boolean deleted = metodoDePagoService.delete(id);
            if (deleted) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            // Manejar cualquier excepción si es necesario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}