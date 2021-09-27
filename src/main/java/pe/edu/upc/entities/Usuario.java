package pe.edu.upc.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoUsuario;
	@Column(name = "nombreUsuario", nullable = false, length = 45)
	private String nombreUsuario;
	@Column(name = "correo", nullable = false, length = 100)
	private String correo;
	@Column(name = "apellido", nullable = false, length = 20)
	private String apellido;
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	@Column(name = "nickname", nullable = false, length = 20)
	private String nickname;

	public Usuario() {
		super();
	}

	public Usuario(int codigoUsuario, String nombreUsuario, String correo, String apellido, String password,
			String nickname) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.apellido = apellido;
		this.password = password;
		this.nickname = nickname;

	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigoUsuario, correo, nickname, nombreUsuario, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && codigoUsuario == other.codigoUsuario
				&& Objects.equals(correo, other.correo) && Objects.equals(nickname, other.nickname)
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && Objects.equals(password, other.password);
	}

}
