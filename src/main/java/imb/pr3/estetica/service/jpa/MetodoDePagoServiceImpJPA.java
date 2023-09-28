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
    private MetodoDePagoRepository repo;

    @Override
    public List<MetodoDePago> buscarTodos(){
    	return repo.findAll();
    }

    @Override
    public MetodoDePago buscarPorId(Integer id) {
        Optional<MetodoDePago> opt = repo.findById(id);
        return opt.orElse(null);
    }
    
    @Override
    public MetodoDePago guardar(MetodoDePago metodoDePago) {
    	return repo.save(metodoDePago);
    }
    
    @Override
    public void eliminar(Integer id) {
    	repo.deleteById(id);
    }
    
    @Override
    public boolean existe(Integer id) {
    	return (id == null) ? false: repo.existsById(id);
    }
}
