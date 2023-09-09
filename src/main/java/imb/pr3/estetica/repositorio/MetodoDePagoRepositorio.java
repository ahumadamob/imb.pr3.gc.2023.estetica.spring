package imb.pr3.estetica.repositorio;

import imb.pr3.estetica.entidad.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDePagoRepositorio extends JpaRepository<MetodoDePago, Long> {

}

