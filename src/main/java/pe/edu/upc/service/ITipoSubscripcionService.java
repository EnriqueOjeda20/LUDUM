package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.TipoSubscripcion;


public interface ITipoSubscripcionService 
{
	public void insert(TipoSubscripcion tsub);
	List<TipoSubscripcion> list();
	
}

