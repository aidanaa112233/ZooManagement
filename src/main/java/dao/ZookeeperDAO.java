package com.example.zoo.zoomanagement.dao;

import com.example.zoo.zoomanagement.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ZookeeperDAO {

    public static void addZookeeper(String name, int experience, String phone) {
        String sql = "INSERT INTO zookeeper(full_name, experience_years, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, experience);
            ps.setString(3, phone);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
