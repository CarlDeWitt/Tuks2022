public class Main2 {
    public static void main(String args[]) {
        EB_lock eb = new EB_lock();
        TAS_lock tas = new TAS_lock();
        TATAS_lock tatas = new TATAS_lock();
        /**
         * numThreads = Enter the number of threads you want to run.
         * numLock = the lock you want to acquire. 0 for TAS, 1 for TATAS, 2 for EB.
         */
        int numThreads = 50;
        int numLock = 0;
        for (int i = 0; i < numThreads; i++) {
            TestThread t = new TestThread(tas, tatas, eb, numLock);
            t.start();
        }

    }
}
