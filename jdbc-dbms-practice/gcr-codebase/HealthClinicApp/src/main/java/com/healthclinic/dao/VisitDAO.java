package com.healthclinic.dao;
import com.healthclinic.model.Visit;
import com.healthclinic.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDAO {

    public void recordVisit(Visit visit) throws SQLException {

        String insertVisitSQL = 
                "INSERT INTO visits (appointment_id, diagnosis, bill_amount) VALUES (?, ?, ?)";

        String updateAppointmentSQL = 
                "UPDATE appointments SET status = 'COMPLETED' WHERE appointment_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false); // START TRANSACTION

            try (
                PreparedStatement insertStmt = conn.prepareStatement(insertVisitSQL);
                PreparedStatement updateStmt = conn.prepareStatement(updateAppointmentSQL)
            ) {

                // 1️⃣ Insert visit record
                insertStmt.setInt(1, visit.getAppointmentId());
                insertStmt.setString(2, visit.getDiagnosis());
                insertStmt.setDouble(3, visit.getBillAmount());

                insertStmt.executeUpdate();

                // 2️⃣ Update appointment status
                updateStmt.setInt(1, visit.getAppointmentId());
                updateStmt.executeUpdate();

                conn.commit(); // SUCCESS

                System.out.println("Visit recorded successfully & appointment completed!");

            } catch (Exception e) {

                conn.rollback(); // ROLLBACK if error
                System.out.println("Transaction Failed. Rolled Back.");
                throw e;
            }
        }
    }
}
