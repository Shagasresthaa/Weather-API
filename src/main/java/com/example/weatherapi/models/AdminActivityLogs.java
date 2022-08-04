package com.example.weatherapi.models;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name="AdminActivityLogs")

public class AdminActivityLogs {

	@Id
	@Column(columnDefinition="varchar(64)")
	private int admin_id;

	@Column(name="action_id")
	private String action_id;

	@Column(name="action_description")	
	private String action_description;

	@Column(name="action_time")
	private String action_time;

	@Column(name="admin_ipaddress")
	private String admin_ipaddress;

	@Column(name="admin_location")
	private String admin_location;

	@Column(name="admin_browser")
	private String admin_browser;

	@Column(name="admin_login_time")
	private String admin_login_time;

	// Getter Methods
	
	public int getAdminId() {
		return admin_id;
	}

	public String getActionId() {
		return action_id;
	}

	public String getActionDescription() {
		return action_description;
	}

	public String getActionTime() {
		return action_time;
	}

	public String getAdminIpaddress() {
		return admin_ipaddress;
	}

	public String getAdminLocation() {
		return admin_location;
	}

	public String getAdminBrowser() {
		return admin_browser;
	}

	public String getAdminLoginTime() {
		return admin_login_time;
	}

	// Setter Methods
	
	public void setAdminId(int admin_id) {
		this.admin_id = admin_id;
	}

	public void setActionId(String action_id) {
		this.action_id = action_id;
	}

	public void setActionDescription(String action_description) {
		this.action_description = action_description;
	}

	public void setActionTime(String action_time) {
		this.action_time = action_time;
	}

	public void setAdminIpaddress(String admin_ipaddress) {
		this.admin_ipaddress = admin_ipaddress;
	}

	public void setAdminLocation(String admin_location) {
		this.admin_location = admin_location;
	}

	public void setAdminBrowser(String admin_browser) {
		this.admin_browser = admin_browser;
	}

	public void setAdminLoginTime(String admin_login_time) {
		this.admin_login_time = admin_login_time;
	}

}
