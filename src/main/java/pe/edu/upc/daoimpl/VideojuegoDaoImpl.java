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

}
