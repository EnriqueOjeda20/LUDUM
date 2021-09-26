package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Insignia;

public interface IInsigniaDao {
	public void insert(Insignia ic);
    public List<Insignia> list();
    public void eliminar(int codigoInsignia);
    public List<Insignia> finBynombreInsignia(Insignia Icc);
    public void modificar(Insignia Ic);
}
