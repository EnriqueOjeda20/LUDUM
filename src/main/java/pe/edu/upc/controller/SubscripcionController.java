package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.entities.TipoSubscripcion;
import pe.edu.upc.service.ISubscripcionService;
import pe.edu.upc.service.ITipoPagoService;
import pe.edu.upc.service.ITipoSubscripcionService;

@Named
@RequestScoped
public class SubscripcionController {
	@Inject
	private ISubscripcionService sService;
	@Inject
	private ITipoPagoService tService;
	@Inject
	private ITipoSubscripcionService tsubService ;
	private String mensaje="error";

	private Subscripcion subscripcion;
	private TipoPago tipopago;
	private TipoSubscripcion tiposubscripcion;
	List<Subscripcion> listaSubscripcion;
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	private Subscripcion subs;
	List<TipoPago> listaTipoPago;
    List<TipoSubscripcion> listaTipoSubscripcion;
	public Subscripcion getSubs() {
		return subs;
	}

	public void setSubs(Subscripcion subs) {
		this.subs = subs;
	}
	// constructor
	@PostConstruct
	public void init() {
		this.subscripcion = new Subscripcion();
		this.tipopago = new TipoPago();
		this.tiposubscripcion= new TipoSubscripcion();
		this.listaSubscripcion = new ArrayList<Subscripcion>();
		this.listaTipoPago = new ArrayList<TipoPago>();
		this.listaTipoSubscripcion= new ArrayList<TipoSubscripcion>();
		this.listSubscripcion();
		this.listTipoPago();
		this.listTipoSubscripcion();
	}
	// metodos
	public String newSubscripcion() {
		this.setSuscripcion(new Subscripcion());
		this.listTipoPago();
		return "suscripcion.xhtml";
	}
	
	public void insert() {
		try {

			sService.insert(subs);
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Subscripcion subscripcion) {
		try {
			sService.eliminar(subscripcion.getCodigoSubscripcion());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listar() {
		try {
			listaSubscripcion = sService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listarTipoPago() {
		try {
			listaTipoPago = tService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listTipoSubscripcion(){
		try {
			listaTipoSubscripcion = tsubService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// modificar
	public void modificar() {
		try {
			sService.modificar(this.subs);
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String Modifpre(Subscripcion sub) {
		this.setSuscripcion(sub);
		return "suscripcion.xhtml";
	}

//list
	public void listTipoPago() {
		listaTipoPago = tService.list();
	}
	public void listarTipoSubscripcion(){
		listaTipoSubscripcion = tsubService.list();
	}

	public void insertSubscripcion() {
		sService.insert(subscripcion);
		this.listSubscripcion();
	}

	public void listSubscripcion() {
		listaSubscripcion = sService.list();
	}
	// getters and setters

	public Subscripcion getSuscripcion() {
		return subscripcion;
	}

	public void setSuscripcion(Subscripcion suscripcion) {
		this.subscripcion = suscripcion;
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
	}

	public TipoSubscripcion getTiposubscripcion() {
		return tiposubscripcion;
	}

	public void setTiposubscripcion(TipoSubscripcion tiposubscripcion) {
		this.tiposubscripcion = tiposubscripcion;
	}

	public List<Subscripcion> getListaSubscripcion() {
		return listaSubscripcion;
	}

	public void setListaSubscripcion(List<Subscripcion> listaSubscripcion) {
		this.listaSubscripcion = listaSubscripcion;
	}

	public List<TipoPago> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPago> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}

	public List<TipoSubscripcion> getListaTipoSubscripcion() {
		return listaTipoSubscripcion;
	}

	public void setListaTipoSubscripcion(List<TipoSubscripcion> listaTipoSubscripcion) {
		this.listaTipoSubscripcion = listaTipoSubscripcion;
	}


}
