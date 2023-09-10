package imb.pr3.estetica.controlador;

import imb.pr3.estetica.entidad.Servicio;
import imb.pr3.estetica.servicio.ServicioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "estetica/servicio")
public class ServicioControlador {
    private ServicioServicio servicioServicio;

    public ServicioControlador(ServicioServicio servicioServicio) {
        this.servicioServicio = servicioServicio;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioServicio.findall());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioServicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Servicio entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioServicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Servicio entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioServicio.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioServicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por Favor Intente mas tarde.\"}");
        }
    }
}
