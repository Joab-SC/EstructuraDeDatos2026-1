package co.edu.uniquindio.generics.camion;

import java.util.Objects;

public class Paquete implements Comparable<Paquete>{


    private String contenido;
    private double peso;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Paquete(String contenido, double peso){
        this.contenido = contenido;
        this.peso = peso;
    }

    @Override
    public int compareTo(Paquete otro) {
        return Double.compare(this.getPeso(), otro.getPeso());
    }


}
