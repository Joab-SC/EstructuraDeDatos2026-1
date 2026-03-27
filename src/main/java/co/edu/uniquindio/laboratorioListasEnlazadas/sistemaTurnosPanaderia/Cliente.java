package co.edu.uniquindio.laboratorioListasEnlazadas.sistemaTurnosPanaderia;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private int turno;
    private String nombre;
}
