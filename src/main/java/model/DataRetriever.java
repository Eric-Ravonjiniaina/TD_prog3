package model;

import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String SQL = "SELECT DISTINCT name FROM Product_category ORDER BY name";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {

            int tempId = 1;
            while (rs.next()) {
                String name = rs.getString("name");
                categories.add(new Category(tempId++, name));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des catégories: " + e.getMessage());
        }

        return categories;
    }

}
