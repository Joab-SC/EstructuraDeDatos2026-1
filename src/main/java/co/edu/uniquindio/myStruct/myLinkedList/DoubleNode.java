package co.edu.uniquindio.myStruct.myLinkedList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DoubleNode<T> {

    private DoubleNode<T> nextNode;
    private DoubleNode<T> previousNode;
    private T info;

    public DoubleNode(T info) {
        this.nextNode = null;
        this.previousNode = null;
        this.info = info;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "nextNode=" + nextNode +
                ", previousNode=" + previousNode +
                ", info=" + info +
                '}';
    }
}
