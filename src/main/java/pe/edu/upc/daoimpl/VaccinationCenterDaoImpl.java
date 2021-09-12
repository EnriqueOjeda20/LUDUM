package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IVaccinationCenterDao;
import pe.edu.upc.entities.VaccinationCenter;

public class VaccinationCenterDaoImpl implements IVaccinationCenterDao {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(VaccinationCenter vc) {

		try {
			em.persist(vc);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaccinationCenter> list() {
		List<VaccinationCenter> lista = new ArrayList<VaccinationCenter>();
		try {

			Query q = em.createQuery("select v from VaccinationCenter v");
			lista = (List<VaccinationCenter>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

}
