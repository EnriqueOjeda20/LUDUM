package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Videojuego")
public class Videojuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoVideojuego;
	@Column(name = "numeroEquipo", nullable = false)
	private int numeroEquipo;
	@Column(name = "nickName", nullable = false, length = 8)
	private String nickName;
	@Column(name = "plataforma", nullable = false, length = 20)
	private String plataforma;

	public Videojuego() {
		super();
	}

	public Videojuego(int codigoVideojuego, int numeroEquipo, String nickName, String plataforma) {
		super();
		this.codigoVideojuego = codigoVideojuego;
		this.numeroEquipo = numeroEquipo;
		this.nickName = nickName;
		this.plataforma = plataforma;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigoVideojuego, nickName, numeroEquipo, plataforma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return codigoVideojuego == other.codigoVideojuego && Objects.equals(nickName, other.nickName)
				&& numeroEquipo == other.numeroEquipo && Objects.equals(plataforma, other.plataforma);
	}

}