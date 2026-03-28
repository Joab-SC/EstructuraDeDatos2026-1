package co.edu.uniquindio.laboratorioListasEnlazadas.listaReproduccionMusica;

import co.edu.uniquindio.laboratorioListasEnlazadas.structures.ListaSimpleCircular;
import co.edu.uniquindio.laboratorioListasEnlazadas.structures.Nodo;


public class ListaReproduccion {

    private ListaSimpleCircular<Cancion> canciones;
    private Cancion cancionActual;

    public ListaReproduccion() {
        this.canciones = new ListaSimpleCircular<>();
        this.cancionActual = null;
    }

    public Cancion siguienteCancion(){
        if (canciones.estaVacia()) {
            throw new RuntimeException("La lista de reproducción está vacía");
        }

        // Si no hay canción actual, empezar por la primera
        if (cancionActual == null) {
            cancionActual = canciones.obtenerValorNodo(0);
            return cancionActual;
        }

        // La lista se encarga de todo internamente
        cancionActual = canciones.siguiente(cancionActual);
        return cancionActual;
    }

    public Cancion eliminarCancion(Cancion cancion){
        if (cancion.equals(cancionActual)) {
            if (canciones.getTamanio() == 1) {
                cancionActual = null;
            } else {
                cancionActual = canciones.siguiente(cancionActual);
            }
        }
        return canciones.eliminar(cancion);
    }

    public void mostrarLista(){
        canciones.imprimirLista();
    }
}
