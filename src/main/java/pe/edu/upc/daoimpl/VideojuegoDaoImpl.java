package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IVideojuegoDao;
import pe.edu.upc.entities.Videojuego;

public class VideojuegoDaoImpl implements IVideojuegoDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(Videojuego vc) {
		try {
			em.persist(vc);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}

		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Videojuego> list() {
		List<Videojuego> lista = new ArrayList<Videojuego>();
		try {

			Query q = em.createQuery("select v from Videojuego v");
			lista = (List<Videojuego>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int codigoVideojuego) {
		// TODO Auto-generated method stub
		Videojuego med = new Videojuego();
		try {
			med = em.getReference(Videojuego.class, codigoVideojuego);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Videojuego> finByNameVideojuego(Videojuego vcc) {
		// TODO Auto-generated method stub
		List<Videojuego> lista = new ArrayList<Videojuego>();
		try {
			Query q = em.createQuery("from Videojuego v where v.nickName like ? 1");
			q.setParameter(1, "%" +  vcc.getNickName() + "%");
			lista = (List<Videojuego>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(Videojuego vc) {
		// TODO Auto-generated method stub
		try {
			em.merge(vc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}
	}

}
