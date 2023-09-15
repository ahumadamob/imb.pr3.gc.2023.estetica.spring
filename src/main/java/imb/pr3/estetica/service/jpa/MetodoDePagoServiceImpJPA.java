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
    public List<MetodoDePago> findall() throws Exception {
             try {
            List<MetodoDePago> entities = metodoDePagoRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago findById(Integer id) throws Exception {
        try {
            Optional<MetodoDePago> entityOptional = metodoDePagoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago save(MetodoDePago entity) throws Exception {
        try {
            return metodoDePagoRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago update(Integer id, MetodoDePago entity) throws Exception {
        try {
            Optional<MetodoDePago> entityOptional = metodoDePagoRepository.findById(id);
            MetodoDePago MetodoDePago = entityOptional.get();
            MetodoDePago = metodoDePagoRepository.save(entity);
            return MetodoDePago;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        try {
            if (metodoDePagoRepository.existsById(id)) {
                metodoDePagoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
