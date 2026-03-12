package co.edu.uniquindio.generics.camion;

import java.util.*;

public class Camion <T extends Paquete> implements Iterable<T>{
    private LinkedList<T> paquetes;

    public Camion(){
        this.paquetes = new LinkedList<>();
    }

    public void descargarPaquete(T paquete) throws Exception {
        if(paquetes.isEmpty()) {
            throw new Exception ("No hay paquetes que descargar");
        }
        paquetes.remove(paquete);
    }

    public void agregarPaquete(T paquete){
        paquetes.add(paquete);
    }

    public Paquete obtenerMasPesado(){
        return paquetes.stream().max(Paquete::compareTo).
                orElseThrow(() -> new RuntimeException("No hay productos en la lista"));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int posicion = 0;

            @Override
            public boolean hasNext() {
                return posicion < paquetes.size();
            }

            @Override
            public T next() {

                T dato = paquetes.get(posicion);
                posicion += 2;
                return dato;
            }
        };
    }

    public static void mostrarCamion(Camion<? extends Paquete> camion){
        for(Object paquete : camion){
            System.out.println(paquete);
        }
    }
}
