package Test;

import model.Category;
import model.DataRetriever;
import model.Product;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever retriever = new DataRetriever();
        testGetAllCategories(retriever);
        testGetProductList(retriever, 1, 3);

    }

        public static void testGetAllCategories (DataRetriever retriever){
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

    public static void testGetProductList(DataRetriever retriever, int page, int size) {
        System.out.println("\n Test getProductList(page=" + page + ", size=" + size + ")");

        List<Product> products = retriever.getProductList(page, size);

        if (products.isEmpty()) {
            System.out.println(" Product empty in page" + page);
        } else {
            for (Product prod : products) {
                System.out.println("----");
                System.out.println(prod);
            }
            System.out.println("----");
        }
    }
}