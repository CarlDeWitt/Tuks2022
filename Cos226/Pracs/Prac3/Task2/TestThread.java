public class TestThread extends Thread {
    static TAS_lock tas;
    static TATAS_lock tatas;
    static EB_lock eb;

    int lock;
    int i = 0;

    public TestThread(TAS_lock tas, TATAS_lock tatas, EB_lock eb, int lock) {
        this.tas = tas;
        this.tatas = tatas;
        this.eb = eb;
        this.lock = lock;
    }

    volatile int count = 0;

    public void run() {
        for (int m = 0; m < 5; m++) {

            if (lock == 0) {

                tas.lock();
                try {
                    // System.out.println("here");
                } finally {
                    tas.unlock();
                }
                try {
                    Thread.sleep(randomnum(100, 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (lock == 1) {
                tatas.lock();
                try {

                } finally {
                    tatas.unlock();
                }
                try {
                    Thread.sleep(randomnum(100, 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (lock == 2) {
                eb.lock();
                try {
                } finally {
                    eb.unlock();
                }
                try {
                    Thread.sleep(randomnum(100, 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int randomnum(int max, int min) {
        double i = Math.random() * (max - min) + min;
        return (int) i;
    }
}
