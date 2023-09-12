package imb.pr3.estetica.service.database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import imb.pr3.estetica.entities.Empleado;
import imb.pr3.estetica.repository.EmpleadoRepository;
import imb.pr3.estetica.service.iface.EmpleadoServiceIface;


@Service
public class EmpleadoService implements EmpleadoServiceIface {

	@Autowired
	private EmpleadoRepository repositoryEmpleado;
	
	@Override
	public List<Empleado> obtenerTodosLosEmpleados() {
		return repositoryEmpleado.findAll();
	}
	
	@Override
	public Empleado obtenerEmpleadoPorId(int id){
		Optional <Empleado> empleadoPorId = repositoryEmpleado.findById(id);
		return empleadoPorId.get();
	}
	
	@Override
	public void crearEmpleado(Empleado empleado){
		repositoryEmpleado.save(empleado);
	}
	
	@Override
	public void modificarEmpleado(int id,Empleado empleado ) {
		
		Optional<Empleado> empleadoModificado = repositoryEmpleado.findById(id);
		Empleado empl = empleadoModificado.get();
		empl.setNombre(empleado.getNombre());
		empl.setApellido(empleado.getApellido());
		empl.setCargo_laboral(empleado.getCargo_laboral());
		empl.setCorreo(empleado.getCorreo());
		empl.setDomicilio(empleado.getDomicilio());
		empl.setGenero(empleado.getGenero());
		empl.setNumero_telefono(empleado.getNumero_telefono());
		
	}

	@Override
	public void eliminarEmpleado(int id) {
		repositoryEmpleado.deleteById(id);
		
	}
	
	
	
	
}
