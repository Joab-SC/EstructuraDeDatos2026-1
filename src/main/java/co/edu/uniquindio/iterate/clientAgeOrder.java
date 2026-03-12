package co.edu.uniquindio.iterate;

import java.util.Comparator;

public class clientAgeOrder implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getAge() - o2.getAge();
    }
}
