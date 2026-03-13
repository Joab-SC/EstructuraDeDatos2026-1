package co.edu.uniquindio.tallerGenericsCollection.comparador;
@FunctionalInterface
public interface  MyComparator<T> {
    public int compareTo(T o1, T o2);
}
