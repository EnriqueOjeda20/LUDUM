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

public class TipoSubscripcionController 
{
	@Inject
	
	private ITipoSubscripcionService tService;
	
	private TipoSubscripcion tiposubscripcion;
	List<TipoSubscripcion> listaTipoSubscripcion;
	
	@PostConstruct /**/
	public void init()
	{
		tiposubscripcion = new TipoSubscripcion();
		listaTipoSubscripcion = new ArrayList<TipoSubscripcion>();
		list();
	}
	
	public String newTipoSubscripcion()
	{
		this.setTiposubscripcion(new TipoSubscripcion());
		return "tiposubscripcion.xhtml";
	}
	public void insert()
	{
		tService.insert(tiposubscripcion);
		list();
	}
	
	public void list()
	{
		listaTipoSubscripcion = tService.list();
	}

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
	
	
	
	
