package com.proje.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Education.findEducations",query="SELECT e FROM Education e"),
	@NamedQuery(name="Education.findById", query="SELECT e FROM Education e WHERE e.educationId=:educationId"),
	/*@NamedQuery(name="Education.findWithAdvertisementById",
	query="SELECT e FROM Education e LEFT JOIN FETCH e.advertisement WHERE e.educationId=:educationId")*/
	
	
})
public class Education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int educationId;
	private String educationName;
	
	@ManyToMany(mappedBy="educations")
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	
	
	public Education(String educationName) {
		 
		this.educationName = educationName;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	
	
	
}
