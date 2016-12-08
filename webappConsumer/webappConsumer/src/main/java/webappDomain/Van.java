package webappDomain;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule {
	
	private Long maxWeight;

	public Van(String immat, String marque, String model, Long maxWeight) {
		super(immat, marque, model);
		this.maxWeight = maxWeight;
	}

	public Long getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Long maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	

}
