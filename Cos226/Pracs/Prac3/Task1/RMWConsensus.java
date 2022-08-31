import java.util.concurrent.atomic.AtomicInteger;

public class RMWConsensus<T> extends ConsensusProtocol<T> {
    private final int first = -1;
    private AtomicInteger r = new AtomicInteger(first);

    public RMWConsensus(int threadCount) {
        super(threadCount);
    }

    public void propose(T value) {
        String s = Thread.currentThread().getName();
        int i = Integer.parseInt(s.substring(s.indexOf('-') + 1));
        proposed[i] = value;
        System.out.println("Thread " + i + " proposed the value: R" + value);
        try {
            Thread.currentThread().sleep(randomnum(100, 50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decide() {
        String s = Thread.currentThread().getName();
        int i = Integer.parseInt(s.substring(s.indexOf('-') + 1));
        if (r.compareAndSet(first, i)) {
            System.out.println("\u001B[33mThread " + i + " Decided the value of: R" + proposed[i] + "\u001B[0m");
        } else {
            System.out.println("\u001B[34mThread " + i + " Decided the value of: R" + proposed[r.get()] + "\u001B[0m");
        }
    }

    private int randomnum(int max, int min) {
        double i = Math.random() * (max - min) + min;
        return (int) i;
    }
}
