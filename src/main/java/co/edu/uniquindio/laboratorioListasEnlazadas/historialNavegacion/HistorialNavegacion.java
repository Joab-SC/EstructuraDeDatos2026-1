package co.edu.uniquindio.laboratorioListasEnlazadas.historialNavegacion;

import co.edu.uniquindio.laboratorioListasEnlazadas.structures.ListaDoble;

public class HistorialNavegacion {
    private ListaDoble<Pagina> historial;
    private Pagina paginaActual;

    public HistorialNavegacion(){
        this.historial = new ListaDoble<>();
        paginaActual = null;
    }

    public void agregarPagina(Pagina pagina){
        if(paginaActual == null){
            paginaActual = pagina;
            historial.agregarfinal(pagina);
        }
        else{
            historial.eliminarDespuesDe(paginaActual);
            historial.agregarfinal(pagina);
            paginaActual = pagina;
        }
    }

    public Pagina obtenerPaginaActual(){
        return paginaActual;
    }

    public Pagina avanzarPagina(){
        if(paginaActual == null){
            throw new RuntimeException("No hay página actual");
        }
        Pagina siguiente = historial.obtenerSiguiente(paginaActual);
        if(siguiente == null){
            throw new RuntimeException("No hay siguiente página");
        }
        paginaActual = siguiente;
        return paginaActual;
    }

    public Pagina retrocederPagina(){
        if(paginaActual == null){
            throw new RuntimeException("No hay página actual");
        }
        Pagina anterior = historial.obtenerAnterior(paginaActual);
        if(anterior == null){
            throw new RuntimeException("No hay página anterior");
        }
        paginaActual = anterior;
        return paginaActual;
    }







}
