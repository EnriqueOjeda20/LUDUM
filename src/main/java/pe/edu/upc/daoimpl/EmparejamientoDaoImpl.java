package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEmparejamientoDao;
import pe.edu.upc.entities.Emparejamiento;
import pe.edu.upc.entities.Usuario;


public class EmparejamientoDaoImpl implements IEmparejamientoDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional

	@Override
	public void insert(Emparejamiento ec) 
	{
		try {
			em.persist(ec);
		} 
		catch (Exception e)
		{
			System.out.println("Error al insertar emparejamiento");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Emparejamiento> list() 
	{
		List<Emparejamiento> lista = new ArrayList<Emparejamiento>();
		try {
			Query q = em.createQuery("select p from Emparejamiento p");
			lista = (List<Emparejamiento>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar emparejamiento");
		}
		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int codigoEmparejamiento) {
		Emparejamiento med = new Emparejamiento();
		try {
			med = em.getReference(Emparejamiento.class, codigoEmparejamiento);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Transactional
	@Override
	public void modificar(Emparejamiento ec) {
		try {
			em.merge(ec);
		} catch (Exception e) {
			System.out.println("Error al editar ");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Emparejamiento> finByEmparejamientos(Emparejamiento ecc) {
		List<Emparejamiento> lista = new ArrayList<>();
		try {
			Query q = em.createQuery("from Usuario m where m.codigoEmparejamiento like ?1");
			q.setParameter(1, "%" + ecc.getCodigoEmparejamiento() + "%");
			lista = (List<Emparejamiento>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
