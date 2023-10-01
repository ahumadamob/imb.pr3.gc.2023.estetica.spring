package imb.pr3.estetica.service.jpa;

import imb.pr3.estetica.entity.Servicio;
import imb.pr3.estetica.repository.ServicioRepository;
import imb.pr3.estetica.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpJpa implements IServicioService {
    @Autowired
    private ServicioRepository servicioRepository;


    @Override
    public List<Servicio> buscarTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarPorId(Integer id) {
        Optional<Servicio> optional = servicioRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio eliminar(Integer id) {
        Optional<Servicio> optional = servicioRepository.findById(id);
        Servicio servicio = null;
        if (optional.isPresent()) {
            // Extrae el objeto Servicio del Optional y luego elimínalo
            servicio = optional.get();
            servicioRepository.delete(servicio);
        }
        return servicio;
    }

    @Override
    public boolean existe(Integer id) {
        return (id == null) ? false : servicioRepository.existsById(id);
    }

}