package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.upc.entities.Usuario;

@Named
@SessionScoped
public class LoginService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public LoginService() {
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void logout() {
		this.usuario = null;
	}

}
