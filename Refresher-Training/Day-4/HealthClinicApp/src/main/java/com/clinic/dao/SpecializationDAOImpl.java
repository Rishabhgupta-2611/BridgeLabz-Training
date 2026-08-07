package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Specialization;

public class SpecializationDAOImpl implements SpecializationDAO {

    @Override
    public int addSpecialization(Specialization specialization) {

        String sql = "INSERT INTO specializations(name,description) VALUES(?,?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, specialization.getName());
            ps.setString(2, specialization.getDescription());

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
    public Specialization getSpecializationById(int specializationId) {

        String sql = "SELECT * FROM specializations WHERE specialization_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, specializationId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                Specialization s = new Specialization();

                s.setSpecializationId(rs.getInt("specialization_id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));

                return s;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Specialization> getAllSpecializations() {

        List<Specialization> list = new ArrayList<>();

        String sql = "SELECT * FROM specializations";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                Specialization s = new Specialization();

                s.setSpecializationId(rs.getInt("specialization_id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));

                list.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateSpecialization(Specialization specialization) {

        String sql = "UPDATE specializations SET name=?,description=? WHERE specialization_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, specialization.getName());
            ps.setString(2, specialization.getDescription());
            ps.setInt(3, specialization.getSpecializationId());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSpecialization(int specializationId) {

        String sql = "DELETE FROM specializations WHERE specialization_id=?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, specializationId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}