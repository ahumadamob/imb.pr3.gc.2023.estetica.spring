package imb.pr3.estetica.repositorio;

import imb.pr3.estetica.entidad.MetodoDePago;
import imb.pr3.estetica.entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

}
