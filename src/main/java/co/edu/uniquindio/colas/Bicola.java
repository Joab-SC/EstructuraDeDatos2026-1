package co.edu.uniquindio.colas;

public class Bicola<T> extends Cola<T>{
	
	public Bicola() 
	{
		
	}
	
	// inserta por el final de la Bicola
	public void ponerFinal(T dato)
	{
		encolar(dato); // m�todo heredado de ColaLista
	}
	
	// inserta por el frente; m�todo propio de Bicola
	public void ponerFrente(T dato)
	{
		Nodo<T> nuevoNodo;
		nuevoNodo = new Nodo<T>(dato);
		if (estaVacia())
		{
			nodoUltimo = nuevoNodo;
		}
		nuevoNodo.setSiguienteNodo(nodoPrimero);
		nodoPrimero = nuevoNodo;
	}
	
	
	// retira elemento frente de la Bicola
	public T quitarFrente() 
	{
		T valor = desencolar();
		return valor; // m�todo heredado de ColaLista
	}
	
	// retira elemento final; m�todo propio de Bicola.
	// Es necesario recorrer la bicola para situarse en
	// el nodo anterior al final, para despu�s enlazar.
	public T quitarFinal() throws Exception
	{
		T aux;
		if (!estaVacia())
		{
			if (nodoPrimero == nodoUltimo) // la Bicola dispone de un solo nodo
				aux = desencolar();
			else
			{
				Nodo<T> nodo = nodoPrimero;
				while (nodo.getSiguienteNodo() != nodoUltimo)
					nodo = nodo.getSiguienteNodo();
				
				// siguiente del nodo anterior se pone a null
				nodo.setSiguienteNodo(null);
				aux = nodoPrimero.getValorNodo();
				nodoUltimo = nodo;
			}
		}
		else
			throw new Exception("Eliminar de una bicola vac�a");
		return aux;
	}
	

}
