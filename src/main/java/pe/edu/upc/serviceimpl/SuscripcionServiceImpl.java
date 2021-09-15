package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISuscripcionDao;
import pe.edu.upc.entities.Suscripcion;
import pe.edu.upc.service.ISuscripcionService;

@Named
@RequestScoped
public class SuscripcionServiceImpl implements ISuscripcionService {
	@Inject
	private ISuscripcionDao sDao;
	@Override
	public void insert(Suscripcion s) {
		sDao.insert(s);
		
	}

	@Override
	public List<Suscripcion> list() {
		// TODO Auto-generated method stub
		return sDao.list();
	}

}
