package imb.pr3.estetica.service.jpa;

import imb.pr3.estetica.entity.OrdenDePago;
import imb.pr3.estetica.repository.OrdenDePagoRepository;
import imb.pr3.estetica.service.IOrdenDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrdenDePagoImpJpa implements IOrdenDePagoService {
    @Autowired
    OrdenDePagoRepository ordenDePagoRepository;

    @Override
    public List<OrdenDePago> buscarTodos() {
        List<OrdenDePago> entities = ordenDePagoRepository.findAll();
        return entities;
    }

    @Override
    public OrdenDePago buscarPorId(Integer id) {
        Optional<OrdenDePago> entityOptional = ordenDePagoRepository.findById(id);
        return entityOptional.get();
    }


    @Override
    public OrdenDePago guardar(OrdenDePago entity) {
        return ordenDePagoRepository.save(entity);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (ordenDePagoRepository.existsById(id)) {
            ordenDePagoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existe(Integer id) {
        return (id == null) ? false : ordenDePagoRepository.existsById(id);
    }
}
