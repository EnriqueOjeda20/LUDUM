package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.VaccinationCenter;

public interface IVaccinationCenterDao {
	public void insert(VaccinationCenter vc);

	public List<VaccinationCenter> list();
}
