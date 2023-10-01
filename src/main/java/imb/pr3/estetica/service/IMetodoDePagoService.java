package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.MetodoDePago;

import java.util.List;

public interface IMetodoDePagoService {

    public List<MetodoDePago> buscarTodos();


    MetodoDePago buscarPorId(Integer id);

    public MetodoDePago guardar(MetodoDePago entity);

    public boolean eliminar(Integer id);

    public boolean existe(Integer id);
}
