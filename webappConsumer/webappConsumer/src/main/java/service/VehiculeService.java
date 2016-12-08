package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import webappDomain.Vehicule;
import webappRepository.VehiculeRepository;

@Component(value = "VehiculeService")
public class VehiculeService {

	@Autowired
	@Qualifier("CarService")
	private VehiculeRepository repository; 
	
	public void save(Vehicule vehicule){
		repository.save(vehicule);
	}
		
	public void delete (long id){
		 repository.delete(id);

	}
	
	public Vehicule find (long id){
		 return repository.find(id);
	}
	
	public void update(Vehicule vehicule){
		repository.update(vehicule);
	}
	
}
