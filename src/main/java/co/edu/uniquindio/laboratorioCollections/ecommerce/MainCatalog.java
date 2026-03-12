package co.edu.uniquindio.laboratorioCollections.ecommerce;

import co.edu.uniquindio.laboratorioCollections.Benchmark;

import java.util.List;

public class MainCatalog {
    public static void main(String[] args) throws InterruptedException {
        Catalog catalog = new Catalog();


        List<Product> products = ProductGenerator.generate(10000);

        Benchmark.run("Add 10,000 products", () -> {
            for (Product product : products) {
                try{
                    catalog.addProduct(product);
                }
                catch (RuntimeException e){
                    continue;
                }

            }

            catalog.addProduct(new Product("P999999", "Special Laptop", 999.99));
        });

        Benchmark.run("Find product by code", () -> {
            System.out.println(catalog.findProduct("P999999"));
        });

        Benchmark.run("Show products sorted by price", catalog::showProductsByPrice);
    }
}