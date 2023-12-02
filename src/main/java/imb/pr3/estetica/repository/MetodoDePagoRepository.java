package imb.pr3.estetica.repository;

import imb.pr3.estetica.entity.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago, Integer> {
    public List<MetodoDePago> findByCodigo(String codigo);
}

