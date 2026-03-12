package co.edu.uniquindio.laboratorioCollections.taxiRequestPlatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RequestGenerator {

    private static final String[] LOCATIONS = {
            "Downtown", "Airport", "Mall", "University", "Central Park",
            "Station", "Hotel", "Hospital", "Suburbs", "City Center"
    };

    public static List<Request> generate(int amount) {
        List<Request> requests = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            // Generate random code like R123456
            String code = "R" + (100_000 + random.nextInt(900_000));

            // Pick a random location
            String location = LOCATIONS[random.nextInt(LOCATIONS.length)];

            requests.add(new Request(code, location));
        }

        return requests;
    }
}