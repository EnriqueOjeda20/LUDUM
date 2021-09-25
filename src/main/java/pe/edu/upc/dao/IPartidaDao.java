package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Partida;


public interface IPartidaDao {
	public void insert(Partida pc);
	public List<Partida> list();
	public void eliminar(int codigoPartida);
	public List<Partida> finByEstadoPartida(Partida pcc);
	public void modificar (Partida pc);
}
