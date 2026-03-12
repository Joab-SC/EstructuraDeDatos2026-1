package co.edu.uniquindio.laboratorioCollections.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {

    private static final String[] NAMES = {
            "Laptop", "Smartphone", "Tablet", "Headphones", "Camera",
            "Monitor", "Keyboard", "Mouse", "Smartwatch", "Printer"
    };

    public static List<Product> generate(int amount) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            // Random code like P123456
            String code = "P" + (100_000 + random.nextInt(900_000));
            // Random product name
            String name = NAMES[random.nextInt(NAMES.length)];
            // Random price between 50.0 and 2000.0
            double price = 50 + (2000 - 50) * random.nextDouble();

            products.add(new Product(code, name, price));
        }

        return products;
    }
}