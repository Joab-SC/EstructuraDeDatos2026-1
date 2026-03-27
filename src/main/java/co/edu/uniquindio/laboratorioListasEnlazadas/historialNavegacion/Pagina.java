package co.edu.uniquindio.laboratorioListasEnlazadas.historialNavegacion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagina {
    private String url;
    private String titulo;
}