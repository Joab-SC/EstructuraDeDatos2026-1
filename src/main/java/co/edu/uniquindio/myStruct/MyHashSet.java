package co.edu.uniquindio.myStruct;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHashSet<T> {
    private MyNode<T>[] arr;
    private MyNode<T>[] tempArr;
    private int capacity = 10;
    private int counter = 0;
    private int index;

    public MyHashSet(){
        this.arr = new MyNode[capacity];
    }

    public void add(T el){
        if(counter == capacity){
            capacity = capacity * 2;
            tempArr = arr;
            arr = new MyNode[capacity];
            rehash();
        }
        index = calculateIndex(el);
        if (arr[index] == null) {
            arr[index] = new MyNode<T>(el, null);
            counter +=1;
        }
        else{
            MyNode<T> current = arr[index];
            while(current.getNext() != null) {
                if(current.getElement().equals(el)){
                    return;
                }
                else{
                    current = current.getNext();
                }
            }
            if(current.getElement().equals(el)){
                return;
            }
            current.setNext(new MyNode<T>(el, current));
        }
    }

    private void rehash(){
        for(MyNode<T> node: tempArr){
            System.out.println(node);
            index = calculateIndex(node.getElement());
            arr[index] = node;
        }
    }


    private int calculateIndex(T el){
        index = el.hashCode() % capacity;
        if(index < 0){
            index += capacity; // asegura que siempre sea 0..capacity-1
        }
        return index;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;

        // recorremos cada bucket del array
        for (MyNode<T> node : arr) {
            MyNode<T> current = node;
            // recorremos la lista de nodos de este bucket
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.getElement());
                first = false;
                current = current.getNext();
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        MyHashSet<String> mihash = new MyHashSet<>();
        mihash.add("hola");
        mihash.add("Daniel");
        mihash.add("Esteban");
        mihash.add("Mac");
        mihash.add("holi");
        mihash.add("Andriu");
        mihash.add("Laura");
        mihash.add("Polilla");
        mihash.add("basi");
        mihash.add("jinner");
        mihash.add("Francy");
        mihash.add("Joanna");
        mihash.add("Daniel");

        System.out.println(mihash);
    }

}
