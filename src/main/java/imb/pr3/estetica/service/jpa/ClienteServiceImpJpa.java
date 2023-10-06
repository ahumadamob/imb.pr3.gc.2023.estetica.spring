package imb.pr3.estetica.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import imb.pr3.estetica.entity.Cliente;
import imb.pr3.estetica.repository.ClienteRepository;
import imb.pr3.estetica.service.IClienteService;

@Service
@Primary
public class ClienteServiceImpJpa implements IClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	@Override
	public List<Cliente> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);;
	}


	@Override
	public void crear(Cliente cliente) {
		repo.save(cliente);
		
	}

	@Override
	public Cliente buscarPorId(Integer id) {
	    Optional<Cliente> optional = repo.findById(id);
	    if (optional.isPresent()) {
	        return optional.get();
	    } else {
	        return null;
	    }
	}

	@Override
	public boolean existe(Integer id) {
		return(id ==null)? false:repo.existsById(id);
	}


		
}