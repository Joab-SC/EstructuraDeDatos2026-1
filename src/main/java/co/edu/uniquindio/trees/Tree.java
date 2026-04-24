package co.edu.uniquindio.trees;

import java.util.LinkedList;

public class Tree<T extends Comparable<T>> {

    private NodeTree<T> root;
    private int weight;
    public Tree() {
        root = null;
        weight = 0;
    }

    public void inOrden(NodeTree<T> nodoRaiz){
        if (nodoRaiz == null){
            return;
        }
        inOrden(nodoRaiz.getLeftChild());
        System.out.println(nodoRaiz.getInfo());
        inOrden(nodoRaiz.getRightChild());
    }

    public void preOrden(NodeTree<T> nodoRaiz){
        if (nodoRaiz == null){
            return;
        }
        System.out.println(nodoRaiz.getInfo());
        preOrden(nodoRaiz.getLeftChild());
        preOrden(nodoRaiz.getRightChild());
    }

    public void postOrden(NodeTree<T> nodoRaiz){
        if (nodoRaiz == null){
            return;
        }
        postOrden(nodoRaiz.getLeftChild());
        postOrden(nodoRaiz.getRightChild());
        System.out.println(nodoRaiz.getInfo());
    }

    public void amplitud(){
        LinkedList<NodeTree<T>> lista = new LinkedList<>();
        lista.add(root);
        amplitud(lista);
    }

    private void amplitud(LinkedList<NodeTree<T>> parents){
        if (parents.isEmpty()){
            return;
        }
        LinkedList<NodeTree<T>> children = new LinkedList<>();
        while (!parents.isEmpty()){
            NodeTree<T> aux = parents.removeFirst();
            System.out.println(aux.getInfo());
            children.add(aux.getLeftChild());
            children.add(aux.getRightChild());
        }
        amplitud(children);
    }

    public boolean search(NodeTree<T> raiz, T elemento){
        if  (raiz.getInfo() == elemento){
            return true;
        }else {
            if  (raiz.getInfo().compareTo(elemento) < 0){
                return search(raiz.getRightChild(), elemento);
            }else{
                return search(raiz.getLeftChild(), elemento);
            }
        }
    }

    public void add(NodeTree<T> dad, NodeTree<T> child, T info){

        if(weight == 0){
            root = new NodeTree<>(info);
        }
        if(child == null){
            if (dad.getInfo().compareTo(info) > 0) {
                dad.setLeftChild(new NodeTree<>(info));
            }
            else{
                dad.setRightChild(new NodeTree<>(info));
            }
        }

        if(info.compareTo(child.getInfo()) > 0){
            add(child, child.getRightChild(), info);
        }
        else{
           add(child, child.getLeftChild(), info);
        }
    }


}

