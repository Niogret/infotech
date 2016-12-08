package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import webappDomain.Car;
import webappRepository.CarRepository;

@Component(value = "CarService")
public class CarService {

	@Autowired
	@Qualifier("CarService")
	private CarRepository repository; 
	
	public void save(Car car){
		repository.save(car);
	}
		
	public void delete (long id){
		 repository.delete(id);

	}
	
	public Car find (long id){
		 return repository.find(id);
	}
	
	public void update(Car car){
		repository.update(car);
	}
	
}
