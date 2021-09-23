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

@Named
@RequestScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUsuarioService uService;
	private Usuario usur;
	List<Usuario> listaUsuarios;

	@PostConstruct /**/
	public void init() {
		listaUsuarios = new ArrayList<Usuario>();
		usur = new Usuario();
		list();
	}

	public String newUsuario() {
		this.setUsuario(new Usuario());
		return "usuario.xhtml";
	}

	public void insert() {
		try {
			uService.insert(usur);
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Usuario usur) {
		try {
			uService.eliminar(usur.getCodigoUsuario());
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
	public void findByName() {
		try {
			if (usur.getNombreUsuario().isEmpty()) {
				this.list();
			} else {

				listaUsuarios = this.uService.finByNameUsuario(this.getUsuario());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
//get y sett
	public Usuario getUsuario() {
		return usur;
	}

	public void setUsuario(Usuario usuario) {
		this.usur = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
