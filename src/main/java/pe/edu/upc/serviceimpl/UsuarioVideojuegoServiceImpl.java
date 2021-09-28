package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;


import pe.edu.upc.dao.IUsuarioVideoJuegoDao;
import pe.edu.upc.entities.UsuarioVideoJuego;
import pe.edu.upc.service.IUsuarioVideoJuegoService;


public class UsuarioVideojuegoServiceImpl implements IUsuarioVideoJuegoService 
{
	@Inject 
	private IUsuarioVideoJuegoDao eDao;
	
	@Override
	public void insert (UsuarioVideoJuego e)
	{
		eDao.insert(e);
	}
	
	@Override
	public List <UsuarioVideoJuego> list()
	{
		return eDao.list();
	}
	@Override
	public void eliminar(int codigoUsuarioVideojuego) {
		eDao.eliminar(codigoUsuarioVideojuego);
	}
	
	@Override
	public void modificar(UsuarioVideoJuego ec) {
		eDao.modificar(ec);
		
	}

}
