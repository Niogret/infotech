package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import webappDomain.User;
import webappRepository.UserRepository;

	
	@Component(value = "UserService")
	public class UserService {

		@Autowired
		@Qualifier("UserService")
		private UserRepository repository; 
		
		public void save(User user){
			repository.save(user);
		}
			
		public void delete (long id){
			 repository.delete(id);

		}
		
		public User find (long id){
			 return repository.find(id);
		}
		
		public void update(User user){
			repository.update(user);
		}
}
