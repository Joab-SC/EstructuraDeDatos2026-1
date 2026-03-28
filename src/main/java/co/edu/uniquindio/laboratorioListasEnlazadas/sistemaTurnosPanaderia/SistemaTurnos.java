package co.edu.uniquindio.laboratorioListasEnlazadas.sistemaTurnosPanaderia;

import co.edu.uniquindio.laboratorioListasEnlazadas.structures.ListaSimple;

public class SistemaTurnos {

    private ListaSimple<Cliente> clientes;

    public SistemaTurnos() {
        this.clientes = new ListaSimple<>();
    }

    public void agregarCliente(Cliente cliente){
        clientes.agregarfinal(cliente);
    }

    public Cliente atenderCliente(Cliente cliente){
        return clientes.eliminarPrimero();
    }

    public Cliente clientePorAtender(){
        return clientes.obtenerValorNodo(0);
    }

    public void mostrarLista(){
        clientes.imprimirLista();
    }

}
