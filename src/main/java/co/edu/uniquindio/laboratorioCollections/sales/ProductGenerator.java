package co.edu.uniquindio.laboratorioCollections.sales;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {

    private static final String[] CATEGORIES = {
            "Electronics", "Clothing", "Books", "Toys", "Home", "Sports", "Beauty"
    };

    private static final String[] NAMES = {
            "Laptop", "Shirt", "Novel", "Doll", "Vacuum", "Ball", "Perfume",
            "Headphones", "Jacket", "Cookbook", "Puzzle", "Sofa", "Sneakers"
    };

    public static List<Product> generate(int amount) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            String name = NAMES[random.nextInt(NAMES.length)];
            String category = CATEGORIES[random.nextInt(CATEGORIES.length)];

            // Generate random code like P123456
            String code = "P" + (100_000 + random.nextInt(900_000));

            // Random price between 10 and 1000
            int price = 10 + random.nextInt(991);

            products.add(new Product(code, price, category));
        }

        return products;
    }
}