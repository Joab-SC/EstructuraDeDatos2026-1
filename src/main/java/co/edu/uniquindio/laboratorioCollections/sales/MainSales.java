package co.edu.uniquindio.laboratorioCollections.sales;

import co.edu.uniquindio.laboratorioCollections.Benchmark;

import java.util.List;

public class MainSales {
    public static void main(String[] args) throws InterruptedException {
        Sale sale = new Sale();
        List<Product> products = ProductGenerator.generate(99999999);

        Benchmark.run("Add 10,000 products", () -> {
            for (Product product : products) {
                try {
                    sale.addProduct(product);
                } catch (Exception e) {
                    continue;
                }
            }
            try{
                sale.addProduct(new Product("P999999", 500, "Electronics"));
            } catch (Exception e) {
            }

        });

        Benchmark.run("Find a product by code", () -> {
            System.out.println(sale.findProduct("P999999"));
        });

        Benchmark.run("Filter products by category", () -> {
            List<Product> electronics = sale.filterByCategory("Electronics");
            System.out.println("Electronics count: " + (electronics != null ? electronics.size() : 0));
        });

        Benchmark.run("Show 10000 products sorted by price", sale::showProductsSortedByPrice);
    }
}