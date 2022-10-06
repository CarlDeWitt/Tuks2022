public class OptimisticGallery<T> extends Thread {
    private Node head;

    OptimisticGallery() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    public boolean add(T item, int accesTime) {
        int key = item.hashCode();
        while (true) {
            Node pred = head;
            Node curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            curr.lock();
            try {
                if (validate(pred, curr)) {
                    if (key == curr.key) { // duplicates not allowed
                        return false;
                    } else { // try to add new node
                        Node node = new Node(item);
                        node.time = accesTime;
                        node.next = curr;
                        pred.next = node;
                        return true;
                    }
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        }
    }

    private boolean validate(Node pred, Node curr) {
        return false;
    }

    public boolean remove(T item, String name) {
        String s = item + name;
        int key = s.hashCode();
        while (true) {
            Node pred = head, curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            curr.lock();
            try {
                if (validate(pred, curr)) {
                    pred.next = curr.next;
                    System.out.print(Thread.currentThread().getName() + ":");
                    Node it = curr;
                    while (it != null) {
                        System.out.print("\u001B[32m(P-" + item + ", " + it.time + "ms)\u001B[0m");
                        it = it.next;
                    }
                    System.out.println();
                    return true;
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        }
    }
}
