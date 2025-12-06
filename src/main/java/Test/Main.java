package Test;

import connection.DBConnection;
import model.Category;
import model.DataRetriever;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            DataRetriever retriever = new DataRetriever();

            List<Category> categories = retriever.getAllCategories();

            if (categories.isEmpty()) {
                System.out.println("Category empty");
            } else {
                System.out.println("----");

                for (Category cat : categories) {
                    System.out.println(cat);
                }
                System.out.println("----");
            }
    }
}