package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.TipoPago;

public interface ITipoPagoService 
{
	public void insert(TipoPago tpc);
	List<TipoPago> list();

}

