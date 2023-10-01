package imb.pr3.estetica.service.jpa;

import imb.pr3.estetica.entity.MetodoDePago;
import imb.pr3.estetica.repository.MetodoDePagoRepository;
import imb.pr3.estetica.service.IMetodoDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoDePagoServiceImpJPA implements IMetodoDePagoService {
    @Autowired
    MetodoDePagoRepository metodoDePagoRepository;

    @Override
    public List<MetodoDePago> buscarTodos() {
        List<MetodoDePago> entities = metodoDePagoRepository.findAll();
        return entities;

    }

    @Override
    public MetodoDePago buscarPorId(Integer id) {
        Optional<MetodoDePago> entityOptional = metodoDePagoRepository.findById(id);
        return entityOptional.get();
    }

    @Override
    public MetodoDePago guardar(MetodoDePago entity) {
        return metodoDePagoRepository.save(entity);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (metodoDePagoRepository.existsById(id)) {
            metodoDePagoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existe(Integer id) {
        return (id == null) ? false: metodoDePagoRepository.existsById(id);
    }
}
