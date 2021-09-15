package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Partida;

public interface IPartidaDao {
	public void insert(Partida pc);
	public List<Partida> list();
}
