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

}
