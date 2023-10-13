package imb.pr3.estetica.service;

import imb.pr3.estetica.entity.Turno;

import java.util.List;

public interface ITurnoService {
    public List<Turno> buscarTodos();

    public Turno buscarPorId(Integer id);

    public Turno guardar(Turno turno);

    public boolean eliminar(Integer id);
    public boolean existe(Integer id);
}
