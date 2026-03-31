package com.healthclinic.dao;

import com.healthclinic.model.Patient;
import com.healthclinic.utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients(name, dob, phone, email, address, blood_group) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patient.getName());
            ps.setDate(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());
            ps.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Patient p = new Patient(sql, null, sql, sql, sql, sql, 0);
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));
                patients.add(p);
            }
        }
        return patients;
    }
    
    public void updatePatient(Patient patient) throws SQLException {

        String sql = "UPDATE patients SET name=?, dob=?, phone=?, email=?, address=?, blood_group=? WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setDate(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());
            ps.setInt(7, patient.getPatientId());

            ps.executeUpdate();
        }
    }
    
    public List<Patient> searchPatientsByName(String name) throws SQLException {

        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));

                list.add(p);
            }
        }
        return list;
    }
    public void getVisitHistory(int patientId) throws SQLException {

        String sql = """
                SELECT v.visit_id, v.diagnosis, v.bill_amount,
                       a.appointment_date, d.name AS doctor_name
                FROM visits v
                JOIN appointments a ON v.appointment_id = a.appointment_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE a.patient_id = ?
                ORDER BY a.appointment_date DESC
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Visit ID: " + rs.getInt("visit_id") +
                        ", Doctor: " + rs.getString("doctor_name") +
                        ", Diagnosis: " + rs.getString("diagnosis") +
                        ", Bill: " + rs.getDouble("bill_amount")
                );
            }
        }
    }
}