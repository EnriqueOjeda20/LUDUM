package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerson;

	@Column(name = "namePerson", nullable = false, length = 45)
	private String namePerson;

	@Column(name = "dniPerson", nullable = false, length = 8)
	private String dniPerson;

	@Column(name = "adressPerson", nullable = false, length = 60)
	private String adressPerson;

	private Date birthDatePerson;

	@ManyToOne
	@JoinColumn(name = "idVaccinationCenter", nullable = false)
	private VaccinationCenter vaccinationCenter;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int idPerson, String namePerson, String dniPerson, String adressPerson, Date birthDatePerson,
			VaccinationCenter vaccinationCenter) {
		super();
		this.idPerson = idPerson;
		this.namePerson = namePerson;
		this.dniPerson = dniPerson;
		this.adressPerson = adressPerson;
		this.birthDatePerson = birthDatePerson;
		this.vaccinationCenter = vaccinationCenter;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getDniPerson() {
		return dniPerson;
	}

	public void setDniPerson(String dniPerson) {
		this.dniPerson = dniPerson;
	}

	public String getAdressPerson() {
		return adressPerson;
	}

	public void setAdressPerson(String adressPerson) {
		this.adressPerson = adressPerson;
	}

	public Date getBirthDatePerson() {
		return birthDatePerson;
	}

	public void setBirthDatePerson(Date birthDatePerson) {
		this.birthDatePerson = birthDatePerson;
	}

	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

}
