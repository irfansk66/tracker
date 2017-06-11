package com.pup.entity;

public class HighAlert {
	
	private String vin;
	private String priority;
	private int count;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "HighAlert [vin=" + vin + ", priority=" + priority + ", count=" + count + "]";
	}
	
	

}
