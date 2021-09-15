package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISuscripcionDao;
import pe.edu.upc.entities.Suscripcion;

public class SuscripcionDaoImpl implements ISuscripcionDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Suscripcion sc) {
		try {
			em.persist(sc);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Suscripcion> list() {
		List<Suscripcion> lista = new ArrayList<Suscripcion>();
		try {
			Query q = em.createQuery("select p from Person p");
			lista = (List<Suscripcion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}

}
