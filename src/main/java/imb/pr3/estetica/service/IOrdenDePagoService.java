package imb.pr3.estetica.service;


import imb.pr3.estetica.entity.OrdenDePago;

import java.util.List;

public interface IOrdenDePagoService {

    public List<OrdenDePago> buscarTodos();

    OrdenDePago buscarPorId(Integer id);

    public OrdenDePago guardar(OrdenDePago entity);

    public boolean eliminar(Integer id);

    public boolean existe(Integer id);
}
