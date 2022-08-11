import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class bakeryT implements Lock {
    volatile boolean[] flag;
    volatile int[] label;
    int size;
    int ofset;

    public bakeryT(int n,int m) {
        size = n;
        ofset = m;
        flag = new boolean[size];
        label = new int[size];
        for (int i = 0; i < size; i++) {
            flag[i] = false;
            label[i] = 0;
        }
    }

    private int max() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (label[i] > max) {
                max = label[i];
            }
        }
        return max;
    }

    @Override
    public void lock() {
        String s = Thread.currentThread().getName();
        int i = Integer.parseInt(s.substring(s.indexOf('-') + 1)) - ofset;
        flag[i] = true;
        label[i] = max() + 1;
		/*
		for loop goes through every level to check if there is a thread in a higher level than the current thread
		 this while loop will run through untill a the flag[i] that was raised is the samllest label
		*/
        for (int k = 0; k < size; k++) {
            while (flag[k] && ((label[k] < label[i]) || ((label[k] == label[i]) && k < i))) {
//                System.out.print("locking");
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        String s = Thread.currentThread().getName();
        int i = Integer.parseInt(s.substring(s.indexOf('-') + 1)) - ofset;
        flag[i] = false;
        label[i] = 0;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

