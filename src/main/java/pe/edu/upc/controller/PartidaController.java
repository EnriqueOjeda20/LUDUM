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
		try {
		pService.insert(partida);
		list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Partida partida) {
		try {
			pService.eliminar(partida.getCodigoPartida());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
		listaPartida = pService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void clean() {
		this.init();
	}
	public void findByEstadoPartida() {
		try {
			if (partida.isEstadoPartida()) {
				this.list();
			} else {

				listaPartida = this.pService.finByEstadoPartida(this.getPartida());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String goUpdate4(Partida partida) {
		System.out.println("Estado de la partida: " + partida.isEstadoPartida());
		this.setPartida(partida);;
		System.out.println("goUpdate");
		return "partidaUpdate.xhtml";
	}

	public void modificar() {
		try {
			pService.modificar(partida);
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get y set

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
