package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISubscripcionDao;
import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.service.ISubscripcionService;

@Named
@RequestScoped
public class SubscripcionServiceImpl implements ISubscripcionService {
	@Inject
	private ISubscripcionDao sDao;
	@Override
	public void insert(Subscripcion s) {
		sDao.insert(s);
		
	}
	
	@Override
	public void eliminar(int idSubscripcion) {
		// TODO Auto-generated method stub
		sDao.eliminar(idSubscripcion);
	}

	@Override
	public List<Subscripcion> list() {
		// TODO Auto-generated method stub
		return sDao.list();
	}

	@Override
	public void modificar(Subscripcion subscripcion) {
		sDao.modificar(subscripcion);	
	}
	
	
	

}
