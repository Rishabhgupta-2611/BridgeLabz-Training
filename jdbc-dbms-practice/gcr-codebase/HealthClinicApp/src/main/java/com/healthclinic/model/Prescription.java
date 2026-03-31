package com.healthclinic.model;

public class Prescription {

    private int prescriptionId;
    private int visitId;
    private String medicineName;
    private String dosage;
    private String duration;

    public Prescription() {
    }

    public Prescription(int visitId, String medicineName, String dosage, String duration) {
        this.visitId = visitId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.duration = duration;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Prescription{" + "prescriptionId=" + prescriptionId + ", visitId=" + visitId + ", medicineName='" + medicineName + '\'' + ", dosage='" + dosage + '\'' + ", duration='" + duration + '\'' +'}';
    }
}
