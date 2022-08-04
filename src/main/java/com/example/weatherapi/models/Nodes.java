package com.example.weatherapi.models;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name="Nodes")

public class Nodes{
	
	@Id
	@Column(columnDefinition="varchar(64)")
	private String node_id;
	
	@Column(name="node_ipaddress")
	private String node_ipaddress;

	@Column(name="node_macaddress")
	private String node_macaddress;

	@Column(columnDefinition="varchar(64)")
	private String node_api_key;

	@Column(name="node_gps_latitude")
	private String node_gps_latitude;

	@Column(name="node_gps_longitude")
	private String node_gps_longitude;

	@Column(name="node_gps_altitude")
	private String node_gps_altitude;

	@Column(columnDefinition="boolean default false")
	private Boolean node_active;

	@Column(columnDefinition="boolean default false")	
	private Boolean node_ota_flag;

	@Column(columnDefinition="boolean default false")
	private Boolean node_permission_flag;


	// Getter Methods
	
	public String getNodeId() {
		return node_id;
	}

	public String getNodeIpaddress() {
		return node_ipaddress;
	}

	public String getNodeMacaddress() {
		return node_macaddress;
	}

	public String getNodeApiKey() {
		return node_api_key;
	}

	public String getNodeGpsLatitude() {
		return node_gps_latitude;
	}

	public String getNodeGpsLongitude() {
		return node_gps_longitude;
	}

	public String getNodeGpsAltitude() {
		return node_gps_altitude;
	}

	public Boolean getNodeActive() {
		return node_active;
	}

	public Boolean getNodeOtaFlag() {
		return node_ota_flag;
	}

	public Boolean getNodePermissionFlag() {
		return node_permission_flag;
	}

	// Setter Methods
	
	public void setNodeId(String node_id) {
		this.node_id = node_id;
	}

	public void setNodeIpaddress(String node_ipaddress) {
		this.node_ipaddress = node_ipaddress;
	}

	public void setNodeMacaddress(String node_macaddress) {
		this.node_macaddress = node_macaddress;
	}

	public void setNodeApiKey(String node_api_key) {
		this.node_api_key = node_api_key;
	}

	public void setNodeGpsLatitude(String node_gps_latitude) {
		this.node_gps_latitude = node_gps_latitude;
	}

	public void setNodeGpsLongitude(String node_gps_longitude) {
		this.node_gps_longitude = node_gps_longitude;
	}

	public void setNodeGpsAltitude(String node_gps_altitude) {
		this.node_gps_altitude = node_gps_altitude;
	}

	public void setNodeActive(Boolean node_active) {
		this.node_active = node_active;
	}

	public void setNodeOtaFlag(Boolean node_ota_flag) {
		this.node_ota_flag = node_ota_flag;
	}

}
