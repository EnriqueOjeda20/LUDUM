package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.TipoSubscripcion;

public interface ITipoSubscripcionDao
{
	public void insert(TipoSubscripcion tsub);
	public List<TipoSubscripcion> list();
}
