package webappRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import webappDomain.Van;



	@Component(value="VanRepository")
	public class VanRepository {
		
		private EntityManagerFactory emf;
		private EntityManager entityManager;
		
		public VanRepository(){
			this.emf =Persistence.createEntityManagerFactory("manager1");
			this.entityManager = emf.createEntityManager();
		}
		
		public void save(Van van){
			entityManager.getTransaction().begin();
			entityManager.persist(van);
			entityManager.getTransaction().commit();
		}
		
		
		public void delete (long id){
			Van van = entityManager.find(Van.class, id);
			 
			 entityManager.getTransaction().begin();
			 entityManager.remove(van);
			 entityManager.getTransaction().commit();

		}
		
		public Van find (long id){
			 return entityManager.find(Van.class, id);
		}
		
		public void update(Van van){
			entityManager.merge(van);
		}

}
