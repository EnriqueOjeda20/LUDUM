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
	

}
