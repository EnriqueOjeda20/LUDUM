package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Videojuego;
import pe.edu.upc.service.IVideojuegoService;

@Named
@RequestScoped
public class VideojuegoController {
	@Inject
	private IVideojuegoService iService;
	
	private Videojuego videojuego;
	List<Videojuego> listaVideojuego;
	
	@PostConstruct
	public void init()
	{
		videojuego = new Videojuego();
		listaVideojuego = new ArrayList<Videojuego>();
		list();
	}
	// mètodos
	
	public String newVideojuego()
	{
		this.setVideojuego(new Videojuego());
		return "videojuego.xhtml";
	}
	
	public void list() {
		listaVideojuego= iService.list();
	}
	
	// getters & setters

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public List<Videojuego> getListaVideojuego() {
		return listaVideojuego;
	}

	public void setListaVideojuego(List<Videojuego> listaVideojuego) {
		this.listaVideojuego = listaVideojuego;
	}
	
}
