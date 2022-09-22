import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MCSQueue implements Lock {
    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;

    public MCSQueue() {
        tail = new AtomicReference<>(null);
        myNode = new ThreadLocal<>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
    }

    @Override
    public void lock() {
        QNode n = myNode.get(); // 1
        QNode m = tail.getAndSet(n); // 1
        if (m != null) { // 2b
            n.locked = true; // 2b
            m.next = n; // 2b
            while (n.locked)
                Thread.yield(); // 2b
        } // 2a

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void unlock() {
        QNode n = myNode.get(); // 1
        n.number++;
        if (n.next == null) { // 2b
            if (tail.compareAndSet(n, null)) // 2b
                return; // 2b
            while (n.next == null)
                Thread.yield(); // 2c
        } // 2a
        n.next.locked = false; // 2a
        n.next = null; // 2a
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

    public QNode getMyNode() {
        return myNode.get();
    }

}
