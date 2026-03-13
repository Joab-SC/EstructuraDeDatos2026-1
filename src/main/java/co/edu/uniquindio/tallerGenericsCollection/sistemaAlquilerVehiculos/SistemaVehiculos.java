package co.edu.uniquindio.tallerGenericsCollection.sistemaAlquilerVehiculos;

import java.util.List;

public class SistemaVehiculos {
    public void alquilarVehiculos(List<? extends Vehiculo> vehiculos){
        for(Vehiculo vehiculo: vehiculos){
            vehiculo.alquilar();
        }
    }
}
