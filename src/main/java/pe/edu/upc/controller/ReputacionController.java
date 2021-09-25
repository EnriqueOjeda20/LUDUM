package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Reputacion;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.service.IReputacionService;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class ReputacionController {
	@Inject
	private IReputacionService  rService;
	@Inject
	private IUsuarioService uService;
	
	//
	private Reputacion reputacion;
	private Usuario usuario;
	List<Reputacion> listareputacion;
	List<Usuario> listaUsuario;
	// constructor
	@PostConstruct
	public void init()

	{
		this.reputacion = new Reputacion();
		this.usuario = new Usuario();
		this.listareputacion=new ArrayList<Reputacion>();
		this.listaUsuario = new ArrayList<Usuario>();
		this.listReputacion();
		this.listUsuario();
	}
	//metodos
	public String newReputacion() {
		this.setReputacion(new Reputacion());
		this.listUsuario();
		return"reputacion.xhtml";
	}
	
	
	public void listUsuario() 
	{
		listaUsuario=uService.list();
	}
	
	public void insertReputacion() {
		try {
		rService.insert(reputacion);
		this.listReputacion();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void Eliminar(Reputacion reputacion) {
		try {
			rService.Eliminar(reputacion.getCodigoReputacion());
			listReputacion();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listReputacion() {
		try {
		listareputacion = rService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void clean() {
		this.init();
	}

	public String goUpdate6(Reputacion reputacion) {
		System.out.println("Reputacion: " + reputacion.getEstadoReputacion());
		this.setReputacion(reputacion);;
		System.out.println("goUpdate");
		return "reputacionUpdate.xhtml";
	}

	public void modificar() {
		try {
			rService.modificar(reputacion);
			this.listReputacion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//get and set
	public Reputacion getReputacion() {
		return reputacion;
	}
	public void setReputacion(Reputacion reputacion) {
		this.reputacion = reputacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Reputacion> getListareputacion() {
		return listareputacion;
	}
	public void setListareputacion(List<Reputacion> listareputacion) {
		this.listareputacion = listareputacion;
	}
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
}
