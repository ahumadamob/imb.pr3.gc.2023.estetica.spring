package imb.pr3.estetica.service.jpa;

import imb.pr3.estetica.entity.Turno;
import imb.pr3.estetica.repository.TurnoRepository;
import imb.pr3.estetica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoImpJpa implements ITurnoService{
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public List<Turno> buscarTodos() {
        List<Turno> entities = turnoRepository.findAll();
        return entities;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        Optional<Turno> entityOptional = turnoRepository.findById(id);
        return entityOptional.get();
    }

    @Override
    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (turnoRepository.existsById(id)) {
            turnoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existe(Integer id) {
        return (id == null) ? false : turnoRepository.existsById(id);
    }
}
