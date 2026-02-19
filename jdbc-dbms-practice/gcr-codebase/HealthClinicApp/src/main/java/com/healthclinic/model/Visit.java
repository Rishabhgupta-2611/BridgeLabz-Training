package com.healthclinic.model;

public class Visit {
    private int visitId;
    private int appointmentId;
    private String diagnosis;
    private double billAmount;
    private String notes;
    
    public Visit() {};
    
    public Visit(int appointmentId, String diagnosis, double billAmount, String notes) {
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.billAmount = billAmount;
        this.notes = notes;
    }
    
	public int getVisitId() {
		return visitId;
	}
	
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public double getBillAmount() {
		return billAmount;
	}
	
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
