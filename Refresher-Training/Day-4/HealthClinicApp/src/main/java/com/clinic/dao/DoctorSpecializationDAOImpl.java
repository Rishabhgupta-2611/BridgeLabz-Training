package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;

public class DoctorSpecializationDAOImpl implements DoctorSpecializationDAO {

    @Override
    public boolean assignSpecialization(int doctorId, int specializationId) {

        String sql = "INSERT INTO doctor_specializations VALUES(?,?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setInt(2, specializationId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeSpecialization(int doctorId, int specializationId) {

        String sql = "DELETE FROM doctor_specializations WHERE doctor_id=? AND specialization_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setInt(2, specializationId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Integer> getSpecializationsByDoctor(int doctorId) {

        List<Integer> list = new ArrayList<>();

        String sql = "SELECT specialization_id FROM doctor_specializations WHERE doctor_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                list.add(rs.getInt("specialization_id"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}