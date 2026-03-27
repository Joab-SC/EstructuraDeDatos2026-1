package co.edu.uniquindio.laboratorioListasEnlazadas.structures;

public class ListaDobleCircular<T> {
	
	private NodoDoble<T> nodoPrimero;
	private NodoDoble<T> nodoUltimo;
	private int tamanio;
	
	public ListaDobleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}
	
	/**
	 * Agrega un nuevo nodo en la posici�n dada
	 * @param valor
	 * @param posicion
	 */
	public void insertar( T valor, int posicion ) {
		int cont = 0;
		
		for( NodoDoble<T> aux = nodoPrimero; cont < tamanio; cont++, aux = aux.getSiguienteNodo() ) {
			if( cont == posicion ) {
				NodoDoble<T> aux2 = aux.getAnteriorNodo();
				NodoDoble<T> nuevo = new NodoDoble<>( valor );
				aux2.setSiguienteNodo( nuevo );
				nuevo.setSiguienteNodo( aux );
				nuevo.setAnteriorNodo( aux2 );
				aux.setAnteriorNodo( nuevo );
				tamanio ++;
			}
		}
	}
	
	/**
	 * Busca y retorna la posici�n de un nodo que tenga el valor ingresado por par�metro
	 * @param valor a buscar
	 * @return posici�n donde se encontr� el nodo
	 */
	public int buscar( T valor ) {
		int cont = 0;
		int pos = -1;
	
		for( NodoDoble<T> aux = nodoPrimero; cont < tamanio; cont++, aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals( valor ) ) {
				pos = cont;
			}
		}
		return pos;
	}
	
	public void agregarFinal(T valorNodo) {
		
		NodoDoble<T> nuevoNodo = new NodoDoble<>( valorNodo );
		
		if( estaVacia() ) {
			nodoPrimero = nodoUltimo = nuevoNodo;
		}
		else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevoNodo);
			nodoUltimo.setSiguienteNodo( nuevoNodo );
			nuevoNodo.setAnteriorNodo( nodoUltimo );
			nodoPrimero = nuevoNodo;
		}
		tamanio++;
	}
	
	//Verificar si la lista esta vacia
	public boolean estaVacia() {
		return nodoPrimero == null && nodoUltimo == null;
	}
	
	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {
		
		NodoDoble<T> aux = nodoPrimero;
		int cont = 0;
		
		while( aux!=null && cont != tamanio ) {
			System.out.print( aux.getValorNodo()+"\t" );
			aux = aux.getSiguienteNodo();			
			cont ++;
		}
		
		System.out.println();
	}

}
