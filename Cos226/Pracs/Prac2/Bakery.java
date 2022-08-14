import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Carl de Witt
// Student Number: u21444928

public class Bakery implements Lock
{

	volatile boolean[] flag;
	volatile int[] label;
	int size;

	public Bakery(int n){
		size = n;
		flag = new boolean[size];
		label = new int[size];
		for(int i = 0; i < size; i++){
			flag[i] = false;
			label[i] = 0;
		}
	}
	@Override
	public void lock() {
		String s = Thread.currentThread().getName();
		int i = Integer.parseInt(s.substring(s.length()-1));
			flag[i] = true;
			label[i] = max() + 1;
			/*
			for loop goes through every level to check if there is a thread in a higher level than the current thread
			 this while loop will run through untill a the flag[i] that was raised is the samllest label
			*/
			for (int k = 0; k < size; k++) {
				while ( flag[k] && ((label[k] < label[i]) || ((label[k] == label[i]) && k < i))) {
				}
			}


	}

	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	private int max(){
		int max = 0;
		for (int i=0;i<size; i++) {
			if (label[i] > max) {
				max = label[i];
			}
		}
		return max;
	}

	public boolean tryLock()
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void unlock() {
		String s = Thread.currentThread().getName();
		int i = Integer.parseInt(s.substring(s.length()-1));
		flag[i] = false;
		label[i] = 0;
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

}
