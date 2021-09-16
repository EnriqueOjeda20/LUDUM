package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Suscripcion;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.service.ISuscripcionService;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped
public class SuscripcionController {
	@Inject
	private ISuscripcionService sService;
	@Inject
	private ITipoPagoService tService;

	private Suscripcion suscripcion;
	private TipoPago tipopago;
	List<Suscripcion> listaSuscripcion;
	List<TipoPago> listaTipoPago;

	// constructor
	@PostConstruct
	public void init() {
		this.suscripcion = new Suscripcion();
		this.tipopago = new TipoPago();
		this.listaSuscripcion = new ArrayList<Suscripcion>();
		this.listaTipoPago = new ArrayList<TipoPago>();
		this.listSuscripcion();
		this.listTipoPago();
	}

	public String newSuscripcion() {
		this.setSuscripcion(new Suscripcion());
		this.listTipoPago();
		return "suscripcion.xhtml";
	}

	public void listTipoPago() {
		listaTipoPago = tService.list();
	}

	public void insertSuscripcion() {
		sService.insert(suscripcion);
		this.listSuscripcion();
	}

	public void listSuscripcion() {
		listaSuscripcion = sService.list();
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
	}

	public List<Suscripcion> getListaSuscripcion() {
		return listaSuscripcion;
	}

	public void setListaSuscripcion(List<Suscripcion> listaSuscripcion) {
		this.listaSuscripcion = listaSuscripcion;
	}

	public List<TipoPago> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPago> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}

}
