package co.edu.uniquindio.laboratorioCollections.ecommerce;

import co.edu.uniquindio.laboratorioCollections.ecommerce.Product;

import java.util.*;

  public class Catalog {

    private HashMap<String, Product> productHashMap;
    private TreeMap<Double, ArrayList<Product>> productTreeMap;

    public Catalog() {
        this.productHashMap = new HashMap<>();
        this.productTreeMap = new TreeMap<>();
    }

    public Product findProduct(String code) {
        return productHashMap.get(code);
    }

    public void addProduct(Product product) {
        productHashMap.put(product.getCode(), product);
        productTreeMap
                .computeIfAbsent(product.getPrice(), k -> new ArrayList<>())
                .add(product);
    }

    public void showProductsByPrice() {
        for (Map.Entry<Double, ArrayList<Product>> entry : productTreeMap.entrySet()) {
            Double price = entry.getKey();
            ArrayList<Product> productsAtPrice = entry.getValue();

            System.out.println("Price: " + price);
            for (Product product : productsAtPrice) {
                System.out.println("    " + product);
            }
        }
    }
}