package pe.edu.upc.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subscripcion")
public class Subscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoSubscripcion;

	@Column(name = "estadoPago", nullable = false, length = 45)
	private boolean estadoPago;

	@OneToOne
	@JoinColumn(name = "codigoUsuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "codigoTipoPago", nullable = false)
	private TipoPago tipoPago;

	@ManyToOne
	@JoinColumn(name = "codigoTipoSubscripcion", nullable = false)
	private TipoSubscripcion tipoSubscripcion;

	@Column(name = "fechaActivacion", nullable = false)
	private Date fechaActivacion;

	@Column(name = "monto", nullable = false)
	private double monto;

	@Column(name = "tiempo", nullable = false)
	private int tiempo;

	public Subscripcion() {
		super();
	}

	public Subscripcion(int codigoSubscripcion, boolean estadoPago, Usuario usuario, TipoPago tipoPago,
			TipoSubscripcion tipoSubscripcion, Date fechaActivacion, double monto, int tiempo) {
		super();
		this.codigoSubscripcion = codigoSubscripcion;
		this.estadoPago = estadoPago;
		this.usuario = usuario;
		this.tipoPago = tipoPago;
		this.tipoSubscripcion = tipoSubscripcion;
		this.fechaActivacion = fechaActivacion;
		this.monto = monto;
		this.tiempo = tiempo;
	}

	public int getCodigoSubscripcion() {
		return codigoSubscripcion;
	}

	public void setCodigoSubscripcion(int codigoSubscripcion) {
		this.codigoSubscripcion = codigoSubscripcion;
	}

	public boolean isEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(boolean estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public TipoSubscripcion getTipoSubscripcion() {
		return tipoSubscripcion;
	}

	public void setTipoSubscripcion(TipoSubscripcion tipoSubscripcion) {
		this.tipoSubscripcion = tipoSubscripcion;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoSubscripcion, estadoPago, fechaActivacion, monto, tiempo, tipoPago, tipoSubscripcion,
				usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscripcion other = (Subscripcion) obj;
		return codigoSubscripcion == other.codigoSubscripcion && estadoPago == other.estadoPago
				&& Objects.equals(fechaActivacion, other.fechaActivacion)
				&& Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto) && tiempo == other.tiempo
				&& Objects.equals(tipoPago, other.tipoPago) && Objects.equals(tipoSubscripcion, other.tipoSubscripcion)
				&& Objects.equals(usuario, other.usuario);
	}

}