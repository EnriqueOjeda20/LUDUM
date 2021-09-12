package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Person;
import pe.edu.upc.entities.VaccinationCenter;
import pe.edu.upc.service.IPersonService;
import pe.edu.upc.service.IVaccinationCenterService;

@Named
@RequestScoped
public class PersonController {
	@Inject
	private IPersonService pService;
	@Inject
	private IVaccinationCenterService vService;
//atributos
	private Person person;
	private VaccinationCenter vacinationCenter;
	List<Person> listaPersonas;
	List<VaccinationCenter> listaVacunatorios;

	// constructor
	@PostConstruct
	public void init() {
		this.person = new Person();
		this.vacinationCenter = new VaccinationCenter();
		this.listaPersonas = new ArrayList<Person>();
		this.listaVacunatorios = new ArrayList<VaccinationCenter>();
		this.listPerson();
		this.listVaccination();
	}
//métodos personalizados

	public String newPerson() {
		this.setPerson(new Person());
		this.listVaccination();
		return "person.xhtml";
	}

	public void listVaccination() {
		listaVacunatorios = vService.list();
	}

	public void insertPerson() {
		pService.insert(person);
		this.listPerson();
	}

	public void listPerson() {
		listaPersonas = pService.list();
	}

//getters & setters
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Person> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public List<VaccinationCenter> getListaVacunatorios() {
		return listaVacunatorios;
	}

	public void setListaVacunatorios(List<VaccinationCenter> listaVacunatorios) {
		this.listaVacunatorios = listaVacunatorios;
	}

	public VaccinationCenter getVacinationCenter() {
		return vacinationCenter;
	}

	public void setVacinationCenter(VaccinationCenter vacinationCenter) {
		this.vacinationCenter = vacinationCenter;
	}

}
