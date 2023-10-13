package imb.pr3.estetica.repository;

import imb.pr3.estetica.entity.OrdenDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDePagoRepository extends JpaRepository<OrdenDePago, Integer> {
}
