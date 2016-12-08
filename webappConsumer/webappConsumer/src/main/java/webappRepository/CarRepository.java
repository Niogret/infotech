package webappRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import webappDomain.Car;

@Component(value="CarRepository")
public class CarRepository {
	
	private EntityManagerFactory emf;
	private EntityManager entityManager;
	
	public CarRepository(){
		this.emf =Persistence.createEntityManagerFactory("manager1");
		this.entityManager = emf.createEntityManager();
	}
	
	public void save(Car car){
		entityManager.getTransaction().begin();
		entityManager.persist(car);
		entityManager.getTransaction().commit();
	}
	
	
	public void delete (long id){
		 Car car = entityManager.find(Car.class, id);
		 
		 entityManager.getTransaction().begin();
		 entityManager.remove(car);
		 entityManager.getTransaction().commit();

	}
	
	public Car find (long id){
		 return entityManager.find(Car.class, id);
	}
	
	public void update(Car car){
		entityManager.merge(car);
	}
	
}
