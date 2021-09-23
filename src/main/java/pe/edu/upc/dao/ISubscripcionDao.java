package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Subscripcion;

public interface ISubscripcionDao {
	public void insert(Subscripcion sc);
	public List<Subscripcion>list();
	public void eliminar(int idSubscripcion);
	public void modificar(Subscripcion subscripcion);
}
