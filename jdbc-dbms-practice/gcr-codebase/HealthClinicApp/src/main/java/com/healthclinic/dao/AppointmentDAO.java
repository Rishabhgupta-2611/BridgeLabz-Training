package com.healthclinic.dao;

import com.healthclinic.model.Appointment;
import com.healthclinic.utils.DBConnection;

import java.sql.*;

public class AppointmentDAO {

    public void bookAppointment(Appointment appointment) throws SQLException {

        String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, status) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, appointment.getPatientId());
                ps.setInt(2, appointment.getDoctorId());
                ps.setTimestamp(3, appointment.getAppointmentDate());
                ps.setString(4, "SCHEDULED");

                ps.executeUpdate();

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }
    
    public boolean checkAvailability(int doctorId, Timestamp dateTime) throws SQLException {

        String sql = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date=? AND status='SCHEDULED'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setTimestamp(2, dateTime);

            ResultSet rs = ps.executeQuery();
            rs.next();

            return rs.getInt(1) == 0;
        }
    }

    public void cancelAppointment(int appointmentId) throws SQLException {

        String sql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);
            ps.executeUpdate();
        }
    }

    public void getDailySchedule(Date date) throws SQLException {

        String sql = """
                SELECT a.appointment_id, p.name AS patient_name,
                       d.name AS doctor_name, a.appointment_date
                FROM appointments a
                JOIN patients p ON a.patient_id = p.patient_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE DATE(a.appointment_date) = ?
                ORDER BY a.appointment_date
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getTimestamp("appointment_date") +
                        " - Patient: " + rs.getString("patient_name") +
                        ", Doctor: " + rs.getString("doctor_name")
                );
            }
        }
    }

}
