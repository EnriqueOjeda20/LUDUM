package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IInsigniaDao;
import pe.edu.upc.entities.Insignia;
import pe.edu.upc.service.IInsigniaService;

@Named
@RequestScoped
public class InsigniaServiceImpl implements IInsigniaService {
	@Inject
	private IInsigniaDao iDao;
	@Override
	public void insert(Insignia i) {
		iDao.insert(i);
	}

	@Override
	public List<Insignia> list() {
		return iDao.list();
	}
}
