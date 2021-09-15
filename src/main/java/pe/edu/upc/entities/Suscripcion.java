package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoSuscripcion;

	@ManyToOne
	@JoinColumn(name = "codigoTipoPago", nullable = false)
	private TipoPago codigoTipoPago;

	public Suscripcion() {
		super();
	}

	public Suscripcion(int codigoSuscripcion, TipoPago codigoTipoPago) {
		this.codigoSuscripcion = codigoSuscripcion;
		this.codigoTipoPago = codigoTipoPago;
	}

	public int getCodigoSuscripcion() {
		return codigoSuscripcion;
	}

	public void setCodigoSuscripcion(int codigoSuscripcion) {
		this.codigoSuscripcion = codigoSuscripcion;
	}

	public TipoPago getcodigoTipoPago() {
		return codigoTipoPago;
	}

	public void setcodigoTipoPago(TipoPago codigoTipoPago) {
		this.codigoTipoPago = codigoTipoPago;
	}
}