package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IVideojuegoDao;
import pe.edu.upc.entities.Videojuego;
import pe.edu.upc.service.IVideojuegoService;

@Named
@RequestScoped
public class VideojuegoServiceimpl implements IVideojuegoService 
{
	@Inject
	private IVideojuegoDao vDao; 
	@Override
	public void insert(Videojuego vc) 
	{
		vDao.insert(vc);// TODO Auto-generated method stub
		
	}

	@Override
	public List<Videojuego> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

	@Override
	public void eliminar(int codigoVideojuego) {
		// TODO Auto-generated method stub
		vDao.eliminar(codigoVideojuego);
	}

	@Override
	public void modificar(Videojuego vc) {
		// TODO Auto-generated method stub
		vDao.modificar(vc);
	}

	@Override
	public List<Videojuego> finByNameVideojuego(Videojuego vcc) {
		// TODO Auto-generated method stub
		return vDao.finByNameVideojuego(vcc);
	}
	
}
