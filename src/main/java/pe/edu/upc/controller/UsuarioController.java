package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioController {
	@Inject
	private IUsuarioService uService;

	private Usuario usuario;
	List<Usuario> listaUsuarios;

	@PostConstruct /**/
	public void init() {
		usuario = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
		list();
	}

	public String newUsuario() {
		this.setUsuario(new Usuario());
		return "usuario.xhtml";
	}

	public void insert() {
		uService.insert(usuario);
		list();
	}

	public void list() {
		listaUsuarios = uService.list();
	}

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
