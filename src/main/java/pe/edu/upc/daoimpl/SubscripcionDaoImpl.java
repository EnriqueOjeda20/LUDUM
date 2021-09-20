package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISubscripcionDao;
import pe.edu.upc.entities.Subscripcion;

public class SubscripcionDaoImpl implements ISubscripcionDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Subscripcion sc) {
		try {
			em.persist(sc);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscripcion> list() {
		List<Subscripcion> lista = new ArrayList<Subscripcion>();
		try {
			Query q = em.createQuery("select p from Person p");
			lista = (List<Subscripcion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}

}
