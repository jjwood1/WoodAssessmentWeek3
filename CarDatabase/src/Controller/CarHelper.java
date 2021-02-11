package Controller;
import model.Car;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
public class CarHelper {
	static EntityManagerFactory fact = Persistence.createEntityManagerFactory("CarDatabase");
	public void insertItem(Car c)
	{
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Manager.persist(c);
		Manager.getTransaction().commit();
		Manager.close();
	}
	public List<Car> showAllItems()
	{	
		EntityManager Manager = fact.createEntityManager();
		List<Car>Everything = Manager.createQuery("SELECT i FROM Car i").getResultList();
		return Everything;
	}

	public void deleteCar(Car c)
	{
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		
		TypedQuery<Car> typedQuery = Manager.createQuery("select li from Car li where li.id = :selectedId", Car.class);
		typedQuery.setParameter("selectedId", c.getId());

		typedQuery.setMaxResults(1);
		Car result = typedQuery.getSingleResult();
		Manager.remove(result);
		Manager.getTransaction().commit();
		Manager.close();
	}
	
	public void updateCar(Car c) {
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Manager.merge(c);
		Manager.getTransaction().commit();
		Manager.close();
	}
	public Car searchForCarById(int c) {
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Car found = Manager.find(Car.class, c);
		Manager.close();
		return found;
	}
	public void cleanUp()
	{
		fact.close();
	}

}