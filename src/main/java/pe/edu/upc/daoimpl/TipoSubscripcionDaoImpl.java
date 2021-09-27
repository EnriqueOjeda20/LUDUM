package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoSubscripcionDao;
import pe.edu.upc.entities.TipoSubscripcion;




public class TipoSubscripcionDaoImpl implements ITipoSubscripcionDao
{
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(TipoSubscripcion tsub)
	{
		try
		{
			em.persist(tsub);
		} 
		catch(Exception e)
		{
			System.out.println("Error al insertar");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSubscripcion> list()
	{
		List<TipoSubscripcion> lista = new ArrayList<TipoSubscripcion>();
		try
		{
			Query q=em.createQuery("select v from TipoSubscripcion v");
			lista = (List<TipoSubscripcion>) q.getResultList();
		} catch (Exception e)
		{
			
		}
		return lista;
	}
	@Transactional
	@Override
	public void modificar(TipoSubscripcion tsub) {
		try {
			em.merge(tsub);
		} catch (Exception e) {
			System.out.println("Error al editar ");
		}
		
	}
	@Transactional
	@Override
	public void eliminar(int codigoTipoSubscripcion) {
		TipoSubscripcion med = new TipoSubscripcion();
		try {
			med = em.getReference(TipoSubscripcion.class, codigoTipoSubscripcion);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSubscripcion> finByNameTipoSubscripcion(TipoSubscripcion tsubs) {
		List<TipoSubscripcion> lista = new ArrayList<TipoSubscripcion>();
		try {
			Query q = em.createQuery("from Usuario m where m.nombreTipoSubscripcion like ?1");
			q.setParameter(1, "%" + tsubs.getNombreTipoSubscripcion() + "%");
			lista = (List<TipoSubscripcion>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	

}
