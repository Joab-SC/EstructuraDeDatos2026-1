package co.edu.uniquindio.laboratorioListasEnlazadas.listaReproduccionMusica;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cancion {
    private String nombre;
    private String artista;
    private double duracion;
}