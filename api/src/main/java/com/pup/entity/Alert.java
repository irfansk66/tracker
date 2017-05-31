package com.pup.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alert {
	
	
	@Id
	@Column(columnDefinition = "varchar(36)")
	private String Aid;

	private String vin;
	private Timestamp timestamp;
	private String message;
	private String priority;
	
	
	public Alert(){
		this.Aid=UUID.randomUUID().toString();
	}


	public String getAid() {
		return Aid;
	}


	public void setAid(String aid) {
		Aid = aid;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	@Override
	public String toString() {
		return "Alert [Aid=" + Aid + ", vin=" + vin + ", timestamp=" + timestamp + ", message=" + message
				+ ", priority=" + priority + "]";
	}
	
	
	
	
	
}
