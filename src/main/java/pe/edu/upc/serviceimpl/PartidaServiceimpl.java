package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPartidaDao;
import pe.edu.upc.entities.Partida;
import pe.edu.upc.service.IPartidaService;

@Named
@RequestScoped

public class PartidaServiceimpl implements IPartidaService
{
	@Inject
	private IPartidaDao pDao;

	@Override
	public void insert(Partida pc) 
	{
	pDao.insert(pc);	// TODO Auto-generated method stub
		
	}

	@Override
	public List<Partida> list() 
	{
		// TODO Auto-generated method stub
		return pDao.list();
	}

}
