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

    public void run() {
        if (lock == 0) {
            /**
             * TAS Lock
             */
            tas.lock();
            try {
                System.out.println(this.getName() + " Task: " + i++);
            } finally {
                tas.unlock();
            }

        } else if (lock == 1) {
            /**
             * TATAS Lock
             */

        } else if (lock == 2) {
            /**
             * EB Lock
             */

        }
    }
}
