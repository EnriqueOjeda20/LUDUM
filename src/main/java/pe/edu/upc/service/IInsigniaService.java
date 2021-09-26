package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Insignia;

public interface IInsigniaService {
	
	public void insert(Insignia i);
	public List<Insignia>list();
	public void eliminar(int codigoInsignia);
    public List<Insignia> finBynombreInsignia(Insignia Icc);
    public void modificar(Insignia Ic);

}
