package pe.edu.upc.entities;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reputacion")

public class Reputacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private int codigoReputacion;
	@Column(name= "numeroEquipo" , nullable = false, length = 45) /// asdasd
	private int numeroEquipo; //aca seria el llamar a la tabla de usuario 
	@Column (name= "puntos" , nullable = false, length = 8)
	private int puntos;
	@Column (name= "estado" , nullable = false, length = 20)
	private boolean estado;
	
	public Reputacion()
	{
		super();
	}
	public Reputacion(int codigoReputacion, int numeroEquipo, int puntos, boolean estado)
	{
		super();
		this.codigoReputacion= codigoReputacion;
		this.numeroEquipo= numeroEquipo;
		this.puntos= puntos;
		this.estado= estado;
	}
	public int getCodigoReputacion() {
		return codigoReputacion;
	}
	public void setCodigoReputacion(int codigoReputacion) {
		this.codigoReputacion = codigoReputacion;
	}
	public int getNumeroEquipo() {
		return numeroEquipo;
	}
	public void setNumeroEquipo(int numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
