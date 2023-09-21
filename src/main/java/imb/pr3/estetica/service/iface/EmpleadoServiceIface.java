package imb.pr3.estetica.service.iface;

import java.util.List;


import imb.pr3.estetica.entities.Empleado;


public interface EmpleadoServiceIface {
	List<Empleado> busquedaGeneral();
	public Empleado busquedaId(int id);
	/*public void nuevoObjeto(Empleado empleado);*/
	public void objetoModificado(int id , Empleado empleado);
	public void eliminarObjeto(int id);
	public Empleado save(Empleado empleado);

}
