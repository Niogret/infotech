package webappDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicule{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String immat;

	private String marque;

	private String model;

	@ManyToOne
	private User owner;

	public Vehicule(String immat, String marque, String model) {
		super();
		this.immat = immat;
		this.marque = marque;
		this.model = model;
	}
	
	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


}
