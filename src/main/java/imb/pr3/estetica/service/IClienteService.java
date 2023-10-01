package imb.pr3.estetica.service;

import java.util.List;

import imb.pr3.estetica.entity.Cliente;

public interface IClienteService {
    List<Cliente> buscarCliente();

    Cliente buscarClientePorId(Integer id);

    public void guardarCliente(Cliente cliente);

    public void eliminarCliente(Integer id);

    public void crearCliente(Cliente cliente);
}
