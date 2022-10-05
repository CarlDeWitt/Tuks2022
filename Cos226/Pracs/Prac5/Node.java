public class Node<T> {
    T item;
    Node<T> next;
    int key;
    int time;

    public Node(T item) {
        this.item = item;
        key = item.hashCode();
    }
}
