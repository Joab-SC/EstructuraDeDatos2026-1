package co.edu.uniquindio.laboratorioListasEnlazadas.structures;

import java.util.Iterator;

public class ListaSimpleCircular<T> implements Iterable<T> {

	private Nodo<T> nodoPrimero;
	private Nodo<T> nodoUltimo;
	private int tamanio;

	public ListaSimpleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}


	// Agregar al INICIO de la lista

	public void agregarInicio(T valorNodo) {

		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo); // apunta a sí mismo
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nodoPrimero = nuevoNodo;
		}
		tamanio++;
	}


	// Agregar al FINAL de la lista

	public void agregarfinal(T valorNodo) {

		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo);
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nodoUltimo = nuevoNodo;
		}
		tamanio++;
	}


	// Obtener valor de un nodo por índice

	public T obtenerValorNodo(int indice) {

		Nodo<T> nodoTemporal = null;
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


	// Verificaciones

	private boolean indiceValido(int indice) {
		if (indice >= 0 && indice < tamanio) return true;
		throw new RuntimeException("Índice no válido");
	}

	public boolean estaVacia() {
		return nodoPrimero == null;
	}


	// Imprimir lista

	public void imprimirLista() {

		if (estaVacia()) {
			System.out.println("Lista vacía");
			return;
		}


		Nodo<T> aux = nodoPrimero;
		for (int i = 0; i < tamanio; i++) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getSiguienteNodo();
		}
		System.out.println();
	}


	// Eliminar por valor

	public T eliminar(T dato) {

		if (estaVacia()) throw new RuntimeException("Lista vacía");

		Nodo<T> nodo    = nodoPrimero;
		Nodo<T> previo  = nodoUltimo;
		boolean encontrado = false;

		for (int i = 0; i < tamanio; i++) {
			if (nodo.getValorNodo().equals(dato)) {
				encontrado = true;
				break;
			}
			previo = nodo;
			nodo   = nodo.getSiguienteNodo();
		}

		if (!encontrado) throw new RuntimeException("El elemento no existe");

		if (tamanio == 1) {
			// único elemento
			nodoPrimero = nodoUltimo = null;
		} else if (nodo == nodoPrimero) {
			// eliminar el primero
			nodoPrimero = nodoPrimero.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		} else if (nodo == nodoUltimo) {
			// eliminar el último
			nodoUltimo = previo;
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		} else {
			// eliminar del medio
			previo.setSiguienteNodo(nodo.getSiguienteNodo());
		}

		tamanio--;
		return dato;
	}


	// Eliminar primero

	public T eliminarPrimero() {

		if (estaVacia()) throw new RuntimeException("Lista vacía");

		T valor = nodoPrimero.getValorNodo();

		if (tamanio == 1) {
			nodoPrimero = nodoUltimo = null;
		} else {
			nodoPrimero = nodoPrimero.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		}

		tamanio--;
		return valor;
	}


	// Eliminar último

	public T eliminarUltimo() {

		if (estaVacia()) throw new RuntimeException("Lista vacía");

		T valor = nodoUltimo.getValorNodo();

		if (tamanio == 1) {
			nodoPrimero = nodoUltimo = null;
		} else {

			Nodo<T> penultimo = obtenerNodo(tamanio - 2);
			penultimo.setSiguienteNodo(nodoPrimero);
			nodoUltimo = penultimo;
		}

		tamanio--;
		return valor;
	}


	// Obtener nodo interno por índice

	private Nodo<T> obtenerNodo(int indice) {

		if (indice >= 0 && indice < tamanio) {
			Nodo<T> nodo = nodoPrimero;
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}
			return nodo;
		}
		return null;
	}

	// Modificar nodo

	public void modificarNodo(int indice, T nuevo) {
		if (indiceValido(indice)) {
			obtenerNodo(indice).setValorNodo(nuevo);
		}
	}


	// Buscar posición de un dato

	public int obtenerPosicionNodo(T dato) {

		Nodo<T> aux = nodoPrimero;
		for (int i = 0; i < tamanio; i++) {
			if (aux.getValorNodo().equals(dato)) return i;
			aux = aux.getSiguienteNodo();
		}
		return -1;
	}

	// Obtener el siguiente nodo

	public T siguiente(T datoActual) {
		Nodo<T> aux = nodoPrimero;

		for (int i = 0; i < tamanio; i++) {
			if (aux.getValorNodo().equals(datoActual)) {
				return aux.getSiguienteNodo().getValorNodo();
			}
			aux = aux.getSiguienteNodo();
		}

		throw new RuntimeException("No se encuentra el dato");
	}

	// Iterador

	@Override
	public Iterator<T> iterator() {
		return new IteradorListaSimple(nodoPrimero);
	}

	protected class IteradorListaSimple implements Iterator<T> {

		private Nodo<T> nodo;
		private int posicion;

		public IteradorListaSimple(Nodo<T> nodo) {
			this.nodo    = nodo;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {
			return posicion < tamanio;
		}

		@Override
		public T next() {
			T valor = nodo.getValorNodo();
			nodo     = nodo.getSiguienteNodo();
			posicion++;
			return valor;
		}

		public int getPosicion() {
			return posicion;
		}
	}

	// Getters y Setters

	public Nodo<T> getNodoPrimero() { return nodoPrimero; }
	public void setNodoPrimero(Nodo<T> nodoPrimero) { this.nodoPrimero = nodoPrimero; }
	public int getTamanio() { return tamanio; }
	public void setTamanio(int tamano) { this.tamanio = tamano; }
}