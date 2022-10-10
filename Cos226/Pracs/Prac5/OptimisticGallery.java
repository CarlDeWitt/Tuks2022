public class OptimisticGallery<T> extends Thread {
    private Node head;

    OptimisticGallery() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    public boolean add(int i, T name, int accesTime) {
        int key = name.hashCode();
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
                        Node node = new Node(name);
                        node.time = accesTime;
                        node.number = i;
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
        Node node = head;
        while (node.key <= pred.key) {
            if (node == pred) {
                return pred.next == curr;
            }
            node = node.next;
        }
        return false;
    }

    private boolean contains(T item) {
        int key = item.hashCode();
        while (true) {
            Node pred = this.head; // sentinel node;
            Node curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            curr.lock();
            try {
                if (validate(pred, curr)) {
                    return (curr.key == key);
                }
            } finally { // always unlock
                pred.unlock();
                curr.unlock();
            }
        }
    }

    public boolean remove(String name) {
        int key = name.hashCode();
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
                    return true;
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        }
    }

    public void print() {
        Node itHead = head.next;
        itHead.lock();
        try {
            Node it = itHead;
            System.out.print(Thread.currentThread().getName() + ":");
            while (it != null) {
                System.out.print("\u001B[32m(P-" + it.number + ", " + it.time + "ms)\u001B[0m");
                it = it.next;
            }
        } finally {
            itHead.unlock();
        }
        System.out.println();
    }
}
