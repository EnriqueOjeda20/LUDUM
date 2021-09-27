package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IInsigniaDao;
import pe.edu.upc.entities.Insignia;

public class InsigniaDaoImpl implements IInsigniaDao {

	@PersistenceContext(unitName = "LUDUM")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Insignia ic) {
		try {
			em.persist(ic);
		} catch (Exception e) {
			System.out.println("Error al insertar insignia");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Insignia> list() {
		List<Insignia> lista = new ArrayList<Insignia>();
		try {
			Query q = em.createQuery("select i from Insignia i");
			lista = (List<Insignia>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int codigoInsignia) {
		// TODO Auto-generated method stub
		Insignia med = new Insignia();
		try {
			med = em.getReference(Insignia.class, codigoInsignia);
			em.remove(med);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Insignia> finBynombreInsignia(Insignia Icc) {
		// TODO Auto-generated method stub
		List<Insignia> lista = new ArrayList<Insignia>();
		try {
			Query q = em.createQuery("from Insignia i where i.nombreInsignia like ? 1");
			q.setParameter(1, "%" + Icc.getNombreInsignia() + "%");
			lista = (List<Insignia>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(Insignia Ic) {
		// TODO Auto-generated method stub
		try {
			em.merge(Ic);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al editar");
		}
	}

}
