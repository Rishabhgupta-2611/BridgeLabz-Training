package com.healthclinic.dao;

import com.healthclinic.model.Prescription;
import com.healthclinic.utils.DBConnection;

import java.sql.*;
import java.util.List;

public class PrescriptionDAO {

    public void addMultiplePrescriptions(List<Prescription> list) throws SQLException {

        String sql = "INSERT INTO prescriptions(visit_id, medicine_name, dosage, duration) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Prescription p : list) {
                ps.setInt(1, p.getVisitId());
                ps.setString(2, p.getMedicineName());
                ps.setString(3, p.getDosage());
                ps.setString(4, p.getDuration());
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }
}
