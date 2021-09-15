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
	
}
