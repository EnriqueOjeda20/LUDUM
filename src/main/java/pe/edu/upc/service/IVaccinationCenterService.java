package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.VaccinationCenter;

public interface IVaccinationCenterService {

	public void insert(VaccinationCenter vc);

	List<VaccinationCenter> list();
}
