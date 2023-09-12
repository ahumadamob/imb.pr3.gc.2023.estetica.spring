package imb.pr3.estetica.service.iface;

import java.util.List;
import java.util.Optional;

import imb.pr3.estetica.entities.Empleado;


public interface EmpleadoServiceIface {
	List<Empleado> obtenerTodosLosEmpleados();
	public void crearEmpleado(Empleado empleado);
	public Empleado  obtenerEmpleadoPorId(int id);
	public void modificarEmpleado(int id , Empleado empleado);
	public void eliminarEmpleado(int id);
}
