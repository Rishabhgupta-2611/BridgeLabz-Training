package com.healthclinic.dao;

import com.healthclinic.model.Doctor;
import com.healthclinic.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctors(name, specialty, phone, consultation_fee, is_active) VALUES(?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getPhone());
            ps.setDouble(4, doctor.getConsultationFee());
            ps.setBoolean(5, doctor.isActive());

            ps.executeUpdate();
        }
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE is_active = TRUE";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialty(rs.getString("specialty"));
                d.setPhone(rs.getString("phone"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                d.setActive(rs.getBoolean("is_active"));

                list.add(d);
            }
        }
        return list;
    }
    
    public List<Doctor> getDoctorsBySpecialty(String specialty) throws SQLException {

        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE specialty=? AND is_active=TRUE";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialty(rs.getString("specialty"));
                d.setPhone(rs.getString("phone"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                d.setActive(rs.getBoolean("is_active"));

                list.add(d);
            }
        }
        return list;
    }

    public void deactivateDoctor(int doctorId) throws SQLException {

        String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND status='SCHEDULED'";
        String updateSql = "UPDATE doctors SET is_active=FALSE WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement check = conn.prepareStatement(checkSql);
            check.setInt(1, doctorId);
            ResultSet rs = check.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Doctor has future appointments. Cannot deactivate.");
                return;
            }

            PreparedStatement update = conn.prepareStatement(updateSql);
            update.setInt(1, doctorId);
            update.executeUpdate();

            System.out.println("Doctor deactivated successfully.");
        }
    }

}
