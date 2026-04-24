package co.edu.uniquindio.colas;

public class RunColas {

	public static void main(String[] args) {
		
		
		Cola<Integer> cola= new Cola<>();
		
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		
		cola.desencolar();
		
		cola.imprimir();
		

	}

}
