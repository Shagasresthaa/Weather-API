package com.example.weatherapi.models;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name="Users")

public class Users {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;  
	@Column
	private String userName;  
	@Column
	private String userEmail;
	@Column
	private String userPass;
	@Column(columnDefinition = "boolean default false")
	private Boolean userAdmin;
	@Column(columnDefinition = "boolean default false")
	private Boolean userNodeCreate;

	// Getter Methods
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public Boolean getUserAdmin() {
		return userAdmin;
	}

	public Boolean getUserNodeCreate() {
		return userNodeCreate;
	}

	// Setter Methods
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}	

	public void setUserAdmin(Boolean userAdmin) {
		this.userAdmin = userAdmin;
	}

	public void setUserNodeCreate(Boolean userNodeCreate) {
		this.userNodeCreate = userNodeCreate;
	}

}
