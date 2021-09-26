package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoPagoDao;
import pe.edu.upc.entities.Emparejamiento;
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

			Query q = em.createQuery("select v from TipoPago v");
			lista = (List<TipoPago>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar tipo pago");
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int codigoTipoPago) {
		// TODO Auto-generated method stub
		TipoPago med = new TipoPago();
		try {
			med = em.getReference(TipoPago.class, codigoTipoPago);
			em.remove(med);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> finByTipoPago(TipoPago tcc) {
		// TODO Auto-generated method stub
		List<TipoPago> lista = new ArrayList<>();
		try {
			Query q = em.createQuery("from TipoPago t where t.nombreTipoPago like ?1");
			q.setParameter(1, "%" + tcc.getNombreTipoPago() + "%");
			lista = (List<TipoPago>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(TipoPago tc) {
		// TODO Auto-generated method stub
		try {
			em.merge(tc);
		} catch (Exception e) {
			System.out.println("Error al editar ");
		}
	}

}
