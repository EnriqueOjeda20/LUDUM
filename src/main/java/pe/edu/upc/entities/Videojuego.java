package pe.edu.upc.entities;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Videojuego")
public class Videojuego {	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int codigoVideojuego;
	@Column(name= "numeroEquipo" , nullable = false, length = 45)
	private int numeroEquipo;
	@Column (name= "nickName" , nullable = false, length = 8)
	private String nickName;
	@Column (name= "plataforma" , nullable = false, length = 20)
	private String plataforma;

	public Videojuego()
	{
		super();
	}
	public Videojuego(int codigoVideojuego, int numeroEquipo, String nickName, String plataforma)
	{
		super();
		this.codigoVideojuego= codigoVideojuego;
		this.numeroEquipo= numeroEquipo;
		this.nickName= nickName;
		this.plataforma= plataforma;
    }
	public int getCodigoVideojuego() {
		return codigoVideojuego;
	}
	public void setCodigoVideojuego(int codigoVideojuego) {
		this.codigoVideojuego = codigoVideojuego;
	}
	public int getNumeroEquipo() {
		return numeroEquipo;
	}
	public void setNumeroEquipo(int numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}