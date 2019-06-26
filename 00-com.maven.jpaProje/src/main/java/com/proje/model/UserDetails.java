package com.proje.model;
import com.proje.model.util.PhoneType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="UserDetails.findByUserName",query="SELECT ud FROM UserDetails ud WHERE ud.user.userName = :userName "),
	@NamedQuery(name="UserDetails.findById", query="SELECT ud FROM UserDetails ud WHERE ud.userDetailId = :userId"),
	@NamedQuery(name="UserDetails.findWithAdressesByUserName",
	query="SELECT ud FROM UserDetails ud LEFT JOIN FETCH ud.adresses WHERE ud.user.userName = :userName"),
	/*@NamedQuery(name="UserDetails.findWithAdrvertisementByUserName",
	query="SELECT ud FROM UserDetails ud LEFT JOIN FETCH ud.advertisement WHERE ud.user.userName = :userName")*/
})
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userDetailId;
	
	private String firstName;
	
	private String lastName;
	
	@ElementCollection
	@JoinTable(name="userdetails_phonenumbers")     	//Olusucak tabloyu adlandýrýyoruz 
	@MapKeyEnumerated(EnumType.STRING)					//Enumlarý string olarak gorecegiz
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType , String>();
	
	@ElementCollection(fetch = FetchType.LAZY) 			//Yazdýrcagýmýz zaman adresleri yazdýrmaz
	@JoinTable(name="userdetails_adresses")
	private List<Adress> adresses = new ArrayList<Adress>();
	
	
	@OneToMany/*(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})*/	//onetomany oldugu ýcýn fetchtype otomatýk olarak lazy
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();
	
	@OneToOne		//OneToOne sayesinde iliski cift yonlu artýk userdetails ile usera ulasabiliriz
	private User user;

	public UserDetails() {}
	
	public UserDetails(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDetails [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumbers=" + phoneNumbers + ", adresses=" + adresses + ", advertisements=" + advertisements
				+ "]";
	}

	public int getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	

}
