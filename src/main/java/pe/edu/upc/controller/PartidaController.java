package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Partida;
import pe.edu.upc.service.IPartidaService;

@Named
@RequestScoped
public class PartidaController {
	@Inject
	private IPartidaService pService;

	private Partida partida;
	List<Partida> listaPartida;

	@PostConstruct /**/
	public void init() {
		partida = new Partida();
		listaPartida = new ArrayList<Partida>();
		list();
	}

	// metodos

	public String newPartida() {
		this.setPartida(new Partida());
		return "partida.xhtml";
	}
	public void insert() {
		pService.insert(partida);
		list();
	}

	public void list() {
		listaPartida = pService.list();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Partida> getListaPartida() {
		return listaPartida;
	}

	public void setListaPartida(List<Partida> listaPartida) {
		this.listaPartida = listaPartida;
	}

}
