package webappDomain;

import javax.persistence.Entity;


@Entity
public class Car extends Vehicule{
	
	private int numberOfseats;


public Car(String immat, String marque, String model, int numberOfseats) {
		super(immat, marque, model);
		this.numberOfseats = numberOfseats;
	}


public int getNumberOfseats() {
	return numberOfseats;
}


public void setNumberOfseats(int numberOfseats) {
	this.numberOfseats = numberOfseats;
}



}
