package com.healthclinic.dao;

import com.healthclinic.utils.DBConnection;

import java.sql.*;

public class BillDAO {

    public void generateBill(int visitId, double totalAmount) throws SQLException {

        String sql = "INSERT INTO bills(visit_id, total_amount) VALUES(?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, visitId);
            ps.setDouble(2, totalAmount);
            ps.executeUpdate();
        }
    }

    public void recordPayment(int billId, String mode) throws SQLException {

        String sql = "UPDATE bills SET payment_status='PAID', payment_date=NOW(), payment_mode=? WHERE bill_id=?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, mode);
                ps.setInt(2, billId);

                ps.executeUpdate();
                conn.commit();

            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }
    
    public void getOutstandingBills() throws SQLException {

        String sql = """
                SELECT b.bill_id, p.name, b.total_amount
                FROM bills b
                JOIN visits v ON b.visit_id = v.visit_id
                JOIN appointments a ON v.appointment_id = a.appointment_id
                JOIN patients p ON a.patient_id = p.patient_id
                WHERE b.payment_status='UNPAID'
                """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "Bill ID: " + rs.getInt("bill_id") +
                        ", Patient: " + rs.getString("name") +
                        ", Amount: " + rs.getDouble("total_amount")
                );
            }
        }
    }

    public double getRevenueReport(Date start, Date end) throws SQLException {

        String sql = "SELECT SUM(total_amount) FROM bills WHERE payment_status='PAID' AND payment_date BETWEEN ? AND ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, start);
            ps.setDate(2, end);

            ResultSet rs = ps.executeQuery();
            rs.next();

            return rs.getDouble(1);
        }
    }

}
