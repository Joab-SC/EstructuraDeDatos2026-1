package co.edu.uniquindio.laboratorioCollections.patientsSistem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Patient implements Comparable<Patient>{
    private String name;
    private String id;
    private LocalTime arrivalTime;
    private Boolean priority;

    @Override
    public int compareTo(Patient o) {
         int comp = priority.compareTo(o.getPriority());
         if(comp == 0){
             comp = arrivalTime.compareTo(o.getArrivalTime());
         }
         return comp;
    }
}
