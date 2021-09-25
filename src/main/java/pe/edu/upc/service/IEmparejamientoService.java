package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Emparejamiento;

public interface IEmparejamientoService {
	public void insert (Emparejamiento e);
	public List<Emparejamiento> list();
	public void eliminar (int codigoEmparejamiento);
	public List<Emparejamiento> finByEmparejamientos(Emparejamiento ecc);
	public void modificar (Emparejamiento ec);

}
