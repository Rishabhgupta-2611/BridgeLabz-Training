package com.clinic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.VisitHistory;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int addVisitHistory(VisitHistory visitHistory){

        String sql="INSERT INTO visit_history(appointment_id,diagnosis,prescription,visit_notes) VALUES(?,?,?,?)";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){

            ps.setInt(1,visitHistory.getAppointmentId());
            ps.setString(2,visitHistory.getDiagnosis());
            ps.setString(3,visitHistory.getPrescription());
            ps.setString(4,visitHistory.getVisitNotes());

            ps.executeUpdate();

            ResultSet rs=ps.getGeneratedKeys();

            if(rs.next())
                return rs.getInt(1);

        }catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public VisitHistory getVisitHistoryById(int visitId){

        String sql="SELECT * FROM visit_history WHERE visit_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,visitId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                VisitHistory vh=new VisitHistory();

                vh.setVisitId(rs.getInt("visit_id"));
                vh.setAppointmentId(rs.getInt("appointment_id"));
                vh.setDiagnosis(rs.getString("diagnosis"));
                vh.setPrescription(rs.getString("prescription"));
                vh.setVisitNotes(rs.getString("visit_notes"));

                return vh;

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public VisitHistory getVisitHistoryByAppointmentId(int appointmentId){

        String sql="SELECT * FROM visit_history WHERE appointment_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,appointmentId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                VisitHistory vh=new VisitHistory();

                vh.setVisitId(rs.getInt("visit_id"));
                vh.setAppointmentId(rs.getInt("appointment_id"));
                vh.setDiagnosis(rs.getString("diagnosis"));
                vh.setPrescription(rs.getString("prescription"));
                vh.setVisitNotes(rs.getString("visit_notes"));

                return vh;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VisitHistory> getAllVisitHistory(){

        List<VisitHistory> list=new ArrayList<>();

        String sql="SELECT * FROM visit_history";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            while(rs.next()){

                VisitHistory vh=new VisitHistory();

                vh.setVisitId(rs.getInt("visit_id"));
                vh.setAppointmentId(rs.getInt("appointment_id"));
                vh.setDiagnosis(rs.getString("diagnosis"));
                vh.setPrescription(rs.getString("prescription"));
                vh.setVisitNotes(rs.getString("visit_notes"));

                list.add(vh);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateVisitHistory(VisitHistory visitHistory){

        String sql="UPDATE visit_history SET diagnosis=?,prescription=?,visit_notes=? WHERE visit_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,visitHistory.getDiagnosis());
            ps.setString(2,visitHistory.getPrescription());
            ps.setString(3,visitHistory.getVisitNotes());
            ps.setInt(4,visitHistory.getVisitId());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteVisitHistory(int visitId){

        String sql="DELETE FROM visit_history WHERE visit_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,visitId);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

}