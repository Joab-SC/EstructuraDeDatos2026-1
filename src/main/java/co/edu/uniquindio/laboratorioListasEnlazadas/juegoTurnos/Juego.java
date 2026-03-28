package co.edu.uniquindio.laboratorioListasEnlazadas.juegoTurnos;

import co.edu.uniquindio.laboratorioListasEnlazadas.structures.ListaDobleCircular;

public class Juego {

    private ListaDobleCircular<Jugador> jugadores;
    private Jugador jugadorActual;

    public Juego() {
        this.jugadores = new ListaDobleCircular<>();
        this.jugadorActual = null;
    }

    public Jugador pasarturno(){
        if (jugadores.estaVacia()) {
            throw new RuntimeException("La lista de reproducción está vacía");
        }

        // Si no hay canción actual, empezar por la primera
        if (jugadorActual == null) {
            jugadorActual = jugadores.obtenerValorNodo(0);
            return jugadorActual;
        }

        // La lista se encarga de todo internamente
        jugadorActual = jugadores.siguiente(jugadorActual);
        return jugadorActual;
    }

    public Jugador eliminarJugador(Jugador jugador){
        if (jugador.equals(jugadorActual)) {
            if (jugadores.getTamanio() == 1) {
                jugadorActual = null;
            } else {
                jugadorActual = jugadores.siguiente(jugadorActual);
            }
        }
        return jugadores.eliminar(jugador);
    }

    public Jugador consultarSiguienteJugador() {
        if (jugadorActual == null) throw new RuntimeException("La partida no ha iniciado");
        return jugadores.siguiente(jugadorActual);
    }

    public Jugador consultarAnteriorJugador() {
        if (jugadorActual == null) throw new RuntimeException("La partida no ha iniciado");
        return jugadores.anterior(jugadorActual);
    }

    public Jugador devolverTurno(){
        if (jugadores.estaVacia()) {
            throw new RuntimeException("La lista de reproducción está vacía");
        }

        // Si no hay canción actual, empezar por la primera
        if (jugadorActual == null) {
            jugadorActual = jugadores.obtenerValorNodo(0);
            return jugadorActual;
        }

        // La lista se encarga de todo internamente
        jugadorActual = jugadores.anterior(jugadorActual);
        return jugadorActual;
    }

}
