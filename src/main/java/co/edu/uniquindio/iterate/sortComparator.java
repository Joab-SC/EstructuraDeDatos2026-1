package co.edu.uniquindio.iterate;


import java.util.*;

public class sortComparator {
    public static void main(String[] args){
        Client cliente = new Client("Joab", 18, "Rojo");
        Client cliente1 = new Client("Laura", 19, "Amarillo");
        Client cliente2 = new Client("Maicol", 10, "Verde");
        Client cliente3 = new Client("Sharick", 10, "Amarillo");
        Client cliente4 = new Client("Santiago", 10, "Rojo");


        ArrayList<Client> clientes = new ArrayList<>(List.of(cliente, cliente1, cliente2, cliente3, cliente4));
        Collections.sort(clientes);
        System.out.println(clientes);
    }
}
