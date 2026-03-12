package co.edu.uniquindio.tallerGenericsCollection.tareas;

import java.time.LocalDate;

public class Tarea implements Comparable<Tarea>{
    private String descripion;
    private int prioridad;
    private LocalDate fechaVencimiento;

    public Tarea(LocalDate fechaVencimiento, int prioridad, String descripion) {
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.descripion = descripion;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    @Override
    public int compareTo(Tarea o) {
        return fechaVencimiento.compareTo(o.getFechaVencimiento());
    }
    public int prioridadCompareTo(Tarea o) {
        return Integer.compare(prioridad, o.getPrioridad());
    }
}
