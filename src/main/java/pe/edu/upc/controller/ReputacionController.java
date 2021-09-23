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
	
	public String newReputacion() {
		this.setReputacion(new Reputacion());
		this.listUsuario();
		return"reputacion.xhtml";
	}
	//
	
	public void listUsuario() 
	{
		listaUsuario=uService.list();
	}
	
	public void insertReputacion() {
		rService.insert(reputacion);
		this.listReputacion();
	}
	
	

	public void listReputacion() {
		listareputacion = rService.list();
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
