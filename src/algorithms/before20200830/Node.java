package algorithms.before20200830;

public class Node<T> {
    private T element;

    private Node next;

    public Node(T element) {
        this.element = element;
    }

    public Node(T element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node() {
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
