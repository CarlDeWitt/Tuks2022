import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* i cant use the implemets lock if these librarys are not included i did not use 2 of them they are only
in here otherwise it did not want to compile
 */

class PetersonLock implements Lock {
    boolean flag[] = new boolean[2];
    int victim;

    @Override
    public void lock() {
        String name= Thread.currentThread().getName();
        int i = Integer.parseInt(name.substring(name.length() -1));
        int j = 1 - i;
        flag[i] = true;
        victim = i;
        while (flag[j] && victim == i) {
            System.out.print("");
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
        String name= Thread.currentThread().getName();
        flag[Integer.parseInt(name.substring(name.length() -1))] = false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
