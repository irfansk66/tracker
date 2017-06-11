package com.pup.entity;

import java.sql.Timestamp;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class Readings {
		
	
	@Id
	@Column(columnDefinition = "varchar(36)")
	private String rid;
	private String vin;
	
	private double latitude;
	private double longitude;
	
	
	private Timestamp timestamp;
	private float fuelVolume;
	private int speed;
	private int power;
	private boolean checkEngineLighton;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private int engineRpm;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Tires tires;
	
	public Readings()
	{
		this.rid=UUID.randomUUID().toString();
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isCheckEngineLighton() {
		return checkEngineLighton;
	}

	public void setCheckEngineLighton(boolean checkEngineLighton) {
		this.checkEngineLighton = checkEngineLighton;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public int getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		return "Readings [rid=" + rid + ", vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", timestamp=" + timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", power=" + power
				+ ", checkEngineLighton=" + checkEngineLighton + ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires=" + tires + "]";
	}

	

	
	
}
