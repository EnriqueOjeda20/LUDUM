package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Partida")
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoPartida;

	@Column(name = "estadoPartida", nullable = false, length = 20)
	private boolean estadoPartida;
	@Column(name = "estadoSinerror", nullable = false, length = 20)
	private boolean estadoSinerror;

	public Partida() {
		super();
	}

	public Partida(int codigoPartida, boolean estadoPartida, boolean estadoSinerror) {
		super();
		this.codigoPartida = codigoPartida;
		this.estadoPartida = estadoPartida;
		this.estadoSinerror = estadoSinerror;

	}



	
	public int getCodigoPartida() {
		return codigoPartida;
	}

	public void setCodigoPartida(int codigoPartida) {
		this.codigoPartida = codigoPartida;
	}

	public boolean isEstadoPartida() {
		return estadoPartida;
	}

	public void setEstadoPartida(boolean estadoPartida) {
		this.estadoPartida = estadoPartida;
	}

	public boolean isEstadoSinerror() {
		return estadoSinerror;
	}

	public void setEstadoSinerror(boolean estadoSinerror) {
		this.estadoSinerror = estadoSinerror;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoPartida, estadoPartida, estadoSinerror);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return codigoPartida == other.codigoPartida && estadoPartida == other.estadoPartida
				&& estadoSinerror == other.estadoSinerror;
	}

}