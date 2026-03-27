package co.edu.uniquindio.laboratorioListasEnlazadas.juegoTurnos;

import lombok.Data;

@Data
public class Jugador {
    private int id;
    private String nombre;
    private int puntaje = 0;

    public Jugador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}