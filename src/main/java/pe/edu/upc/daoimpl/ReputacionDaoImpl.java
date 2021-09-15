package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IReputacionDao;
import pe.edu.upc.entities.Reputacion;

public class ReputacionDaoImpl implements IReputacionDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Reputacion rc) {
		try {
			em.persist(rc);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Reputacion> list() {
		List<Reputacion> lista = new ArrayList<Reputacion>();
		try {
			Query q = em.createQuery("select p from Person p");
			lista = (List<Reputacion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}

}
