import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Venue {
	public void dropOff(Thread t,int count) throws InterruptedException {
//		sleep for random number of time 200 1000 ms
		System.out.println("BUS " + t.getName() + " is dropping-off: Load " + count);
		Random r = new Random();
		int num = r.nextInt(1000 - 200) + 200;
		Thread.currentThread().sleep(num);
		System.out.println( "BUS " + t.getName() + " has left: Load " + count);
	}
}
