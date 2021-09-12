package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.VaccinationCenter;
import pe.edu.upc.service.IVaccinationCenterService;

// dao <-- service <-- controller

@Named
@RequestScoped
public class VaccinationCenterController {
	@Inject
	private IVaccinationCenterService vService;
	// atributos
	private VaccinationCenter vaccinationCenter;
	List<VaccinationCenter> listaVacunatorios;

	@PostConstruct /**/
	public void init() {
		vaccinationCenter = new VaccinationCenter();
		listaVacunatorios = new ArrayList<VaccinationCenter>();
		list();
		
	}

	// mètodos

	public String newVaccination() {
		this.setVaccinationCenter(new VaccinationCenter());
		return "vaccination.xhtml";

	}

	public void insert() {
		vService.insert(vaccinationCenter);
		list();
	}

	public void list() {
		listaVacunatorios = vService.list();
	}

	// getters & setters
	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	public List<VaccinationCenter> getListaVacunatorios() {
		return listaVacunatorios;
	}

	public void setListaVacunatorios(List<VaccinationCenter> listaVacunatorios) {
		this.listaVacunatorios = listaVacunatorios;
	}

}
