package com.clinic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Billing;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int generateBill(Billing billing) {

        String sql = "INSERT INTO billing(appointment_id,amount,payment_status) VALUES(?,?,?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setInt(1,billing.getAppointmentId());
            ps.setBigDecimal(2,billing.getAmount());
            ps.setString(3,billing.getPaymentStatus());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next())
                return rs.getInt(1);

        }catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public Billing getBillById(int billId) {

        String sql="SELECT * FROM billing WHERE bill_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,billId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Billing bill=new Billing();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setAmount(rs.getBigDecimal("amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
                bill.setBillingDate(rs.getTimestamp("billing_date"));

                return bill;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Billing getBillByAppointmentId(int appointmentId){

        String sql="SELECT * FROM billing WHERE appointment_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,appointmentId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Billing bill=new Billing();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setAmount(rs.getBigDecimal("amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
                bill.setBillingDate(rs.getTimestamp("billing_date"));

                return bill;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Billing> getAllBills(){

        List<Billing> list=new ArrayList<>();

        String sql="SELECT * FROM billing";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            while(rs.next()){

                Billing bill=new Billing();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setAmount(rs.getBigDecimal("amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
                bill.setBillingDate(rs.getTimestamp("billing_date"));

                list.add(bill);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateBill(Billing billing){

        String sql="UPDATE billing SET amount=?,payment_status=? WHERE bill_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setBigDecimal(1,billing.getAmount());
            ps.setString(2,billing.getPaymentStatus());
            ps.setInt(3,billing.getBillId());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteBill(int billId){

        String sql="DELETE FROM billing WHERE bill_id=?";

        try(Connection con=DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,billId);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

}