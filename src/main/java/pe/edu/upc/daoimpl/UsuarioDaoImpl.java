package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entities.Usuario;



public class UsuarioDaoImpl implements IUsuarioDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(Usuario usur) {
		try {
			em.persist(usur);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}

		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			Query q = em.createQuery("select v from Usuario v");
			lista = (List<Usuario>) q.getResultList();
		}catch(Exception e)
		{
			
		}
		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idUsuario) {
		Usuario med = new Usuario();
		try {
			med = em.getReference(Usuario.class, idUsuario);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> finByNameUsuario(Usuario us) {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			Query q = em.createQuery("from Usuario m where m.nombreUsuario like ?1");
			q.setParameter(1, "%" + us.getNombreUsuario() + "%");
			lista = (List<Usuario>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	
}
