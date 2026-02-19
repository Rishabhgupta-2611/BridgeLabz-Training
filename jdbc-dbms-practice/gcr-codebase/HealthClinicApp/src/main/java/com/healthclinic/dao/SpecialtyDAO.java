package com.healthclinic.dao;

import com.healthclinic.model.Specialty;
import com.healthclinic.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDAO {

    public void addSpecialty(Specialty specialty) throws SQLException {
        String sql = "INSERT INTO specialties(specialty_name) VALUES(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, specialty.getSpecialtyName());
            ps.executeUpdate();
        }
    }

    public List<Specialty> getAllSpecialties() throws SQLException {
        List<Specialty> list = new ArrayList<>();
        String sql = "SELECT * FROM specialties";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Specialty s = new Specialty();
                s.setSpecialtyId(rs.getInt("specialty_id"));
                s.setSpecialtyName(rs.getString("specialty_name"));
                list.add(s);
            }
        }
        return list;
    }
}
