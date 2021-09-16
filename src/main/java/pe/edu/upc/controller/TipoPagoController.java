package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.service.ITipoPagoService;

@Named
@RequestScoped
public class TipoPagoController {
	@Inject

	private ITipoPagoService tService;
	// atributos

	private TipoPago tipopago;
	List<TipoPago> listaTipoPago;

	@PostConstruct /**/
	public void init() {
		tipopago = new TipoPago();
		listaTipoPago = new ArrayList<TipoPago>();
		list();
	}

	public String newTipoPago() {
		this.setTipopago(new TipoPago());
		return "vaccination.xhtml";
	}

	public void insert() {
		tService.insert(tipopago);
		list();
	}

	public void list() {
		listaTipoPago = tService.list();
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
	}

	public List<TipoPago> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPago> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}

}
