package imb.pr3.estetica.servicio;

import imb.pr3.estetica.entidad.MetodoDePago;
import imb.pr3.estetica.repositorio.MetodoDePagoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoDePagoServicio implements BaseService<MetodoDePago> {

    private MetodoDePagoRepositorio metodoDePagoRepositorio;

    public MetodoDePagoServicio(MetodoDePagoRepositorio metodoDePagoRepositorio) {
        this.metodoDePagoRepositorio = metodoDePagoRepositorio;
    }

    @Override
    public List<MetodoDePago> findall() throws Exception {
        try {
            List<MetodoDePago> entities = metodoDePagoRepositorio.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago findById(Long id) throws Exception {
        try {
            Optional<MetodoDePago> entityOptional = metodoDePagoRepositorio.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago save(MetodoDePago entity) throws Exception {
        try {
            entity = metodoDePagoRepositorio.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MetodoDePago update(Long id, MetodoDePago entity) throws Exception {
        try {
            Optional<MetodoDePago> entityOptional = metodoDePagoRepositorio.findById(id);
            MetodoDePago MetodoDePago = entityOptional.get();
            MetodoDePago = metodoDePagoRepositorio.save(entity);
            return MetodoDePago;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (metodoDePagoRepositorio.existsById(id)) {
                metodoDePagoRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
