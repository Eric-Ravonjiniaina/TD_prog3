package model;

import connection.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
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
            System.err.println("Errorr: " + e.getMessage());
        }

        return categories;
    }

    public List<Product> getProductList(int page, int size) {
        int offset = (page - 1) * size;
        List<Product> products = new ArrayList<>();
        String productsSQL =
                "SELECT id, name, price, creation_datetime " +
                        "FROM Product " +
                        "ORDER BY id " +
                        "LIMIT ? OFFSET ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(productsSQL)) {

            stmt.setInt(1, size);
            stmt.setInt(2, offset);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    BigDecimal price = rs.getBigDecimal("price");
                    Instant creationDatetime = rs.getTimestamp("creation_datetime").toInstant();

                    Product product = new Product(id, name, price, creationDatetime, new ArrayList<>());

                    products.add(product);
                }
            }

        } catch (SQLException e) {
            System.err.println( e.getMessage());
        }

        return products;
    }
}
