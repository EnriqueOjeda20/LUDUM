package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.TipoPago;

public interface ITipoPagoService 
{
	public void insert(TipoPago tpc);
	public List<TipoPago> list();
	public void eliminar(int codigoTipoPago);
	public List<TipoPago> finByTipoPago(TipoPago tcc);
	public void modificar(TipoPago tc);

}

