package co.edu.uniquindio.iterate;


import java.util.*;

public class sortComparator {
    public static void main(String[] args){
        Cliente cliente = new Cliente("Joab", 18);
        Cliente cliente1 = new Cliente("Laura", 19);
        Cliente cliente2 = new Cliente("Maicol", 10);

        ArrayList<Cliente> clientes = new ArrayList<>(List.of(cliente, cliente1, cliente2));
        Collections.sort(clientes, new ordenEdadCliente());
        System.out.println(clientes);
    }
}
