import java.util.Random;

public class Backoff {
    int minDelay, maxDelay;
    int limit;
    final Random random;

    public Backoff(int min, int max) {
        minDelay = min;
        maxDelay = max;
        limit = min;
        random = new Random();
    }

    public void backoff() {
        int delay = random.nextInt(limit);
        limit = Math.min(2 * limit, maxDelay);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
