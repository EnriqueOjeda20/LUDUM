package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IInsigniaDao;
import pe.edu.upc.entities.Insignia;

public class InsigniaDaoImpl implements IInsigniaDao {

	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Insignia ic) {
		try {
			em.persist(ic);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Insignia> list() {
		List<Insignia> lista = new ArrayList<Insignia>();
		try {
			Query q = em.createQuery("select p from Person p");
			lista = (List<Insignia>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}

}
