package com.example.weatherapi.models;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name="Nodes")

public class Nodes{
	
	@Id
	@Column
	private long nodeId;
	
	@Column(name="nodeIpaddress")
	private String nodeIpaddress;

	@Column(name="nodeMacAddress")
	private String nodeMacAddress;

	@Column(columnDefinition="varchar(64)")
	private String nodeApiKey;

	@Column(name="nodeGpsLatitude")
	private String nodeGpsLatitude;

	@Column(name="nodeGpsLongitude")
	private String nodeGpsLongitude;

	@Column(name="nodeGpsAltitude")
	private String nodeGpsAltitude;

	@Column(columnDefinition="boolean default false")
	private Boolean nodeActive;

	@Column(columnDefinition="boolean default false")	
	private Boolean nodeOtaFlag;

	@Column(columnDefinition="boolean default false")
	private Boolean nodePermissionFlag;


	// Getter Methods
	
	public long getNodeId() {
		return nodeId;
	}

	public String getNodeIpaddress() {
		return nodeIpaddress;
	}

	public String getNodeMacAddress() {
		return nodeMacAddress;
	}

	public String getNodeApiKey() {
		return nodeApiKey;
	}

	public String getNodeGpsLatitude() {
		return nodeGpsLatitude;
	}

	public String getNodeGpsLongitude() {
		return nodeGpsLongitude;
	}

	public String getNodeGpsAltitude() {
		return nodeGpsAltitude;
	}

	public Boolean getNodeActive() {
		return nodeActive;
	}

	public Boolean getNodeOtaFlag() {
		return nodeOtaFlag;
	}

	public Boolean getNodePermissionFlag() {
		return nodePermissionFlag;
	}

	// Setter Methods
	
	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public void setNodeIpaddress(String nodeIpaddress) {
		this.nodeIpaddress = nodeIpaddress;
	}

	public void setNodeMacAddress(String nodeMacAddress) {
		this.nodeMacAddress = nodeMacAddress;
	}

	public void setNodeApiKey(String nodeApiKey) {
		this.nodeApiKey = nodeApiKey;
	}

	public void setNodeGpsLatitude(String nodeGpsLatitude) {
		this.nodeGpsLatitude = nodeGpsLatitude;
	}

	public void setNodeGpsLongitude(String nodeGpsLongitude) {
		this.nodeGpsLongitude = nodeGpsLongitude;
	}

	public void setNodeGpsAltitude(String nodeGpsAltitude) {
		this.nodeGpsAltitude = nodeGpsAltitude;
	}

	public void setNodeActive(Boolean nodeActive) {
		this.nodeActive = nodeActive;
	}

	public void setNodeOtaFlag(Boolean nodeOtaFlag) {
		this.nodeOtaFlag = nodeOtaFlag;
	}

	public void setNodePermissionFlag(Boolean nodePermissionFlag) {
		this.nodePermissionFlag = nodePermissionFlag;
	}

}
