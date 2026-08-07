package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Doctor;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors(first_name,last_name,phone_number,email,is_active) VALUES(?,?,?,?,?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getPhoneNumber());
            ps.setString(4, doctor.getEmail());
            ps.setBoolean(5, doctor.isActive());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setActive(rs.getBoolean("is_active"));

                return doctor;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctors";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setActive(rs.getBoolean("is_active"));

                doctors.add(doctor);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return doctors;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET first_name=?,last_name=?,phone_number=?,email=?,is_active=? WHERE doctor_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getPhoneNumber());
            ps.setString(4, doctor.getEmail());
            ps.setBoolean(5, doctor.isActive());
            ps.setInt(6, doctor.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctors WHERE doctor_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}