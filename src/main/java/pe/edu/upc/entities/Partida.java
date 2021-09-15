package pe.edu.upc.entities;

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

	@Column(name = "estado_Partida", nullable = false, length = 20)
	private boolean estado_Partida;
	@Column(name = "estado_Sinerror", nullable = false, length = 20)
	private boolean estado_Sinerror;

	public Partida() {
		super();
	}

	public Partida(int codigoPartida, boolean estado_Partida, boolean estado_Sinerror) {
		super();
		this.codigoPartida = codigoPartida;
		this.estado_Partida = estado_Partida;
		this.estado_Sinerror = estado_Sinerror;

	}

	public int getcodigoPartida() {
		return codigoPartida;
	}

	public void setcodigoVideoPartida(int codigoPartida) {
		this.codigoPartida = codigoPartida;
	}

	public boolean getestado_Partida() {
		return estado_Partida;
	}

	public void setestado_Partida(boolean estado_Partida) {
		this.estado_Partida = estado_Partida;
	}

	public boolean getestado_Sinerror() {
		return estado_Sinerror;
	}

	public void setestado_Sinerror(boolean estado_Sinerror) {
		this.estado_Sinerror = estado_Sinerror;
	}

}