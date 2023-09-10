package imb.pr3.estetica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.pr3.estetica.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}
