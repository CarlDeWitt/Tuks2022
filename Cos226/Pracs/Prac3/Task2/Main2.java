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

        int[] numthreadsarray = { 1, 2, 3, 4, 7, 10, 14, 19, 25, 35 };

        System.out.print("Numbers of threads: [");
        for (int i = 0; i < numthreadsarray.length; i++) {
            if (i + 1 == numthreadsarray.length) {
                System.out.println(numthreadsarray[i] + "]");
            } else {
                System.out.print(numthreadsarray[i] + ", ");
            }
        }
        int numruns = numthreadsarray.length;

        int outercount = 0;
        // System.out.print("TAS Lock: [");
        System.out.print("[");
        for (int m = 0; m < numruns; m++) {
            int i = 0;
            long startTime = System.nanoTime();
            while (i < numthreadsarray[m]) {
                TestThread t = new TestThread(tas, tatas, eb, 0);
                t.start();
                i++;
                // System.out.println(i);
            }
            long elapsedTime = System.nanoTime() - startTime;
            if (m + 1 == numruns) {
                System.out.println(elapsedTime + "] time in nanoseconds");
            } else {
                System.out.print(elapsedTime + ", ");
            }
        }

        // System.out.print("TATAS Lock: [");
        System.out.print("[");
        for (int m = 0; m < numruns; m++) {
            int i = 0;
            long startTime = System.nanoTime();
            while (i < numthreadsarray[m]) {
                TestThread t = new TestThread(tas, tatas, eb, 1);
                t.start();
                i++;
                // System.out.println(i);
            }
            long elapsedTime = System.nanoTime() - startTime;
            if (m + 1 == numruns) {
                System.out.println(elapsedTime + "] time in nanoseconds");
            } else {
                System.out.print(elapsedTime + ", ");
            }
        }

        // System.out.print("Backoff Lock: [");
        System.out.print("[");
        for (int m = 0; m < numruns; m++) {
            int i = 0;
            long startTime = System.nanoTime();
            while (i < numthreadsarray[m]) {
                TestThread t = new TestThread(tas, tatas, eb, 1);
                t.start();
                i++;
                // System.out.println(i);
            }
            long elapsedTime = System.nanoTime() - startTime;
            if (m + 1 == numruns) {
                System.out.println(elapsedTime + "] time in nanoseconds");
            } else {
                System.out.print(elapsedTime + ", ");
            }
        }

    }
}
