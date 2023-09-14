package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.Servicio;

import java.util.List;

public interface IServicioService<I> {
    List<Servicio> buscarServicio();
    Servicio buscarServicioPorId(Integer id);
    public void guardarServicio(Servicio cliente);
    public void eliminarServicio (Integer id);
    public void crearServicio (Servicio cliente);

}