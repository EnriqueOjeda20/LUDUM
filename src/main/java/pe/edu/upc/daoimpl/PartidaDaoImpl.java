package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPartidaDao;
import pe.edu.upc.entities.Partida;

public class PartidaDaoImpl implements IPartidaDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Partida pc) {
		try {
			em.persist(pc);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partida> list() {
		List<Partida> lista = new ArrayList<Partida>();
		try {

			Query q = em.createQuery("select v from Partida v");
			lista = (List<Partida>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

}
