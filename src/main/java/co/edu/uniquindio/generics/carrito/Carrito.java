package co.edu.uniquindio.generics.carrito;

import java.util.ArrayList;

public class Carrito<T extends Producto> {
    ArrayList<T> productos;

    public Carrito(){
        this.productos = new ArrayList<>();
    }
    public T obtenerProductoMayor(){
        return productos.stream()
                .max(Producto::compareTo)
                .orElse(null);
    }

    public double getTotal(){
        double total = 0;
        for (Producto producto: productos){
            total+= producto.getPrecio();
        }
        return total;
    }

}
