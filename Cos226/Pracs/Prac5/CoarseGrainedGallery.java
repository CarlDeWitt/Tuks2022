import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoarseGrainedGallery<T> extends Thread {

    private Node head;
    private Lock lock = new ReentrantLock();

    CoarseGrainedGallery() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    public boolean add(int i, T item, int accesTime) {
        Node pred, curr;
        String s = i + item.toString();
        int key = s.hashCode();
        lock.lock();
        try {
            pred = head;
            curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            if (key == curr.key) { // duplicates not allowed
                return false;
            } else { // try to add new node
                Node node = new Node(item);
                node.time = accesTime;
                node.number = i;
                node.next = curr;
                pred.next = node;
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T item, String name) {
        Node pred, curr;
        String s = item + name;
        int key = s.hashCode();
        lock.lock();
        try {

            pred = head;
            curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            System.out.print(Thread.currentThread().getName() + ":");
            Node it = curr;
            while (it != null) {
                System.out.print("\u001B[32m(P-" + it.number + ", " + it.time + "ms)\u001B[0m");
                it = it.next;
            }
            System.out.println();
            if (key == curr.key) {
                pred.next = curr.next;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

}
