import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

class Queue<T> {
    Condition notEmptyCondition, notFullCondition;
    AtomicInteger size;
    AtomicInteger head, tail;
    int capacity;
    String[] queue;

    public Queue(int _capacity) {
        capacity = _capacity;
        head = new AtomicInteger(0);
        tail = new AtomicInteger(0);
        queue = new String[capacity];
        size = new AtomicInteger(0);
    }

    public void enq(String x) throws InterruptedException {
        int last;
        int next;

        while (true) {
            while (size.get() == capacity) {
                System.out.print("Queue is full, waiting...");
            }
            // get last of tail
            last = tail.get();
            // get next of tail
            next = (last + 1);
            // // System.out.println("After****");
            // for (int i = 0; i < capacity; i++) {
            // System.out.println("index: " + i + " =" + queue[i]);
            // }
            // System.out.println("size is: " + size.get());
            // System.out.println("tail is at: " + tail);
            // System.out.println("------------------------------");
            // is still pointing to last
            if (last == tail.get()) {
                // add x to queue

                if (next >= capacity) {
                    next = capacity - 1;
                    // System.out.println("Value of next is " + next + " and capacity is " +
                    // capacity);
                }
                if (queue[next] == null) {
                    // System.out.println("Value of next is " + (last + 1));
                    // if (last + 1 >= capacity) {
                    // last = capacity - 1;
                    // }
                    if (queue[(last + 1) % capacity] == queue[next]) {
                        queue[(last + 1) % capacity] = x;
                        tail.getAndIncrement();
                        size.getAndIncrement();
                        System.out.println("\033[0;31m" + x + " is ordering food \033[0m");
                        break;
                    }
                }
            }
        }
    }

    public void deq() throws InterruptedException {
        while (true) {
            while (size.get() == 0) {
            }
            int first = head.get();
            int last = tail.get();
            int next = (first + 1);
            if (first == head.get()) {
                if (first == last) {
                    if (queue[next] == null) {

                    }
                    if (tail.get() == last) {
                        tail.set(next);
                    }
                } else {
                    if (first == head.get()) {

                        T result = (T) queue[first];
                        String[] newq = new String[capacity];
                        for (int i = 1; i < capacity; i++) {
                            newq[i - 1] = queue[i];
                        }
                        queue = newq;
                        // System.out.println("After****");
                        // for (int i = 0; i < capacity; i++) {
                        // System.out.println("index: " + i + " =" + queue[i]);
                        // }
                        // System.out.println("size is: " + size.get());
                        // System.out.println("tail is at: " + tail);
                        // System.out.println("------------------------------");
                        tail.getAndDecrement();
                        size.getAndDecrement();
                        System.out.println("\033[0;35m" + result + " is leaving with food \033[0m");
                        return;
                    }

                }
            }

        }
    }
}
