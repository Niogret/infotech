package webappRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import webappDomain.User;

@Component(value="UserRepository")
public class UserRepository {
	
	private EntityManagerFactory emf;
	private EntityManager entityManager;
	
	public UserRepository(){
		this.emf =Persistence.createEntityManagerFactory("manager1");
		this.entityManager = emf.createEntityManager();
	}
	
	public void save(User user){
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
	
	
	public void delete (long id){
		User user = entityManager.find(User.class, id);
		 
		 entityManager.getTransaction().begin();
		 entityManager.remove(user);
		 entityManager.getTransaction().commit();

	}
	
	public User find (long id){
		 return entityManager.find(User.class, id);
	}
	
	public void update(User user){
		entityManager.merge(user);
	}

}
