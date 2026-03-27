package co.edu.uniquindio.myStruct.myLinkedList;


import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;
    private int size;


    public MyDoubleLinkedList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    private void addUnique(T info){
            DoubleNode<T> node = new DoubleNode<>(info);
            firstNode = node;
            lastNode = node;
            size++;
    }

    public void addFirst(T info){
        if(size == 0){
            addUnique(info);
            return;
        }
        DoubleNode<T> node = new DoubleNode<>(info);
        node.setNextNode(firstNode);
        firstNode.setPreviousNode(node);
        firstNode = node;
        size++;
    }

    public void addLast(T info){
        if(size == 0){
            addUnique(info);
            return;
        }
        DoubleNode<T> node = new DoubleNode<>(info);
        node.setPreviousNode(lastNode);
        lastNode.setNextNode(node);
        lastNode = node;
        size++;
    }

    public void add(int index, T info){
        if(size == 0){
            addUnique(info);
            return;
        }
        else if(index == 0){
            addFirst(info);
        }
        else if(index == size){
            addLast(info);
        }
        else{
            DoubleNode<T> nodePos = findNode(index);
            DoubleNode<T> node = new DoubleNode<>(info);
            node.setNextNode(nodePos);
            node.setPreviousNode(nodePos.getPreviousNode());
            nodePos.getPreviousNode().setNextNode(node);
            nodePos.setPreviousNode(node);
            size ++;
        }

    }

    private boolean validIndex(int i){
        return i >= 0 && i<size;

    }
    public DoubleNode<T> findNode(int i){
        if(!validIndex(i)){
            throw new RuntimeException();
        }
        DoubleNode<T> node;
        if(i < size/2){
            node = firstNode;
            int auxIndex = 0;
            while(auxIndex < i){
                auxIndex ++;
                node = node.getNextNode();
            }
        }

        else{
            node = lastNode;
            int auxIndex = size - 1;
            while(auxIndex > i){
                auxIndex --;
                node = node.getPreviousNode();
            }
        }
        return node;
    }

    public void removeLast(){
        if(size == 0)
        lastNode.getPreviousNode().setNextNode(null);
        lastNode.setPreviousNode(null);
        lastNode = null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}