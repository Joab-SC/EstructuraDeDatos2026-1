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

	public T siguiente(T datoActual) {
		NodoDoble<T> aux = nodoPrimero;

		for (int i = 0; i < tamanio; i++) {
			if (aux.getValorNodo().equals(datoActual)) {
				return aux.getSiguienteNodo().getValorNodo();
			}
			aux = aux.getSiguienteNodo();
		}

		throw new RuntimeException("No encontrado el dato");
	}

	public T anterior(T datoActual) {
		NodoDoble<T> aux = nodoPrimero;

		for (int i = 0; i < tamanio; i++) {
			if (aux.getValorNodo().equals(datoActual)) {
				return aux.getAnteriorNodo().getValorNodo();
			}
			aux = aux.getSiguienteNodo();
		}

		throw new RuntimeException("No encontrado el dato");
	}

	public T obtenerValorNodo(int indice) {

		NodoDoble<T> nodoTemporal = null;
		int contador = 0;

		if (indiceValido(indice)) {
			nodoTemporal = nodoPrimero;
			while (contador < indice) {
				nodoTemporal = nodoTemporal.getSiguienteNodo();
				contador++;
			}
		}

		return (nodoTemporal != null) ? nodoTemporal.getValorNodo() : null;
	}

	private boolean indiceValido(int indice) {
		if (indice >= 0 && indice < tamanio) return true;
		throw new RuntimeException("Índice no válido");
	}

	public int getTamanio() {
		return tamanio;
	}

	public T eliminar(T dato) {

		if (estaVacia()) throw new RuntimeException("Lista vacía");

		// Buscar el nodo a eliminar
		NodoDoble<T> nodo = nodoPrimero;
		boolean encontrado = false;

		for (int i = 0; i < tamanio; i++) {
			if (nodo.getValorNodo().equals(dato)) {
				encontrado = true;
				break;
			}
			nodo = nodo.getSiguienteNodo();
		}

		if (!encontrado) throw new RuntimeException("El elemento no existe");

		if (tamanio == 1) {
			// Único elemento
			nodoPrimero = null;
			nodoUltimo = null;

		} else if (nodo == nodoPrimero) {
			// Eliminar el primero
			nodoPrimero = nodoPrimero.getSiguienteNodo();
			nodoPrimero.setAnteriorNodo(nodoUltimo);
			nodoUltimo.setSiguienteNodo(nodoPrimero);

		} else if (nodo == nodoUltimo) {
			// Eliminar el último
			nodoUltimo = nodoUltimo.getAnteriorNodo();
			nodoUltimo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nodoUltimo);

		} else {
			// Eliminar del medio
			NodoDoble<T> anterior  = nodo.getAnteriorNodo();
			NodoDoble<T> siguiente = nodo.getSiguienteNodo();
			anterior.setSiguienteNodo(siguiente);
			siguiente.setAnteriorNodo(anterior);
		}

		tamanio--;
		return dato;
	}
}
