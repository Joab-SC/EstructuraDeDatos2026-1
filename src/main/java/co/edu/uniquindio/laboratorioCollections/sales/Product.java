package co.edu.uniquindio.laboratorioCollections.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product implements Comparable<Product> {

    private String code;
    private int price;
    private String category;

    @Override
    public int compareTo(Product other) {
        return price - other.getPrice();
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}