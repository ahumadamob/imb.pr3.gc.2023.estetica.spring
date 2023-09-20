package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.MetodoDePago;

import java.util.List;

public interface IMetodoDePagoService {

    public List<MetodoDePago> findall() throws Exception;


    MetodoDePago findById(Integer id) throws Exception;

    public MetodoDePago save (MetodoDePago entity)throws Exception;

    public boolean delete(Integer id) throws Exception;
}
