package co.edu.uniquindio.laboratorioCollections.patientsSistem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientGenerator {

    private static final String[] NAMES = {
            "Ana", "Carlos", "Luis", "Maria", "Pedro", "Sofia", "Juan", "Laura",
            "Diego", "Elena", "Miguel", "Paula", "Andres", "Valeria", "Jorge"
    };

    private static final String[] LASTNAMES = {
            "Garcia", "Martinez", "Lopez", "Gonzalez", "Rodriguez", "Perez",
            "Sanchez", "Ramirez", "Torres", "Flores", "Rivera", "Morales"
    };

    public static List<Patient> generate(int amount) {
        List<Patient> patients = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            String name = NAMES[random.nextInt(NAMES.length)] + " " +
                    LASTNAMES[random.nextInt(LASTNAMES.length)];

            String id = String.valueOf(100_000_000 + random.nextInt(900_000_000)); // cédula aleatoria

            LocalTime arrivalTime = LocalTime.of(
                    random.nextInt(24),
                    random.nextInt(60)
            );

            Boolean priority = random.nextBoolean(); // true o false aleatorio

            patients.add(new Patient(name, id, arrivalTime, priority));
        }

        return patients;
    }
}