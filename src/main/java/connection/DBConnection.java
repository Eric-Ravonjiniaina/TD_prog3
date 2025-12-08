package connection;

import java.sql.*;

public class DBConnection {
    static String url = "jdbc:postgresql://localhost:5432/product_management_db";
    static String user = "product_manager_user";
    static String password = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println("✅ CONNECTED TO DATABASE");

        } catch (SQLException e) {
            System.err.println("Failed to connect to database.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println(" Connexion fermée avec succès.");
                } catch (SQLException e) {
                    System.err.println("Errorrr");
                    e.printStackTrace();
                }
            }
        }
    }
}