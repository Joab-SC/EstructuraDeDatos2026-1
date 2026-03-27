package co.edu.uniquindio.myStruct.myLinkedList;
import co.edu.uniquindio.myStruct.Node;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

    private int size;
    private Node<T> firstnode;

    public MyLinkedList() {
        this.size = 0;
        this.firstnode = null;
    }

    public boolean validIndex(int index){
        return index < size;
    }

    public T get(int index){
        return getNode(index).getInfo();
    }


    public int getIndex(T data){
        Node<T> nodeAux = firstnode;
        int indexCounter = 0;
        while (nodeAux.getInfo() != data){
            if(nodeAux.getNextNode() == null){
                return -1;
            }
            nodeAux = nodeAux.getNextNode();
            indexCounter++;
        }
        return indexCounter;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            firstnode = newNode;
        }else{
            newNode.setNextNode(firstnode);
            firstnode = newNode;
        }

        size++;
    }

    public void addLast(T data){
        Node <T> node = new Node<>(data);
        if(isEmpty()){
            firstnode = node;
        }else{
            Node<T> nodeAux = firstnode;
            while (nodeAux.getNextNode() != null){
                nodeAux = nodeAux.getNextNode();
            }
            nodeAux.setNextNode(node);
        }
        size ++;
    }

    public void add(T data, int index){
        Node<T> newNode =  new Node<>(data);
        if(index > size){
            throw new RuntimeException();
        }
        if(index == size){
            addLast(data);
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        Node<T> nodeAux = firstnode;
        int indexCounter = 0;
        while(indexCounter < index -1){
            nodeAux = nodeAux.getNextNode();
            indexCounter++;
        }
        newNode.setNextNode(nodeAux.getNextNode());
        nodeAux.setNextNode(newNode);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    public void removeFirst(){
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }else{
            Node<T> aux = firstnode.getNextNode();
            firstnode.setNextNode(null); //Opcional, para ayudar el garbage
            firstnode = aux;
            size --;
        }
    }

    public void removeLast(){
        if(isEmpty()){
            throw new RuntimeException("La lista ya esta vacia");
        }else{
            Node<T> nodeAux = firstnode;
            while (nodeAux.getNextNode().getNextNode() != null){
                nodeAux = nodeAux.getNextNode();
            }
            nodeAux.setNextNode(null);
        }
        size --;
    }

    public void print(){

    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        int counter = 0;
        Node<T> aux = firstnode;
        while(counter != index -1){
            aux = aux.getNextNode();
            counter++;
        }
        Node<T> temRemove = aux.getNextNode();
        aux.setNextNode(temRemove.getNextNode());
        temRemove.setNextNode(null);


    }

    public void modify(int index, T newValue){
        getNode(index).setInfo(newValue);
    }

    private Node<T> getNode(int index){
        if(!validIndex(index)){
            throw new RuntimeException();
        }
        Node<T> nodeAux = firstnode;
        int indexCounter = 0;
        while (indexCounter < index){
            nodeAux = nodeAux.getNextNode();
            indexCounter++;
        }
        return nodeAux;
    }

    public void reverse(){
        reverse(null, firstnode);
    }


    public void reverse(Node<T> currrent, Node<T> next){
        if(next == null){
            firstnode = currrent;
            return;
        }
        reverse(next, next.getNextNode());
        next.setNextNode(currrent);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> nodeAux = firstnode;
            @Override
            public boolean hasNext() {
                return nodeAux != null;
            }

            @Override
            public T next() {
                T elem = nodeAux.getInfo();
                nodeAux = nodeAux.getNextNode();
                return elem;
            }
        };
    }
}
