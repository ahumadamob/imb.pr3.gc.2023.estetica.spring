package imb.pr3.estetica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.estetica.entity.Empleado;
import imb.pr3.estetica.repository.EmpleadoRepository;
import imb.pr3.estetica.service.jpa.IEmpleadoService;


@Service
public class EmpleadoServiceImplJpa implements IEmpleadoService {

	@Autowired
	private EmpleadoRepository repositoryEmpleado;
	
	
	@Override
	public List<Empleado> buscarTodos() {
		return repositoryEmpleado.findAll();
	}
	
	@Override
	public Empleado buscarPorId(int id){
		Optional <Empleado> empleadoPorId = repositoryEmpleado.findById(id);
		return empleadoPorId.get();
	}
	
	
	/*@Override
	public void nuevoObjeto(Empleado empleado){
		repositoryEmpleado.save(empleado);
	}*/
	
	@Override
	public Empleado guardar(Empleado empleado) {
		repositoryEmpleado.save(empleado);
		return empleado;
	}
	
//	@Override
//	public void objetoModificado(int id,Empleado empleado ) {
//
//		Optional<Empleado> empleadoModificado = repositoryEmpleado.findById(id);
//		Empleado empl = empleadoModificado.get();
//		empl.setNombre(empleado.getNombre());
//		empl.setApellido(empleado.getApellido());
//		empl.setCargo_laboral(empleado.getCargo_laboral());
//		empl.setCorreo(empleado.getCorreo());
//		empl.setDomicilio(empleado.getDomicilio());
//		empl.setGenero(empleado.getGenero());
//		empl.setNumero_telefono(empleado.getNumero_telefono());
//		empleado = repositoryEmpleado.save(empl);
//	}

	@Override
	public void eliminar(int id) {
		repositoryEmpleado.deleteById(id);
		
	}

	@Override
	public boolean existe(Integer id) {
		return id == null ? false : repositoryEmpleado.existsById(id);
	}
}
