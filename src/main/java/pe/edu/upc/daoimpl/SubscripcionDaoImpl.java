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
	public void insert(Subscripcion sc) 
	{
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
			Query q = em.createQuery("select sbs from Subscripcion sbs");
			lista = (List<Subscripcion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar subscripcion");
		}
		return lista;
	}
	@Transactional
	@Override
	public void Eliminar(int codigoSubscripcion) 
	{
		Subscripcion med = new Subscripcion();
		try {
			med = em.getReference(Subscripcion.class, codigoSubscripcion);
			em.remove(med);
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscripcion> finBySubscripcion(Subscripcion scc) 
	{
		List<Subscripcion> lista = new ArrayList<>();
		try {
			Query q = em.createQuery("from Subscripcion m where m.codigoSubscripcion like ?1");
			q.setParameter(1, "%" + scc.getCodigoSubscripcion() + "%");
			lista = (List<Subscripcion>) q.getResultList();
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return lista;
	}
	@Transactional
	@Override
	public void Modificar(Subscripcion sc) 
	{
		try {
			em.merge(sc);
		} catch (Exception e) 
		{
			System.out.println("Error al editar ");
		}
		
	}

}
