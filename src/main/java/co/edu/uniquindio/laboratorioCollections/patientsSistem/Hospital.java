package co.edu.uniquindio.laboratorioCollections.patientsSistem;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.PriorityQueue;

@Getter
@Setter
public class Hospital {
    private PriorityQueue<Patient> patientsQueue;
    private HashMap<String, Patient> patientsMap;

    public Hospital(){
        this.patientsQueue = new PriorityQueue<>(Patient::compareTo);
        this.patientsMap = new HashMap<>();
    }

    public void registerPatient(Patient patient) throws Exception {
        if(findPatient(patient.getId()) != null){
            throw new Exception("There is already a patient with that id");
        }
        patientsQueue.add(patient);
        patientsMap.put(patient.getId(), patient);
    }
    public Patient findPatient(String id){
        return patientsMap.get(id);
    }
}
