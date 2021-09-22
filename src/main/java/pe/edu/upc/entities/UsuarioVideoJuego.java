package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "UsuarioVideoJuego")

public class UsuarioVideoJuego 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoUsuarioVideoJuego;
	
	@ManyToOne
	@Column(name="codigoUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@Column(name="codigoVideojuego", nullable = false)
	private Videojuego videojuego;
	
	public UsuarioVideoJuego()
	{
		super();
	}
	public UsuarioVideoJuego(int codigoUsuarioVideoJuego, Usuario usuario, Videojuego videojuego)
	{
		super();
		this.codigoUsuarioVideoJuego=codigoUsuarioVideoJuego;
		this.usuario = usuario;
		this.videojuego = videojuego;
	}
	public int getCodigoUsuarioVideoJuego() {
		return codigoUsuarioVideoJuego;
	}
	public void setCodigoUsuarioVideoJuego(int codigoUsuarioVideoJuego) {
		this.codigoUsuarioVideoJuego = codigoUsuarioVideoJuego;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoUsuarioVideoJuego,videojuego, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioVideoJuego other = (UsuarioVideoJuego) obj;
		return codigoUsuarioVideoJuego == other.codigoUsuarioVideoJuego && Objects.equals(videojuego, other.videojuego)
				&& Objects.equals(usuario, other.usuario);
	}
}
