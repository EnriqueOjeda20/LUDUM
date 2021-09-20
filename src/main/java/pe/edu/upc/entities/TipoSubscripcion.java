package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoSubscripcion")
public class TipoSubscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoTipoSubscripcion;
	@Column(name = "nombreTipoSubscripcion", nullable = false, length = 45)
	private String nombreTipoSubscripcion;
	public TipoSubscripcion() {
		super();
	}
	public TipoSubscripcion(int codigoTipoSubscripcion, String nombreTipoSubscripcion) {
		super();
		this.codigoTipoSubscripcion = codigoTipoSubscripcion;
		this.nombreTipoSubscripcion = nombreTipoSubscripcion;
	}
	public int getCodigoTipoSubscripcion() {
		return codigoTipoSubscripcion;
	}
	public void setCodigoTipoSubscripcion(int codigoTipoSubscripcion) {
		this.codigoTipoSubscripcion = codigoTipoSubscripcion;
	}
	public String getNombreTipoSubscripcion() {
		return nombreTipoSubscripcion;
	}
	public void setNombreTipoSubscripcion(String nombreTipoSubscripcion) {
		this.nombreTipoSubscripcion = nombreTipoSubscripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoTipoSubscripcion, nombreTipoSubscripcion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoSubscripcion other = (TipoSubscripcion) obj;
		return codigoTipoSubscripcion == other.codigoTipoSubscripcion
				&& Objects.equals(nombreTipoSubscripcion, other.nombreTipoSubscripcion);
	}
	
}
