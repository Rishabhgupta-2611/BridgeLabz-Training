package com.clinic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Patient;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int addPatient(Patient patient) {

        String sql = "INSERT INTO patients(first_name,last_name,date_of_birth,gender,phone_number,email,is_active) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setDate(3, patient.getDateOfBirth());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getPhoneNumber());
            ps.setString(6, patient.getEmail());
            ps.setBoolean(7, patient.isActive());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public Patient getPatientById(int patientId) {

        String sql = "SELECT * FROM patients WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setDateOfBirth(rs.getDate("date_of_birth"));
                patient.setGender(rs.getString("gender"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setEmail(rs.getString("email"));
                patient.setActive(rs.getBoolean("is_active"));

                return patient;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM patients";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setDateOfBirth(rs.getDate("date_of_birth"));
                patient.setGender(rs.getString("gender"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setEmail(rs.getString("email"));
                patient.setActive(rs.getBoolean("is_active"));

                patients.add(patient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patients SET first_name=?,last_name=?,date_of_birth=?,gender=?,phone_number=?,email=?,is_active=? WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setDate(3, patient.getDateOfBirth());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getPhoneNumber());
            ps.setString(6, patient.getEmail());
            ps.setBoolean(7, patient.isActive());
            ps.setInt(8, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM patients WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}