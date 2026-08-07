package com.clinic;

import java.sql.Connection;

import com.clinic.config.DatabaseConnection;

public class TestConnection {

    public static void main(String[] args) {

        try (Connection con = DatabaseConnection.getConnection()) {

            if (con != null) {
                System.out.println("Connected Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}