package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IReputacionDao;
import pe.edu.upc.entities.Reputacion;
import pe.edu.upc.service.IReputacionService;

@Named
@RequestScoped
public class ReputacionServiceImpl implements IReputacionService {
	@Inject
	private IReputacionDao rDao;
	@Override
	public void insert(Reputacion r) {
		rDao.insert(r);
		
	}

	@Override
	public List<Reputacion> list() {
		return rDao.list();
	}

	@Override
	public void Eliminar(int codigoReputacion) 
	{
		
		rDao.Eliminar(codigoReputacion);
		
	}

	@Override
	public List<Reputacion> finByReputacion(Reputacion rcc) {
		// TODO Auto-generated method stub
		return rDao.finByReputacion(rcc);
	}

	@Override
	public void modificar(Reputacion rc) {
		rDao.modificar(rc);
		
	}

}
