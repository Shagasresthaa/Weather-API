package com.example.weatherapi.models;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;


@Entity
@Table(name="weatherdata")

public class WeatherData{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="nodeid")
	private long nodeId;

	@Column(name="temperature")
	private double temperature;

	@Column(name="humidity")
	private double humidity;

	@Column(name="pressure")
	private double pressure;

	@Column(name="uvindex")
	private double uvindex;

	@Column(name="pm25Levels")
	private double pm25Levels;

	@Column(name="coLevels")
	private double coLevels;

	@Column(name="ammoniaLevels")
	private double ammoniaLevels;

	@Column(name="nodeGPSLatitude")
	private double nodeGPSLatitude;

	@Column(name="nodeGPSLongitude")
	private double nodeGPSLongitude;

	@Column(name="nodeIPAddress")
	private String nodeIPAddress;

	@Column(name="nodeTimeStamp")
	private String nodeTimeStamp;

	// Getter Methods
	public long getId() {
		return id;
	}

	public long getNodeId() {
		return nodeId;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public double getUvindex() {
		return uvindex;
	}

	public double getPm25Levels() {
		return pm25Levels;
	}

	public double getCoLevels() {
		return coLevels;
	}

	public double getAmmoniaLevels() {
		return ammoniaLevels;
	}

	public double getNodeGPSLatitude() {
		return nodeGPSLatitude;
	}

	public double getNodeGPSLongitude() {
		return nodeGPSLongitude;
	}

	public String getNodeIPAddress() {
		return nodeIPAddress;
	}

	public String getNodeTimeStamp() {
		return nodeTimeStamp;
	}

	// Setter Methods
	public void setId(int id) {
		this.id = id;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public void setUvindex(double uvindex) {
		this.uvindex = uvindex;
	}

	public void setPm25Levels(double pm25Levels) {
		this.pm25Levels = pm25Levels;
	}

	public void setCoLevels(double coLevels) {
		this.coLevels = coLevels;
	}

	public void setAmmoniaLevels(double ammoniaLevels) {
		this.ammoniaLevels = ammoniaLevels;
	}

	public void setNodeGPSLatitude(double nodeGPSLatitude) {
		this.nodeGPSLatitude = nodeGPSLatitude;
	}

	public void setNodeGPSLongitude(double nodeGPSLongitude) {
		this.nodeGPSLongitude = nodeGPSLongitude;
	}

	public void setNodeIPAddress(String nodeIPAddress) {
		this.nodeIPAddress = nodeIPAddress;
	}

	public void setNodeTimeStamp(String nodeTimeStamp) {
		this.nodeTimeStamp = nodeTimeStamp;
	}

}
