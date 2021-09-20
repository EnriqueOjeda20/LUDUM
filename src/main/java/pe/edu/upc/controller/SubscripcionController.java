package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.service.ISubscripcionService;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped
public class SubscripcionController {
	@Inject
	private ISubscripcionService sService;
	@Inject
	private ITipoPagoService tService;

	private Subscripcion suscripcion;
	private TipoPago tipopago;
	List<Subscripcion> listaSubscripcion;
	List<TipoPago> listaTipoPago;

	// constructor
	@PostConstruct
	public void init() {
		this.suscripcion = new Subscripcion();
		this.tipopago = new TipoPago();
		this.listaSubscripcion = new ArrayList<Subscripcion>();
		this.listaTipoPago = new ArrayList<TipoPago>();
		this.listSubscripcion();
		this.listTipoPago();
	}

	public String newSubscripcion() {
		this.setSubscripcion(new Subscripcion());
		this.listTipoPago();
		return "suscripcion.xhtml";
	}

	public void listTipoPago() {
		listaTipoPago = tService.list();
	}

	public void insertSubscripcion() {
		sService.insert(suscripcion);
		this.listSubscripcion();
	}

	public void listSubscripcion() {
		listaSubscripcion = sService.list();
	}

	public Subscripcion getSubscripcion() {
		return suscripcion;
	}

	public void setSubscripcion(Subscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
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

}
