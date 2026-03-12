package co.edu.uniquindio.laboratorioCollections.patientsSistem;

import co.edu.uniquindio.laboratorioCollections.Benchmark;
import co.edu.uniquindio.laboratorioCollections.patientsSistem.Hospital;
import co.edu.uniquindio.laboratorioCollections.patientsSistem.Patient;
import co.edu.uniquindio.laboratorioCollections.patientsSistem.PatientGenerator;

import java.time.LocalTime;
import java.util.List;

public class MainPatients{
    public static void main(String[] args) throws InterruptedException {
        Hospital hospital = new Hospital();
        List<Patient> patients = PatientGenerator.generate(999);
        Benchmark.run("Register 1000 patients", () -> {

            for(Patient patient: patients){
                try{
                    hospital.registerPatient(patient);
                }catch (Exception e){
                    continue;
                }
            }
            try{
                hospital.registerPatient(new Patient("Laura", "109246761", LocalTime.of(10,10,10), true));
            } catch (Exception e) {
            }

        });

        Benchmark.run("Find an element ",() -> {
            System.out.println(hospital.findPatient("109246761"));
        });
    }
}


