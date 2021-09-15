package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Suscripcion;

public interface ISuscripcionDao {
	public void insert(Suscripcion sc);
	public List<Suscripcion>list();
}
