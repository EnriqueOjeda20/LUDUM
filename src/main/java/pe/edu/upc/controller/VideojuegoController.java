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
	
	
	public void insert() {
		try {
			iService.insert(videojuego);
			list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void eliminar(Videojuego videojuego) {
		try {
			iService.eliminar(videojuego.getCodigoVideojuego());
			list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void clean() {
		this.init();
	}
	
	public void modificar() {
		try {
			iService.modificar(videojuego);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public String goUpdate2(Videojuego videojuego) {
		System.out.println("VideoJuego nickname: " + videojuego.getNickName());
		this.setVideojuego(videojuego);
		System.out.println("goUpdate");
		return "videojuegoUpdate.xhtml";
	}
	
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
