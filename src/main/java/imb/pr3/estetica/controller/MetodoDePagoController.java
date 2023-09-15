package imb.pr3.estetica.controlador;

import imb.pr3.estetica.entidad.MetodoDePago;
import imb.pr3.estetica.servicio.MetodoDePagoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "estetica/metodo_de_pago")
public class MetodoDePagoControlador {
private MetodoDePagoServicio metodoDePagoServicio;

    public MetodoDePagoControlador(MetodoDePagoServicio metodoDePagoServicio) {
        this.metodoDePagoServicio = metodoDePagoServicio;
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metodoDePagoServicio.findall());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metodoDePagoServicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity <?> save(@RequestBody MetodoDePago entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metodoDePagoServicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> edit(@PathVariable Long id, @RequestBody MetodoDePago entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metodoDePagoServicio.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(metodoDePagoServicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }
}