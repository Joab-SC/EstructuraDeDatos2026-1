package co.edu.uniquindio.generics.camion;

public class main {
    public static void main(String[] args) {

        Camion<Paquete> camion = new Camion<>();

        Paquete p1 = new Paquete("Ropa",4);
        Paquete p2 = new Paquete("Electrónicos",6);
        Paquete p3 = new Paquete("Libros",10);
        Paquete p4 = new Paquete("Lapices",9);
        Paquete p5 = new Paquete("Celulares",99);


        camion.agregarPaquete(p1);
        camion.agregarPaquete(p2);
        camion.agregarPaquete(p3);
        camion.agregarPaquete(p4);
        camion.agregarPaquete(p5);

        for(Paquete paquete: camion){
            System.out.println(paquete.toString());
        }

    }
}
