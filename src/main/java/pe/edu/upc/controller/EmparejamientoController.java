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

import pe.edu.upc.service.IEmparejamientoService;
import pe.edu.upc.service.IPartidaService;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class EmparejamientoController 
{
	@Inject
	private IEmparejamientoService eService;
	@Inject
	private IUsuarioService uService;
	@Inject
	private IPartidaService pService;
	// atributos
	
	private Emparejamiento emparejamiento;
	private Usuario usuario;
	private Partida partida;
	
	List<Emparejamiento> listaemp;
	List<Usuario> listaUsuario;
	List<Partida> listapartida;

	// constructor
	@PostConstruct
	public void init() 
	{
		this.emparejamiento = new Emparejamiento();
		this.usuario = new Usuario();
		this.partida = new Partida();
		
		this.listaemp = new ArrayList<Emparejamiento>();
		this.listaUsuario = new ArrayList<Usuario>();
		this.listapartida = new ArrayList<Partida>();
		
		this.list();
		this.listUsuario();
		this.listPartida();
	}

	//metodos
	public String newEmparejamiento() 
	{
		this.setEmparejamiento(new Emparejamiento());
		this.listUsuario();
		this.listPartida();
		
		return "emparejamiento.xhtml";
	}

	
	public void listUsuario() 
	{
		listaUsuario = uService.list();
	}

	public void listPartida() 
	{
		listapartida = pService.list();
	}

	public void insert2() 
	{
		try {
		eService.insert(emparejamiento);
		this.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Emparejamiento emparejamiento)
	{
		try {
			eService.eliminar(emparejamiento.getCodigoEmparejamiento());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void list() 
	{
		try {
		listaemp = eService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void clean() {
		this.init();
	}

	public String goUpdate5(Emparejamiento emparejamiento) 
	{
		System.out.println("Emparejamiento : " + emparejamiento.getCodigoEmparejamiento());
		this.setEmparejamiento(emparejamiento);
		System.out.println("goUpdate");
		return "emparejamientoUpdate.xhtml";
	}
	public void modificar() 
	{
		try {
			eService.modificar(emparejamiento);
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	/// get set
	
	public Emparejamiento getEmparejamiento() {
		return emparejamiento;
	}
	
	public void setEmparejamiento(Emparejamiento emparejamiento) {
		this.emparejamiento = emparejamiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Emparejamiento> getListaemp() {
		return listaemp;
	}

	public void setListaemp(List<Emparejamiento> listaemp) 
	{
		this.listaemp = listaemp;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Partida> getListapartida() {
		return listapartida;
	}

	public void setListapartida(List<Partida> listapartida) {
		this.listapartida = listapartida;
	}
	
	/////
	
	// Generado


}
