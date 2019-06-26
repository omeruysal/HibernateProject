package com.proje.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries ({
	@NamedQuery(name="User.findById",query="SELECT u FROM User u WHERE u.userId = :userId "),
	@NamedQuery(name="User.findByUserName",query="SELECT u FROM User u WHERE u.userName = :userName"),
	@NamedQuery(name="User.findUsers", query="SELECT u FROM User u"),
	@NamedQuery(name="User.count", query="SELECT COUNT(u) FROM User u"),
/*	@NamedQuery(name="User.findWithUserDetailsById",query="SELECT u FROM User u LEFT JOIN FETCH u.userdetail WHERE u.userId = :userId ")*/
//Normal de yazdýgýmýz ilk sorgularla  userdetail bilgilerini  getirmiyorduk fakat yukarýda ki sorgu ile ilk queryden farklý olarak 
	//userdetails da getiriyoruz
	

})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String password;
	
	@OneToOne(mappedBy="user",fetch=FetchType.LAZY /*, cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE}*/)
	private UserDetails userDetail;

	
	
	
	public User(String userName, String password) {
	
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userDetail="
				+ userDetail + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}
	
	
	
}
