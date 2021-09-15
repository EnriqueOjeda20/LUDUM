package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoPagoDao;
import pe.edu.upc.entities.TipoPago;


public class TipoPagoDaoImpl implements ITipoPagoDao {
	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(TipoPago tc) {
		try {
			em.persist(tc);
		} catch (Exception e) {

			System.out.println("Error al insertar");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> list() {
		List<TipoPago> lista = new ArrayList<TipoPago>();
		try {

			Query q = em.createQuery("select v from VaccinationCenter v");
			lista = (List<TipoPago>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

}
