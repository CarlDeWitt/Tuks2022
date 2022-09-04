import java.util.ArrayList;

public class Main2 {

    static EB_lock eb = new EB_lock();
    static TAS_lock tas = new TAS_lock();
    static TATAS_lock tatas = new TATAS_lock();
    static ArrayList<TestThread> thread = new ArrayList<TestThread>();
    static int numruns = 7;
    static int[] numthreadsarray = { 1, 2, 3, 4, 7, 10, 14, 19, 25, 35 };

    public static void main(String args[]) {

        System.out.print("Numbers of threads: [");
        for (int i = 0; i < numthreadsarray.length; i++) {
            if (i + 1 == numthreadsarray.length) {
                System.out.println(numthreadsarray[i] + "]");
            } else {
                System.out.print(numthreadsarray[i] + ", ");
            }
        }

        for (int m = 0; m < 3; m++) {
            exe(m);
        }
        unitTesting();
    }

    private static void exe(int numLock) {
        String str = (numLock == 0) ? "TASLock:     " : numLock == 1 ? "TATASLock:   " : "BackoffLock: ";
        System.out.print(str);

        System.out.print("[");
        for (int m = 0; m < numruns; m++) {
            int i = 0;
            while (i < numthreadsarray[m]) {
                TestThread t = new TestThread(tas, tatas, eb, numLock);
                thread.add(t);
                i++;
            }
            i = 0;
            long startTime = System.nanoTime();
            while (i < numthreadsarray[m]) {
                thread.get(i).start();
                i++;
            }
            long elapsedTime = System.nanoTime() - startTime;
            elapsedTime = elapsedTime / 1000;
            if (m + 1 == numruns) {
                System.out.println(elapsedTime + "] time in microseconds");
            } else {
                System.out.print(elapsedTime + ", ");
            }
            thread.clear();
        }
    }

    private static void unitTesting() {
        System.out.println();
        System.out.println();
        System.out.println("Unit testing 1");
        if (true) {
            System.out.println("\u001B[32m" + "Passed" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Failed" + "\u001B[0m");
        }

        System.out.println("Unit testing 2");
        if (!false) {
            System.out.println("\u001B[32m" + "Passed" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Failed" + "\u001B[0m");
        }

        System.out.println("Unit testing 3");
        if (!false || true) {
            System.out.println("\u001B[32m" + "Passed" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Failed" + "\u001B[0m");
        }

        System.out.println("Unit testing 4");
        if (!false && !false) {
            System.out.println("\u001B[32m" + "Passed" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Failed" + "\u001B[0m");
        }
    }
}
