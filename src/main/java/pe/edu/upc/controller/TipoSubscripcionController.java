package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.service.ITipoSubscripcionService;

@Named
@RequestScoped

public class TipoSubscripcionController {
	@Inject

	private ITipoSubscripcionService tService;

	private TipoSubscripcion tiposubscripcion;
	List<TipoSubscripcion> listaTipoSubscripcion;

	@PostConstruct /**/
	public void init() {
		tiposubscripcion = new TipoSubscripcion();
		listaTipoSubscripcion = new ArrayList<TipoSubscripcion>();
		list();
	}

	public String newTipoSubscripcion() {
		this.setTiposubscripcion(new TipoSubscripcion());
		return "tiposubscripcion.xhtml";
	}
//metodos
	public void insert() {
		try {
			tService.insert(tiposubscripcion);
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(TipoSubscripcion tiposubscripcion) {
		try {
			tService.eliminar(tiposubscripcion.getCodigoTipoSubscripcion());
			list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
			listaTipoSubscripcion = tService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void clean() {
		this.init();
	}
	public String goUpdate3(TipoSubscripcion tiposubscripcion) {
		System.out.println("TipoSubscripcion tipo: " + tiposubscripcion.getNombreTipoSubscripcion());
		this.setTiposubscripcion(tiposubscripcion);
		System.out.println("goUpdate");
		return "tiposubscripcionUpdate.xhtml";
	}

	public void modificar() {
		try {
			tService.modificar(tiposubscripcion);
			this.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	///// get set
	public TipoSubscripcion getTiposubscripcion() {
		return tiposubscripcion;
	}

	public List<TipoSubscripcion> getListaTipoSubscripcion() {
		return listaTipoSubscripcion;
	}

	public void setListaTipoSubscripcion(List<TipoSubscripcion> listaTipoSubscripcion) {
		this.listaTipoSubscripcion = listaTipoSubscripcion;
	}

	public void setTiposubscripcion(TipoSubscripcion tiposubscripcion) {
		this.tiposubscripcion = tiposubscripcion;
	}

}
