package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IEmparejamientoDao;
import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.service.IEmparejamientoService;

public class EmparejamientoServiceImpl implements IEmparejamientoService {
	@Inject
	private IEmparejamientoDao eDao;

	@Override
	public void insert(Emparejamiento e) {
		// TODO Auto-generated method stub
		eDao.insert(e);
	}

	@Override
	public List<Emparejamiento> list() {
		// TODO Auto-generated method stub
		return eDao.list();
	}

}
