package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.TipoPago;



public interface ITipoPagoDao {
	
	public void insert(TipoPago tc);
	public List<TipoPago> list();
	public void eliminar(int codigoTipoPago);
	public List<TipoPago> finByTipoPago(TipoPago tcc);
	public void modificar(TipoPago tc);
	
}

