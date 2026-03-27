package co.edu.uniquindio.myStruct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {

    private Node<T> nextNode;
    private T info;

    public Node(T info) {
        this.nextNode = null;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nextNode=" + nextNode +
                ", info=" + info +
                '}';
    }
}
