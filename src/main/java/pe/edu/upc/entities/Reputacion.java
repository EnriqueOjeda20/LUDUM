package pe.edu.upc.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reputacion")

public class Reputacion 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoReputacion;
	
	@ManyToOne
	@JoinColumn(name ="codigoUsuario",nullable=false)
	private Usuario usuario;
	
	@Column(name = "Puntos", nullable = false, length = 20)
	private int puntos;
	
	@Column(name = "estado_Reputacion", nullable = false, length = 20)
	private boolean estadoReputacion;
	
	public Reputacion()
	{
		super();
	}
	
	public Reputacion(int codigoReputacion, Usuario usuario, int puntos, boolean estadoReputacion)
	{
		super();
		this.codigoReputacion = codigoReputacion;
		this.usuario = usuario;
		this.puntos = puntos;
		this.estadoReputacion = estadoReputacion;
		
	}
	public int getCodigoReputacion()
	{
		return codigoReputacion;
	}
	public void setCodigoReputacion(int codigoReputacion)
	{
		this.codigoReputacion=codigoReputacion;
	}
	public Usuario getUsuario()
	{
		return usuario;
	}
	public void setUsuario(Usuario usuario)
	{
		this.usuario=usuario;
	}
	public int getPuntos() 
	{
		return puntos;
	}
	public void setPuntos(int puntos)
	{
		this.puntos=puntos;
	}
	public boolean getEstadoReputacion()
	{
		return estadoReputacion;
	}
	public void setEstadoReputacion(boolean estadoReputacion)
	{
		this.estadoReputacion=estadoReputacion;
	}
	

}