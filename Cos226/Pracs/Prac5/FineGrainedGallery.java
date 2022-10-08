public class FineGrainedGallery<T> extends Thread {
    private Node head;

    FineGrainedGallery() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    public boolean add(int i, T item, int accesTime) {
        String s = i + item.toString();
        int key = s.hashCode();
        head.lock();
        Node pred = head;
        try {
            Node curr = pred.next;
            curr.lock();
            try {
                while (curr.key < key) {
                    pred.unlock();
                    pred = curr;
                    curr = curr.next;
                    curr.lock();
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
                curr.unlock();
            }
        } finally {
            pred.unlock();
        }
    }

    public boolean remove(T item, String name) {
        Node pred = null, curr = null;
        String s = item + name;
        int key = s.hashCode();
        head.lock();
        try {
            pred = head;
            curr = pred.next;
            curr.lock();
            try {
                while (curr.key < key) {
                    pred.unlock();
                    pred = curr;
                    curr = curr.next;
                    curr.lock();
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
                curr.unlock();
            }
        } finally {
            pred.unlock();
        }
    }
}
