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

	@Transactional
	@Override
	public void eliminar(int idSubscripcion) {
		Subscripcion med = new Subscripcion();
		try {
			med = em.getReference(Subscripcion.class, idSubscripcion);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void modificar(Subscripcion subscripcion) {
		try {
			em.merge(subscripcion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
