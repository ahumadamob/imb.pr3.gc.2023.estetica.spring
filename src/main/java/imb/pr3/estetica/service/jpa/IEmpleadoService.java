package imb.pr3.estetica.service.jpa;

import java.util.List;

import imb.pr3.estetica.entity.Empleado;


public interface EmpleadoServiceImplJpa {
	List<Empleado> buscarTodos() ;
	public Empleado busquedaId(int id) ;
	/*public void nuevoObjeto(Empleado empleado);*/
	public void objetoModificado(int id , Empleado empleado) ;
	public void eliminarObjeto(int id);
	public Empleado save(Empleado empleado) ;
	public boolean existe(Integer id);

}
