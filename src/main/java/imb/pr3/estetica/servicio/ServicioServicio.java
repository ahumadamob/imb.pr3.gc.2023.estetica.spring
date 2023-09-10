package imb.pr3.estetica.servicio;

import imb.pr3.estetica.entidad.Servicio;
import imb.pr3.estetica.entidad.Servicio;
import imb.pr3.estetica.repositorio.ServicioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio implements BaseService<Servicio> {
    private ServicioRepositorio servicioRepositorio;

    public ServicioServicio(ServicioRepositorio servicioRepositorio) {
        this.servicioRepositorio = servicioRepositorio;
    }

    @Override
    public List<Servicio> findall() throws Exception {
        try {
            List<Servicio> entities = servicioRepositorio.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Servicio findById(Long id) throws Exception {
        try {
            Optional<Servicio> entityOptional = servicioRepositorio.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Servicio save(Servicio entity) throws Exception {
        try {
            entity = servicioRepositorio.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Servicio update(Long id, Servicio entity) throws Exception {
        try {
            Optional<Servicio> entityOptional = servicioRepositorio.findById(id);
            Servicio Servicio = entityOptional.get();
            Servicio = servicioRepositorio.save(entity);
            return Servicio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (servicioRepositorio.existsById(id)) {
                servicioRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
