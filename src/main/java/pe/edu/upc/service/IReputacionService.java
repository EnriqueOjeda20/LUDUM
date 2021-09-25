package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Reputacion;

public interface IReputacionService {
	public void insert(Reputacion rc);
	public List<Reputacion> list();
	public void Eliminar(int codigoReputacion);
	public List<Reputacion> finByReputacion(Reputacion rcc);
	public void modificar(Reputacion rc);

}
