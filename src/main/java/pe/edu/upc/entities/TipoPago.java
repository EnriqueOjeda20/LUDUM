package pe.edu.upc.entities;

import java.util.Objects;

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

	public TipoPago() {
		super();
	}

	public TipoPago(int codigoTipoPago, String nombreTipoPago) {
		super();
		this.codigoTipoPago = codigoTipoPago;
		this.nombreTipoPago = nombreTipoPago;

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

	@Override
	public int hashCode() {
		return Objects.hash(codigoTipoPago, nombreTipoPago);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPago other = (TipoPago) obj;
		return codigoTipoPago == other.codigoTipoPago && Objects.equals(nombreTipoPago, other.nombreTipoPago);
	}

}