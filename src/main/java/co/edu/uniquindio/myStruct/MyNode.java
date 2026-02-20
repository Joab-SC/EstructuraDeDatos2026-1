package co.edu.uniquindio.myStruct;


public class MyNode<T> {
    private T element;
    private int hashcode;
    private MyNode<T> next;
    private MyNode<T> previous;

    public MyNode(T element, MyNode<T> previous){
        this.next = null;
        this.element = element;
        this.hashcode = element.hashCode();
        this.previous = previous;
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
