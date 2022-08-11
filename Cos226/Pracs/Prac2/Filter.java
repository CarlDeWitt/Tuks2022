import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Carl de Witt
// Student Number: u21444928

public class Filter implements Lock
{
	int size;
	int[] victim;
	int[] level;

	public Filter(int n){
		size = n;
		level = new int[size];
		victim = new int[size];
		for(int i=0;i < size; i++){
			level[i]=Integer.MAX_VALUE;
		}
	}

	@Override
	public void lock() {
		String s = Thread.currentThread().getName();
		int i = Integer.parseInt(s.substring(s.length()-1));
//		i = i +1;
//		System.out.println(s);
		for( int L =1; L < size; L++){
			level[i] = L;
			victim[L] = i;
			for (int k = 0; k < size; k++) {
				while ((k != i) && (level[k] >= L && victim[L] == i)) {
					System.out.print("");
				}
			}
		}
	}

	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
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
//		i = i +1;
		level[i] = -1;
		victim[i] = -1;
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

}
