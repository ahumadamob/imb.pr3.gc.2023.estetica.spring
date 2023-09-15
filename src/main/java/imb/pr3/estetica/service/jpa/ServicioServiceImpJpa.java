package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.Servicio;
import imb.pr3.estetica.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpJpa implements IServicioService<IServicioService> {
    @Autowired
    private ServicioRepository servicioRepository;


    @Override
    public List<Servicio> buscarServicio() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarServicioPorId(Integer id) {
        Optional <Servicio> optional = servicioRepository.findById(Long.valueOf(id));
        if (optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Integer id) {
        Optional<Servicio> optional = servicioRepository.findById(Long.valueOf(id));
        if (optional.isPresent()) {
            // Extrae el objeto Servicio del Optional y luego elimínalo
            Servicio servicio = optional.get();
            servicioRepository.delete(servicio);
        }
    }


    @Override
    public void crearServicio(Servicio cliente) {

    }
}
