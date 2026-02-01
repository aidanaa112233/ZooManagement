package com.example.zoo.zoomanagement.dao;

import com.example.zoo.zoomanagement.DBConnection;
import com.example.zoo.zoomanagement.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public static void addAnimal(String name, String species, int age, String enclosure) {
        String sql = "INSERT INTO animal(name, species, age, enclosure) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, species);
            ps.setInt(3, age);
            ps.setString(4, enclosure);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Animal> getAnimalsList() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Animal a = new Animal();
                a.id = rs.getInt("id");
                a.name = rs.getString("name");
                a.species = rs.getString("species");
                a.age = rs.getInt("age");
                a.enclosure = rs.getString("enclosure");
                animals.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }
}
