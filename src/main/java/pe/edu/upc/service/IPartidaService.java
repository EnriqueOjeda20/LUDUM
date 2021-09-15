package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Partida;

public interface IPartidaService 
{
	public void insert(Partida pc);
	List<Partida>list();
}
