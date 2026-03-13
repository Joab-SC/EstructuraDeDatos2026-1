package co.edu.uniquindio.tallerGenericsCollection.repositorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository<T> implements Iterable<T>{
    private List<T> list;

    public Repository(){
        this.list = new ArrayList<>();
    }

    public void add(T element){

        list.add(element);
    }

    public T get(int index){
        return list.get(index);

    }

    @Override
    public Iterator<T>  iterator(){
        return new Iterator<T>(){
            int pointer = list.size() - 1;
            @Override
            public boolean hasNext(){
                return pointer >= 0;
            }

            @Override
            public T next(){
                T actual = list.get(pointer);
                pointer --;
                return actual;
            }

        };
    }




}
