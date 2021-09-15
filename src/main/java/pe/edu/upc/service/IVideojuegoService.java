package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Videojuego;

public interface IVideojuegoService 
{
	public void insert(Videojuego vc);
	List<Videojuego> list();
}

// control+shift+o

