package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioVideoJuego;
import pe.edu.upc.entities.Videojuego;

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
	
	private UsuarioVideoJuego usuariovideojuego;
	private Videojuego videojuego;
	private Usuario usuario;
	
	List<UsuarioVideoJuego> listaUsuarioVideojuego;
	List<Videojuego> listaVideojuego;
	List<Usuario> listaUsuario;
	

	// constructor
	@PostConstruct
	public void init() 
	{
		this.usuariovideojuego = new UsuarioVideoJuego();
		this.videojuego= new Videojuego();
		this.usuario= new Usuario();
		
		this.listaUsuarioVideojuego = new ArrayList<UsuarioVideoJuego>();
		this.listaVideojuego = new ArrayList<Videojuego>();
		this.listaUsuario = new ArrayList<Usuario>();
		
		this.listUsuarioVideoJuego();
		this.listVideojuego();
		this.listUsuario();
	}

	public String newUsuarioVideoJuego() 
	{
		this.setUsuariovideojuego(new UsuarioVideoJuego());
		this.listVideojuego();
		this.listUsuario();
		
		return "usuariovideojuego.xhtml"; // ojito 
	}
	
	public void listUsuarioVideoJuego() 
	{
		listaUsuarioVideojuego = wService.list();
	}
	public void listVideojuego() 
	{
		listaVideojuego = vService.list();
	}
	
	public void listUsuario() 
	{
		listaUsuario = uService.list();
	}

	
	

	public void insert2() {
		try {
			wService.insert(usuariovideojuego);
			this.list();
		} catch (Exception e) 
		{
			e.getMessage();
			}
	}
	
	public void eliminar (UsuarioVideoJuego usuariovideojuego) {
		try {
			wService.eliminar(usuariovideojuego.getCodigoUsuarioVideoJuego());
			list();
		} catch (Exception e)
		{
			e.getMessage();
		}
	}
	public void list () 
	{
		try {
			listaUsuarioVideojuego = wService.list();
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public void clean() {
		this.init();
	}
	public String goUpdate5(UsuarioVideoJuego usuariovideojuego) 
	{
		System.out.println("UsuarioVideoJuego : " + usuariovideojuego.getCodigoUsuarioVideoJuego());
		this.setUsuariovideojuego(usuariovideojuego);
		System.out.println("goUpdate");
		return "usuariovideojuegoUpdate.xhtml";
	}
	
	public void modificar() {
		try {
			wService.modificar(usuariovideojuego);
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get and set 

	public UsuarioVideoJuego getUsuariovideojuego() {
		return usuariovideojuego;
	}

	public void setUsuariovideojuego(UsuarioVideoJuego usuariovideojuego) {
		this.usuariovideojuego = usuariovideojuego;
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
