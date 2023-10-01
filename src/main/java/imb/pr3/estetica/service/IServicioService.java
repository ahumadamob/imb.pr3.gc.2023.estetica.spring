package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.Servicio;

import java.util.List;

public interface IServicioService {
    public List<Servicio> buscarTodos();

    public Servicio buscarPorId(Integer id);

    public Servicio guardar(Servicio cliente);

    public Servicio eliminar(Integer id);
    public boolean existe(Integer id);

}