package co.edu.uniquindio.laboratorioCollections.sales;

import java.util.HashMap;
import java.util.LinkedList;

public class Sale {

    private LinkedList<Product> productList;
    private HashMap<String, Product> productHashMap;
    private HashMap<String, LinkedList<Product>> productHashMapByCategory;

    public Sale() {
        this.productList = new LinkedList<>();
        this.productHashMap = new HashMap<>();
        this.productHashMapByCategory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if(findProduct(product.getCode()) != null){
            throw new RuntimeException("There is already a product with that id");
        }
        productList.addFirst(product);
        productHashMap.put(product.getCode(), product);

        productHashMapByCategory
                .computeIfAbsent(product.getCategory(), k -> new LinkedList<>())
                .addFirst(product);
    }

    public void sortProductsByPrice() {
        productList.sort(null);
    }

    public Product findProduct(String code) {
        return productHashMap.get(code);
    }

    public LinkedList<Product> filterByCategory(String category) {
        return productHashMapByCategory.get(category);
    }

    public void showProductsSortedByPrice() {
        sortProductsByPrice();
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }
}