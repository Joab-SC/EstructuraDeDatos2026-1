package co.edu.uniquindio.generics.carrito;

public class Producto implements Comparable<Producto>{
    private double precio;

    public Producto(Double precio){
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto producto) {
        return (int) Math.round(precio - producto.precio);
    }
}
