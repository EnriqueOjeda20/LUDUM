package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.entities.Partida;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioVideoJuego;
import pe.edu.upc.entities.Videojuego;
import pe.edu.upc.service.IEmparejamientoService;
import pe.edu.upc.service.IPartidaService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IUsuarioVideoJuegoService;
import pe.edu.upc.service.IVideojuegoService;

@Named
@RequestScoped
public class UsuarioVideoJuegoController {
	@Inject
	private IUsuarioVideoJuegoService wService;
	@Inject
	private IVideojuegoService vService;
	@Inject
	private IUsuarioService uService;
	// atributos
	private UsuarioVideoJuego codigoUsuarioVideoJuego;
	private Videojuego videojuego;
	private Usuario usuario;
	List<UsuarioVideoJuego> listaUsuarioVideojuego;
	List<Videojuego> listaVideojuego;
	List<Usuario> listaUsuario;
	

	// constructor
	@PostConstruct
	public void init() {
		this.codigoUsuarioVideoJuego = new UsuarioVideoJuego();
		this.videojuego= new Videojuego();
		this.usuario= new Usuario();
		this.listaUsuarioVideojuego = new ArrayList<UsuarioVideoJuego>();
		this.listaVideojuego = new ArrayList<Videojuego>();
		this.listaUsuario = new ArrayList<Usuario>();
		this.listUsuarioVideoJuego();
		this.listVideojuego();
		this.listUsuario();
	}

	public String newcodigoUsuarioVideoJuego() {
		this.setCodigoUsuarioVideoJuego(new UsuarioVideoJuego());
		this.listVideojuego();
		this.listUsuario();
		return "UsuarioVideoJuego.xhtml";
	}

	public void listUsuarioVideoJuego() {
		listaUsuarioVideojuego = wService.list();
	}
	
	public void listVideojuego() {
		listaVideojuego = vService.list();
	}

	public void listUsuario() {
		listaUsuario = uService.list();
	}

	///////////
	
	public UsuarioVideoJuego getCodigoUsuarioVideoJuego() {
		return codigoUsuarioVideoJuego;
	}

	public void setCodigoUsuarioVideoJuego(UsuarioVideoJuego codigoUsuarioVideoJuego) {
		this.codigoUsuarioVideoJuego = codigoUsuarioVideoJuego;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioVideoJuego> getListaUsuarioVideojuego() {
		return listaUsuarioVideojuego;
	}

	public void setListaUsuarioVideojuego(List<UsuarioVideoJuego> listaUsuarioVideojuego) {
		this.listaUsuarioVideojuego = listaUsuarioVideojuego;
	}

	public List<Videojuego> getListaVideojuego() {
		return listaVideojuego;
	}

	public void setListaVideojuego(List<Videojuego> listaVideojuego) {
		this.listaVideojuego = listaVideojuego;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}



}
