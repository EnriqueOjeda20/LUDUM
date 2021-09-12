package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPersonDao;
import pe.edu.upc.entities.Person;
import pe.edu.upc.service.IPersonService;

@Named
@RequestScoped
public class PersonServiceImpl implements IPersonService {
	@Inject
	private IPersonDao pDao;

	@Override
	public void insert(Person p) {
		pDao.insert(p);
	}

	@Override
	public List<Person> list() {

		return pDao.list();
	}

}
