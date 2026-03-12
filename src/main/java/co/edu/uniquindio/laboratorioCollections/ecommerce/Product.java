package co.edu.uniquindio.laboratorioCollections.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private String code;
    private String name;
    private Double price;
}