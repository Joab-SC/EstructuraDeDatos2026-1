package co.edu.uniquindio.tallerGenericsCollection.pairList;

import java.util.ArrayList;

public class PairList <T extends Pair<K,V>, K, V> {

    private ArrayList<T> pairs;
    public PairList(){
        pairs = new ArrayList<>();
    }
    public void agregarPar(T pair){
        pairs.add(pair);
    }
    public void eliminarPar(K key){
        pairs.removeIf(par -> par.getKey().equals(key));
    }
    public ArrayList<T> obtenerPares(){
        return pairs;
    }
}
