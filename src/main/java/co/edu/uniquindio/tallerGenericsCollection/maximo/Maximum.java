package co.edu.uniquindio.tallerGenericsCollection.maximo;

import java.util.Collections;
import java.util.List;

public abstract class Maximum<T extends Comparable<T>> {
    public T max(List<T> list){
        return Collections.max(list, T::compareTo);
    }

    public <A extends Comparable<A>> A maxx(List<A> list){
        return Collections.max(list);
    }
}
