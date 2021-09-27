package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.serviceimpl.LoginService;

@Named
@RequestScoped
public class UsuarioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IUsuarioService uService;
	@Inject
	private LoginService loginService;
	private Usuario usuario;
	List<Usuario> listaUsuarios;
	

	@PostConstruct /**/
	public void init() {
		usuario = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
		list();
	}

	// metodos
	public String newUsuario() {
		this.setUsuario(new Usuario());
		return "usuario.xhtml";
	}
	
	public String login() {
		Usuario usuarioAux = uService.comprobarLogin(usuario);
		if (usuarioAux == null) {
			clean();
			return "usuarioLog.xhtml";
		} else {
			loginService.setUsuario(usuarioAux);
			clean();
			return "panel.xhtml";
		}
	}

	public void insert() {
		try {
			uService.insert(usuario);
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Usuario usuario) {
		try {
			uService.eliminar(usuario.getCodigoUsuario());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
			listaUsuarios = uService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clean() {
		this.init();
	}

	public String goUpdate2(Usuario usuario) {
		this.setUsuario(usuario);
		return "usuarioUpdate.xhtml";
	}

	public void modificar() {
		try {
			uService.modificar(usuario);
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void finByNameUsuario() {
		try {
			if(usuario.getNombreUsuario().isEmpty()) {
				this.list();
			}else {
				listaUsuarios=this.uService.finByNameUsuario(this.getUsuario());
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}

/// get set
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
