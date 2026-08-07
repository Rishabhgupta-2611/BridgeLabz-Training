package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Appointment;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public int bookAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,status) VALUES(?,?,?,?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());

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
    public Appointment getAppointmentById(int appointmentId) {

        String sql = "SELECT * FROM appointments WHERE appointment_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));

                return appointment;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();

        String sql = "SELECT * FROM appointments";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));

                list.add(appointment);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {

        String sql = "UPDATE appointments SET patient_id=?,doctor_id=?,appointment_date=?,status=? WHERE appointment_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getAppointmentId());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {

        String sql = "UPDATE appointments SET status='Cancelled' WHERE appointment_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}