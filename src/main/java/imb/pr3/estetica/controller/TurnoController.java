package imb.pr3.estetica.controller;

import imb.pr3.estetica.entity.Turno;
import imb.pr3.estetica.service.ITurnoService;
import imb.pr3.estetica.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/estetica/turno")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @GetMapping("")
    public ResponseEntity<APIResponse<List<Turno>>> traerTodosTurnos() {
        List<Turno> turnos = turnoService.buscarTodos();
        return turnos.isEmpty() ? ResponseUtil.notFound("No hay elementos en Cargados ahun")
                : ResponseUtil.success(turnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Turno>> traerUnTurno(@PathVariable Integer id) {
        Turno turnos = turnoService.buscarPorId(id);
        return turnos == null ? ResponseUtil.notFound("Elemento no encontrado")
                : ResponseUtil.success(turnos);
    }

    @PostMapping("")
    public ResponseEntity<APIResponse<Turno>> guardarUnTurno(@RequestBody Turno turno) {
        if (turnoService.existe(turno.getId())) {
            return ResponseUtil.badRequest("Ya existe el turno");
        } else {
            Turno metodoGuardado = turnoService.guardar(turno);
            return ResponseUtil.success(metodoGuardado);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Turno>> actualizarUnTurno(@PathVariable Integer id, @RequestBody Turno turno) {
        return turnoService.existe(id) ? ResponseUtil.success(turnoService.guardar(turno))
                : ResponseUtil.badRequest("No se actualizo el turno");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Turno>> borrarTurno(@PathVariable Integer id) {
        if (turnoService.existe(id)) {
            turnoService.eliminar(id);
            return ResponseUtil.success(null);
        } else {
            return ResponseUtil.badRequest("No se pudo eliminar el turno");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<Turno>> handleException(Exception ex) {
        return ResponseUtil.badRequest(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<Turno>> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseUtil.handleConstraintException(ex);
    }
}