package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IUsuarioVideoJuegoDao;
import pe.edu.upc.entities.UsuarioVideoJuego;

public class UsuarioVideoJuegoDaoImpl implements IUsuarioVideoJuegoDao 
{
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;
	
	@Transactional

	@Override
	public void insert(UsuarioVideoJuego uvj) 
	{
		try {
			em.persist(uvj);
		} 
		catch (Exception e)
		{
			System.out.println("Error al insertar emparejamiento de videojuego");
		}
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioVideoJuego> list() 
	{
		List<UsuarioVideoJuego> lista = new ArrayList<UsuarioVideoJuego>();
		try {
			Query q =em.createQuery("Select p from UsuarioVideoJuego p");
			lista = (List<UsuarioVideoJuego>) q.getResultList();
		} catch (Exception e)
		{
			System.out.println("Error al listar Usuario VideoJuego");
		}
		return lista;
	}

}
