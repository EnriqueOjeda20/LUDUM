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
			System.out.println("Error al insertar reputacion");
		}	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Reputacion> list() {
		List<Reputacion> lista = new ArrayList<Reputacion>();
		try {
			Query q = em.createQuery("select p from Reputacion p");
			lista = (List<Reputacion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void Eliminar(int codigoReputacion) 
	{
		Reputacion r = new Reputacion();
		try {
			r = em.getReference(Reputacion.class, codigoReputacion);
			em.remove(r);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Transactional
	@Override
	public void modificar(Reputacion rc) {
		try {
			em.merge(rc);
		} catch (Exception e) {
			System.out.println("Error al editar");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Reputacion> finByReputacion(Reputacion rcc) {
		List<Reputacion> lista = new ArrayList<Reputacion>();
		try {
			Query q = em.createQuery("from Usuario m where m.estadoReputacion like ?1");
			q.setParameter(1, "%" + rcc.getEstadoReputacion() + "%");
			lista = (List<Reputacion>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
