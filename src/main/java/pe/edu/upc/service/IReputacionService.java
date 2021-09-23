package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Reputacion;

public interface IReputacionService {
	public void insert(Reputacion r);
	public List <Reputacion> list();
	
	public void Eliminar(int codigoReputacion);

}
