package com.healthclinic.model;

public class Doctor {
	
	private int doctorId;
    private String name;
    private String specialty;
    private String phone;
    private double consultationFee;
    private boolean isActive;

    public Doctor() {};
    
	public Doctor(int doctorId, String name, String specialty, String phone, double consultationFee, boolean isActive) {
		this.doctorId = doctorId;
		this.name = name;
		this.specialty = specialty;
		this.phone = phone;
		this.consultationFee = consultationFee;
		this.isActive = isActive;
	}

	public int getDoctorId() {
		return doctorId;
	}
    
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
