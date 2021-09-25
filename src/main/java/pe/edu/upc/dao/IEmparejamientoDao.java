package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.entities.Usuario;

public interface IEmparejamientoDao 
{
	public void insert(Emparejamiento ec);

	public List<Emparejamiento> list();
	public void eliminar (int codigoEmparejamiento);
	public List<Emparejamiento> finByEmparejamientos(Emparejamiento ecc);
	public void modificar (Emparejamiento ec);

}
