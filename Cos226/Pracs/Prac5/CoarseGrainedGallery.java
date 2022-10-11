import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoarseGrainedGallery<T> extends Thread {

    private Node head;
    private Lock lock = new ReentrantLock();

    CoarseGrainedGallery() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    public boolean add(int i, String name, int accesTime) {
        Node pred, curr;
        int key = name.hashCode();
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
                Node node = new Node(name);
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

    public boolean remove(String name) {
        Node pred, curr;
        int key = name.hashCode();
        lock.lock();
        try {
            pred = head;
            curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
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

    public void print() {
        lock.lock();
        try {

            Node it = head.next;
            System.out.print(Thread.currentThread().getName() + ":");
            while (it != null) {
                System.out.print("\u001B[32m(P-" + it.number + ", " + it.time + "ms)\u001B[0m");
                it = it.next;
            }
        } finally {
            lock.unlock();
        }
        System.out.println();
    }

}
