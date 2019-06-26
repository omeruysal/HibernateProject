 package com.proje.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Advertisement.findById", query="SELECT a FROM Advertisement a WHERE a.advertisementId = :advertisementId"),
	@NamedQuery(name="Advertisement.findWithEducationsById",
	query="SELECT a FROM Advertisement a LEFT JOIN FETCH a.educations WHERE a.advertisementId = :advertisementId"),
	/*@NamedQuery(name="Advertisement.findByUserName",
	query="SELECT a FROM User u LEFT JOIN  u.userDetails ud LEFT JOIN ud.advertisement a WHERE u.userName = :userName "),*/
	//Yukarýda isme gore ilan arýyoruz	
	@NamedQuery(name="Advertisement.findAdvertisements",
	query="SELECT a FROM Advertisement a ")

	
	
})
public class Advertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int advertisementId;
	
	private String title;
	@Lob							//Uzun veri girilmesi için Lob ekledik
	private String definition;
	
	@ManyToMany //Bir ilana birden fazla  meslek basvurabilir, bir meslek birden fazla ilana basvurabilir 
	private List<Education> educations = new ArrayList<Education>(); //Ýlanda birden fazla meslek grubunun basruvabilmesi için
	
	@ManyToOne
	private UserDetails userDetails;
	
	
	

	public Advertisement(String title, String definition) {
		super();
		this.title = title;
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", title=" + title + ", definition=" + definition
				+ ", educations=" + educations + ", userDetails=" + userDetails + "]";
	}

	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
