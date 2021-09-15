package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Suscripcion;

public interface ISuscripcionService {
	
	public void insert(Suscripcion s);
	public List<Suscripcion> list();

}
