package co.edu.uniquindio.iterate;

import java.util.Comparator;

public class ordenEdadCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getAge() - o2.getAge();
    }
}
