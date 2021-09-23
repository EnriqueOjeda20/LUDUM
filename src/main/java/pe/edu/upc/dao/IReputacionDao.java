package pe.edu.upc.dao;
import java.util.List;

import pe.edu.upc.entities.Reputacion;
public interface IReputacionDao {
	public void insert(Reputacion rc);
	public List<Reputacion> list();
	public void Eliminar(int codigoReputacion);
}
