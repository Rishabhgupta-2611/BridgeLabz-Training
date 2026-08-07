package com.clinic.service;

import java.math.BigDecimal;
import java.sql.Connection;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;

public class AppointmentService {

    public boolean completeAppointment(int appointmentId,
                                       String diagnosis,
                                       String prescription,
                                       String notes,
                                       BigDecimal amount) {

        Connection con = null;

        try {

            con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);

            // Update Appointment Status
            String updateAppointment =
                    "UPDATE appointments SET status='Completed' WHERE appointment_id=?";

            var ps1 = con.prepareStatement(updateAppointment);
            ps1.setInt(1, appointmentId);
            ps1.executeUpdate();

            // Insert Billing
            String insertBill =
                    "INSERT INTO billing(appointment_id,amount,payment_status) VALUES(?,?,?)";

            var ps2 = con.prepareStatement(insertBill);

            ps2.setInt(1, appointmentId);
            ps2.setBigDecimal(2, amount);
            ps2.setString(3, "Pending");

            ps2.executeUpdate();

            // Insert Visit History
            String visitSql =
                    "INSERT INTO visit_history(appointment_id,diagnosis,prescription,visit_notes) VALUES(?,?,?,?)";

            var ps3 = con.prepareStatement(visitSql);

            ps3.setInt(1, appointmentId);
            ps3.setString(2, diagnosis);
            ps3.setString(3, prescription);
            ps3.setString(4, notes);

            ps3.executeUpdate();

            con.commit();

            return true;

        } catch (Exception e) {

            try {

                if (con != null)
                    con.rollback();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

            return false;

        } finally {

            try {

                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}