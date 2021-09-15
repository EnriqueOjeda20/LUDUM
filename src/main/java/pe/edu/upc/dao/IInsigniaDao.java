package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Insignia;

public interface IInsigniaDao {
	public void insert(Insignia ic);
    public List<Insignia> list();
}
