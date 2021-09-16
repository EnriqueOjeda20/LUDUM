package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Insignia;
import pe.edu.upc.entities.Videojuego;
import pe.edu.upc.service.IInsigniaService;
import pe.edu.upc.service.IVideojuegoService;



@Named
@RequestScoped
public class InsigniaController {
	@Inject
	private IInsigniaService iService;
	@Inject
	private IVideojuegoService vService;
	//atributo
	private Insignia insignia;
	private Videojuego videojuego;
	List<Insignia> listaInsignias;
	List<Videojuego> listaVideojuegos;
	@PostConstruct
	public void init()
	{
		this.insignia= new Insignia();
		this.videojuego=new Videojuego();
		this.listaInsignias= new ArrayList<Insignia>();
		this.listaVideojuegos= new ArrayList<Videojuego>();
		this.listInsignia();
		this.listVideojuego();
	}
	
	public String newInsignia() {
		this.setInsignia(new Insignia());
		this.listVideojuego();
		return "insignia.xhtml";
	}

	public void listVideojuego() {
		listaVideojuegos = vService.list();
	}
	
	

	public void insertInsignia() {
		iService.insert(insignia);
		this.listInsignia();
	}
	
	

	public void listInsignia() {
		listaInsignias = iService.list();
	}
	
	
	
	
	//getters & setters
	public Insignia getInsignia() {
		return insignia;
	}

	public void setInsignia(Insignia insignia) {
		this.insignia = insignia;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public List<Insignia> getListaInsignias() {
		return listaInsignias;
	}

	public void setListaInsignias(List<Insignia> listaInsignias) {
		this.listaInsignias = listaInsignias;
	}

	public List<Videojuego> getListaVideojuegos() {
		return listaVideojuegos;
	}

	public void setListaVideojuegos(List<Videojuego> listaVideojuegos) {
		this.listaVideojuegos = listaVideojuegos;
	}
	
	
	

	
}
