package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reputacion")

public class Reputacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoReputacion;

	@OneToOne
	@JoinColumn(name = "codigoUsuario", nullable = false)
	private Usuario usuario;

	@Column(name = "Puntos", nullable = false)
	private int puntos;

	@Column(name = "estado_Reputacion", nullable = false, length = 20)
	private String estadoReputacion;

	public Reputacion()   
	{
		super();
	}

	public Reputacion(int codigoReputacion, Usuario usuario, int puntos, String estadoReputacion) {
		super();
		this.codigoReputacion = codigoReputacion;
		this.usuario = usuario;
		this.puntos = puntos;
		this.estadoReputacion = estadoReputacion; // 

	}

	public int getCodigoReputacion() 
	{
		return codigoReputacion;
	}

	public void setCodigoReputacion(int codigoReputacion) {
		this.codigoReputacion = codigoReputacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getEstadoReputacion() {
		return estadoReputacion;
	}

	public void setEstadoReputacion(String estadoReputacion) {
		this.estadoReputacion = estadoReputacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoReputacion, estadoReputacion, puntos, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reputacion other = (Reputacion) obj;
		return codigoReputacion == other.codigoReputacion && estadoReputacion == other.estadoReputacion
				&& puntos == other.puntos && Objects.equals(usuario, other.usuario);
	}

}