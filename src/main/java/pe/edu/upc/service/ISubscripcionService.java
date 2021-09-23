package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Subscripcion;

public interface ISubscripcionService {
	
	public void insert(Subscripcion s);
	public void eliminar(int idSubscripcion);
	public List<Subscripcion> list();
	public void modificar (Subscripcion subscripcion);
}
