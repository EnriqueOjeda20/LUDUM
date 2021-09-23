package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Partida;

public interface IPartidaService 
{
	public void insert(Partida pc);
	public void eliminar(int codigoPartida);
	List<Partida>list();
	public List<Partida> finByEstadoPartida(Partida pcc);
}
