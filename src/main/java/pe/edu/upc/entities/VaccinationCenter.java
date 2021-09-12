package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VaccinationCenter")
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVaccinationCenter;

	@Column(name = "nameVaccinationCenter", length = 45, nullable = false)
	private String nameVaccinationCenter;

	@Column(name = "adressVaccinationCenter", nullable = false, length = 60)
	private String adressVaccinationCenter;

	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccinationCenter(int idVaccinationCenter, String nameVaccinationCenter, String adressVaccinationCenter) {
		super();
		this.idVaccinationCenter = idVaccinationCenter;
		this.nameVaccinationCenter = nameVaccinationCenter;
		this.adressVaccinationCenter = adressVaccinationCenter;
	}

	public int getIdVaccinationCenter() {
		return idVaccinationCenter;
	}

	public void setIdVaccinationCenter(int idVaccinationCenter) {
		this.idVaccinationCenter = idVaccinationCenter;
	}

	public String getNameVaccinationCenter() {
		return nameVaccinationCenter;
	}

	public void setNameVaccinationCenter(String nameVaccinationCenter) {
		this.nameVaccinationCenter = nameVaccinationCenter;
	}

	public String getAdressVaccinationCenter() {
		return adressVaccinationCenter;
	}

	public void setAdressVaccinationCenter(String adressVaccinationCenter) {
		this.adressVaccinationCenter = adressVaccinationCenter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVaccinationCenter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccinationCenter other = (VaccinationCenter) obj;
		if (idVaccinationCenter != other.idVaccinationCenter)
			return false;
		return true;
	}

}
