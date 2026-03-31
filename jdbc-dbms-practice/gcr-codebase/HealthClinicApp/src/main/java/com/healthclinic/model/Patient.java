package com.healthclinic.model;

import java.sql.Date;

public class Patient {
	
	private String name;
    private Date dob;
    private String phone;
    private String email;
    private String address;
    private String bloodGroup;
    private int patientId;
    
    public Patient() {};
    
	public Patient(String name, Date dob, String phone, String email, String address, String bloodGroup,int patientId) {
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public int getPatientId() {
		return patientId;
	}
    
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
}
