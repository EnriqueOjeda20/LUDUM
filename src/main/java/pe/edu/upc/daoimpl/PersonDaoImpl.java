package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersonDao;
import pe.edu.upc.entities.Person;

public class PersonDaoImpl implements IPersonDao {
	
	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Person p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar persona");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		List<Person> lista = new ArrayList<Person>();
		try {
			Query q = em.createQuery("select p from Person p");
			lista = (List<Person>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar persona");
		}
		return lista;
	}

}
