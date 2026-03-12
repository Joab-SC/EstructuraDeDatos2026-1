package co.edu.uniquindio.tallerGenericsCollection.tareas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaTareas<T extends Tarea> {
    private ArrayList<T> listaTareas;

    public ListaTareas(){
        this.listaTareas = new ArrayList<>();
    }
    public void agregarTarea(T tarea){
        listaTareas.add(tarea);
    }

    public void ordenarTareas(){
        listaTareas.sort(Tarea::compareTo);
    }

    public ArrayList<T> obtenerPrioridad(int prioridad){
        return listaTareas.stream().filter((t1) -> t1.getPrioridad() == prioridad).collect(Collectors.toCollection(ArrayList::new));
    }

}
