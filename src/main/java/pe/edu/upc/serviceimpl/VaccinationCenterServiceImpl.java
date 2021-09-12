package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IVaccinationCenterDao;
import pe.edu.upc.entities.VaccinationCenter;
import pe.edu.upc.service.IVaccinationCenterService;

@Named
@RequestScoped
public class VaccinationCenterServiceImpl implements IVaccinationCenterService {
	@Inject
	private IVaccinationCenterDao vDao;

	@Override
	public void insert(VaccinationCenter vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);
	}

	@Override
	public List<VaccinationCenter> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

}
