package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Videojuego;

public interface IVideojuegoService 
{
	public void insert(Videojuego vc);
	List<Videojuego> list();
	public void eliminar(int codigoVideojuego);
	public void modificar(Videojuego vc);
	public List<Videojuego> finByNameVideojuego(Videojuego vcc);
}

// control+shift+o

