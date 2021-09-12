package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.Person;

public interface IPersonDao {

	public void insert(Person p);

	public List<Person> list();
}
