package pe.edu.upc.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoPago")

public class TipoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoTipoPago;
	@Column(name = "nombreTipoPago", nullable = false, length = 45)
	private String nombreTipoPago;
	@Column(name = "estadoPago", nullable = false, length = 45)
	private boolean estadoPago;

	public TipoPago() {
		super();
	}

	public TipoPago(int codigoTipoPago, String nombreTipoPago, boolean estadoPago) {
		super();
		this.codigoTipoPago = codigoTipoPago;
		this.nombreTipoPago = nombreTipoPago;
		this.estadoPago = estadoPago;
	}

	public int getCodigoTipoPago() {
		return codigoTipoPago;
	}

	public void setCodigoTipoPago(int codigoTipoPago) {
		this.codigoTipoPago = codigoTipoPago;
	}

	public String getNombreTipoPago() {
		return nombreTipoPago;
	}

	public void setNombreTipoPago(String nombreTipoPago) {
		this.nombreTipoPago = nombreTipoPago;
	}

	public boolean getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(boolean estadoPago) {
		this.estadoPago = estadoPago;
	}
}