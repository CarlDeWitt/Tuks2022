import java.util.concurrent.locks.ReentrantLock;

public class Node<T> {
    ReentrantLock lock = new ReentrantLock();
    T item;
    Node<T> next;
    int key;
    int time;

    public Node(T item) {
        this.item = item;
        key = item.hashCode();
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
