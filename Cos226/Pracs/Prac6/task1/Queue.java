import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Queue<T> {
    ReentrantLock enqLock, deqLock;
    Condition notEmptyCondition, notFullCondition;
    AtomicInteger size;
    volatile int head, tail;
    int capacity;
    String[] queue;

    public Queue(int _capacity) {
        capacity = _capacity;
        head = 0;
        tail = 0;
        queue = new String[capacity];
        size = new AtomicInteger(0);
        enqLock = new ReentrantLock();
        notFullCondition = enqLock.newCondition();
        deqLock = new ReentrantLock();
        notEmptyCondition = deqLock.newCondition();
    }

    public void enq(T x) throws InterruptedException {
        boolean mustWakeDequeuers = false;
        enqLock.lock();
        try {
            while (size.get() == capacity)
                notFullCondition.await();

            queue[tail++] = (String) x;

            System.out.println("\033[0;31m" + x + " is ordering food \033[0m");

            if (size.getAndIncrement() == 0)
                mustWakeDequeuers = true;
        } finally {
            enqLock.unlock();
        }
        if (mustWakeDequeuers) {
            deqLock.lock();
            try {
                notEmptyCondition.signalAll();
            } finally {
                deqLock.unlock();
            }
        }
    }

    public void deq() throws InterruptedException {
        T result;
        boolean mustWakeEnqueuers = false;
        deqLock.lock();
        try {
            while (size.get() == 0)
                notEmptyCondition.await();

            result = (T) queue[head];

            String[] newq = new String[capacity];
            for (int i = 1; i < capacity; i++) {
                newq[i - 1] = queue[i];
            }

            queue = newq;
            tail--;

            System.out.println("\033[0;35m" + result + " is leaving with food \033[0m");

            if (size.getAndDecrement() == capacity) {
                mustWakeEnqueuers = true;
            }
        } finally {
            deqLock.unlock();
        }
        if (mustWakeEnqueuers) {
            enqLock.lock();
            try {
                notFullCondition.signalAll();
            } finally {
                enqLock.unlock();
            }
        }
    }

}