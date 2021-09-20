package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Insignia")
public class Insignia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoInsignia;

	@Column(name = "nombreInsignia", nullable = false, length = 20)
	private String nombreInsignia;

	@Column(name = "puntosInsignia", nullable = false, length = 20)
	private int puntosInsignia;

	@ManyToOne
	@JoinColumn(name = "codigoVideojuego", nullable = false)
	private Videojuego videojuego;

	public Insignia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insignia(int codigoInsiginia, String nombreInsignia, int puntosInsignia, Videojuego videojuego) {
		super();
		this.codigoInsignia = codigoInsiginia;
		this.nombreInsignia = nombreInsignia;
		this.puntosInsignia = puntosInsignia;
		this.videojuego = videojuego;
	}

	public int getCodigoInsignia() {
		return codigoInsignia;
	}

	public void setCodigoInsignia(int codigoInsignia) {
		this.codigoInsignia = codigoInsignia;
	}

	public String getNombreInsignia() {
		return nombreInsignia;
	}

	public void setNombreInsignia(String nombreInsignia) {
		this.nombreInsignia = nombreInsignia;
	}

	public int getPuntosInsignia() {
		return puntosInsignia;
	}

	public void setPuntosInsignia(int puntosInsignia) {
		this.puntosInsignia = puntosInsignia;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoInsignia, nombreInsignia, puntosInsignia, videojuego);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insignia other = (Insignia) obj;
		return codigoInsignia == other.codigoInsignia && Objects.equals(nombreInsignia, other.nombreInsignia)
				&& puntosInsignia == other.puntosInsignia && Objects.equals(videojuego, other.videojuego);
	}

}
