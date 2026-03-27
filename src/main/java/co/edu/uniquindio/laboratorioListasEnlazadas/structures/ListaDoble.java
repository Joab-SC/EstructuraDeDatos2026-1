package co.edu.uniquindio.laboratorioListasEnlazadas.structures;

import java.util.Iterator;


/**
 * 
 * Definici�n de la clase lista Simple de tipo Generics
 * @param <T>
 * 
 * **/

public class ListaDoble<T> implements Iterable<T> {
	
	private NodoDoble<T> nodoPrimero;
	private NodoDoble<T> nodoUltimo;
	private int tamanio;
	

	public ListaDoble() {
		nodoPrimero = null;
		nodoPrimero = null;
		tamanio = 0;
	}
	
	
	//Metodos basicos
	
	
	//Agregar al inicio de la lista
	public void agregarInicio(T valorNodo) {
		
		NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);
		
		if(estaVacia())
		{
			nodoPrimero = nodoUltimo = nuevoNodo;
		}
		else
		{
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero = nuevoNodo;
		}
		tamanio++;
	}
	
	
	//Agregar al final de la lista
	public void agregarfinal(T valorNodo) {
		
		NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);
		
		if(estaVacia())
		{
			nodoPrimero = nodoUltimo = nuevoNodo;
		}
		else
		{
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setAnteriorNodo(nodoUltimo);
			nodoUltimo = nuevoNodo;
		}
		tamanio++;
	}
	
	
	/**
	 * Agrega un valor en la lista en una posici�n espec�fica
	 * @param indice �ndice donde se va a guardar el dato
	 * @param dato El valor a guardar
	 */
	public void agregar(T dato, int indice) {

		if(indiceValido(indice)) {

			if(indice==0) {
				agregarInicio(dato);
			}
			else {
				NodoDoble<T> nuevo = new NodoDoble<>(dato);			
				NodoDoble<T> actual = obtenerNodo(indice);

				nuevo.setSiguienteNodo(actual);
				nuevo.setAnteriorNodo(actual.getAnteriorNodo());
				actual.getAnteriorNodo().setSiguienteNodo(nuevo);
				actual.setAnteriorNodo(nuevo);

				tamanio++;
			}
		}
	}

	
	/**
	 * Borra completamente la Lista
	 */
	public void borrarLista() {
		nodoPrimero = nodoUltimo = null;
		tamanio = 0;
	}
	
	
	//Obtener Nodo el valor de un Nodo
	public T obtenerValorNodo(int indice) {
		
		NodoDoble<T> nodoTemporal = null;
		int contador = 0;
		
		if(indiceValido(indice))
		{
			nodoTemporal = nodoPrimero;
			
			while (contador < indice) {
				
				nodoTemporal = nodoTemporal.getSiguienteNodo();
				contador++;
			}
		}
		
		if(nodoTemporal != null)
			return nodoTemporal.getValorNodo();
		else
			return null;
	}
	
	
	//Verificar si indice es valido
	private boolean indiceValido(int indice) {		
		if( indice>=0 && indice<tamanio ) {
			return true;
		}			
		throw new RuntimeException("�ndice no v�lido");
	}
	
	
	//Verificar si la lista esta vacia
	public boolean estaVacia() {
//		return(nodoPrimero == null)?true:false;
		return nodoPrimero == null && nodoUltimo == null;
	}

	
	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {
		
		NodoDoble<T> aux = nodoPrimero;
		
		while(aux!=null) {
			System.out.print( aux.getValorNodo()+"\t" );
			aux = aux.getSiguienteNodo();			
		}
		
		System.out.println();
	}
	
	public void imprimirHaciaAtras() {
		
		for(NodoDoble<T> aux = nodoUltimo; aux!=null; aux = aux.getAnteriorNodo()) {
			System.out.print( aux.getValorNodo()+"\t" );
		}
		System.out.println();
		
	}
	
	
	//Eliminar dado el valor de un nodo
	/**
	 * Elimina un elemento de la lista
	 * @param dato dato a eliminar
	 * @return El dato que se elimina
	 */
	public T eliminar(T dato) {
		
		NodoDoble<T> nodo = buscarNodo(dato);
		
		if(nodo!=null) {

			NodoDoble<T> previo = nodo.getAnteriorNodo();
			NodoDoble<T> siguiente = nodo.getSiguienteNodo();
			
			if(previo==null) {
				nodoPrimero = siguiente;
			}else {
				previo.setSiguienteNodo(siguiente);
			}
			
			if(siguiente==null) {
				nodoUltimo = previo;
			}else {
				siguiente.setAnteriorNodo(previo);
			}
			
			nodo=null;
			tamanio--;
			
			return dato;
		}
		
		throw new RuntimeException("El valor no existe");		
	}
	
	
	//Elimina el primer nodo de la lista
	public T eliminarPrimero() {
		
		if( !estaVacia() ) {
			NodoDoble<T> nodoAux = nodoPrimero;
		    T valor = nodoAux.getValorNodo();
			nodoPrimero = nodoAux.getSiguienteNodo();
			
			if(nodoPrimero==null) {
				nodoUltimo = null;
			}
			else
			{
				nodoPrimero.setAnteriorNodo(null);
			}
			
			tamanio--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");		
	}

	
	public T eliminarUltimo() {
		
		if( !estaVacia() ) {			
			T valor = nodoUltimo.getValorNodo();
			NodoDoble<T> prev = obtenerNodo(tamanio-2);
			nodoUltimo = prev;
			
			if(nodoUltimo==null) {
				nodoPrimero=null;
			}else {					
				prev.setSiguienteNodo(null);
			}				
			
			tamanio--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");
	}	

	
	/**
	 * Devuelve el Nodo de una lista dada su posici�n
	 * @param indice �ndice para obtener el Nodo
	 * @return Nodo objeto
	 */
	private NodoDoble<T> obtenerNodo(int indice) {
		
		if(indice>=0 && indice<tamanio) {
		
			NodoDoble<T> nodo = nodoPrimero;
			
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}
		
			return nodo;			
		}
		
		return null;
	}
	
	/**
	 * Devuelve un nodo que contenga un dato espec�fico
	 * @param dato Dato a buscar
	 * @return Nodo 
	 */
	private NodoDoble<T> buscarNodo(T dato){
		
		NodoDoble<T> aux = nodoPrimero;
		
		while(aux!=null) {
			if(aux.getValorNodo().equals(dato)) {
				return aux;
			}
			aux = aux.getSiguienteNodo();
		}
		
		return null;		
	}

	
	
	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificarNodo(int indice, T nuevo) {
		
		if( indiceValido(indice) ) {			
			NodoDoble<T> nodo = obtenerNodo(indice);
			nodo.setValorNodo(nuevo);			
		}
		
	}
	
	
	/**
	 * Retorna la primera posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicionNodo(T dato) {

		int i = 0;
		
		for( NodoDoble<T> aux = nodoPrimero ; aux!=null ; aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	
	/**
	 * Devuelve un elemento de la lista dado su �ndice
	 * @param indice �ndice de la lista
	 * @return dato guardado en el �ndice especificado
	 */
	public T obtener(int indice) {
		
		if( indiceValido(indice) ) {
			NodoDoble<T> n = obtenerNodo(indice);
			
			if(n!=null) {
				return n.getValorNodo();
			}
		}

		return null;		
	}

	
	
	
	
	
	@Override
	public Iterator<T> iterator() {
		
		return new IteradorListaDoble (nodoPrimero);
	}
	
	protected class IteradorListaDoble implements Iterator<T>{

		private NodoDoble<T> nodo;
		private int posicion;
		
		/**
		 * Constructor de la clase Iterador
		 * @param nodo Primer Nodo de la lista
		 */
		public IteradorListaDoble(NodoDoble<T> nodo) {
			this.nodo = nodo;
			this.posicion = 0;
		}
		
		@Override
		public boolean hasNext() {
			return nodo!=null;
		}

		@Override
		public T next() {
			T valor = nodo.getValorNodo();
			nodo = nodo.getSiguienteNodo();
			posicion++;
			return valor;
		}
		
		public boolean hasPrevious() {
			return nodo!=null;
		}
		
		
		public T previous() {
			T aux = nodo.getValorNodo();
			nodo = nodo.getAnteriorNodo();
			posicion--;
			return aux;
		}
		
		public int nextIndex() {
			return posicion;
		}
		

		public int previousIndex() {
			return posicion-1;
		}

		public void remove() {
			if(nodo!=null) {
				eliminar(nodo.getValorNodo());
			}
		}
		
		public void set(T e) {
			if(nodo!=null) {
				nodo.setValorNodo(e);				
			}
		}

		public void add(T e) {
			agregarfinal(e);
		}
		
		
		/**
		 * Posici�n actual de la lista
		 * @return posici�n
		 */
		public int getPosicion() {
			return posicion;
		}
		
	}
	
	
	//Metodos get y set de la clase ListaSimple
	
	
	public NodoDoble<T> getNodoPrimero() {
		return nodoPrimero;
	}


	public void setNodoPrimero(NodoDoble<T> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}

	public NodoDoble<T> getNodoUltimo() {
		return nodoUltimo;
	}


	public void setNodoUltimo(NodoDoble<T> nodoUltimo) {
		this.nodoUltimo = nodoUltimo;
	}


	public int getTamanio() {
		return tamanio;
	}


	public void setTamanio(int tamano) {
		this.tamanio = tamano;
	}



	
	

}
