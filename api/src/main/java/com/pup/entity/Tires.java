package com.pup.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tires {
	
	
	@Id
	@Column(columnDefinition = "varchar(36)")
	String id;
	
	int frontLeft;
	int frontRight;
	int rearLeft;
	int rearRight;
	
	
	public Tires()
	{
		this.id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getFrontLeft() {
		return frontLeft;
	}


	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}


	public int getFrontRight() {
		return frontRight;
	}


	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}


	public int getRearLeft() {
		return rearLeft;
	}


	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}


	public int getRearRight() {
		return rearRight;
	}


	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}


	@Override
	public String toString() {
		return "Tires [id=" + id + ", frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", rearLeft=" + rearLeft
				+ ", rearRight=" + rearRight + "]";
	}
	
	
	

}
