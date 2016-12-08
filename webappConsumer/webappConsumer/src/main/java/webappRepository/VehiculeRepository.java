package webappRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import webappDomain.Vehicule;

	@Component(value="VehiculeRepository")
	public class VehiculeRepository {
		
		private EntityManagerFactory emf;
		private EntityManager entityManager;
		
		public VehiculeRepository(){
			this.emf =Persistence.createEntityManagerFactory("manager1");
			this.entityManager = emf.createEntityManager();
		}
		
		public void save(Vehicule vehicule){
			entityManager.getTransaction().begin();
			entityManager.persist(vehicule);
			entityManager.getTransaction().commit();
		}
		
		
		public void delete (long id){
			Vehicule vehicule = entityManager.find(Vehicule.class, id);
			 
			 entityManager.getTransaction().begin();
			 entityManager.remove(vehicule);
			 entityManager.getTransaction().commit();

		}
		
		public Vehicule find (long id){
			 return entityManager.find(Vehicule.class, id);
		}
		
		public void update(Vehicule vehicule){
			entityManager.merge(vehicule);
		}
		
}
