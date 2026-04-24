package co.edu.uniquindio.trees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeTree<T> {

    private NodeTree<T> leftChild;
    private NodeTree<T> rightChild;
    private T info;

    public NodeTree(T info) {
        this.leftChild = null;
        this.rightChild = null;
        this.info = info;
    }
}
