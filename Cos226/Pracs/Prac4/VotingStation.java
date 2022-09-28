import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class VotingStation {
	static MCSQueue l = null;
	static Timeout t = null;

	VotingStation(MCSQueue lock) {
		l = lock;
	}

	VotingStation(Timeout lock) {
		t = lock;
	}

	public void castBallot() throws InterruptedException {

		if (l != null) {
			for (int i = 1; i <= 5; i++) {
				l.lock();
				try {
					System.out.println(
							"[" + Thread.currentThread().getName() + "]" + "[" + i + "] entered the voting station");
					System.out.println("[" + Thread.currentThread().getName() + "]" + "[" + i + "] cast a vote");
					Thread.sleep(random(100, 200));
					printlist();
				} finally {
					l.unlock();
				}
			}
		} else {
			for (int i = 1; i <= 5; i++) {
				t.tryLock(200, TimeUnit.MILLISECONDS);
				try {
					System.out.println(
							"[" + Thread.currentThread().getName() + "]" + "[" + i + "] entered the voting station");
					System.out.println("[" + Thread.currentThread().getName() + "]" + "[" + i + "] cast a vote");
					printlistTO();
					Thread.sleep(random(100, 200));
					// error here
				} finally {
					t.unlock();
				}
			}
		}
	}

	private int random(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	private void printlistTO() {
		QNode n = t.getMyNode();
		while (n != null) {
			if (n.pred == null) {
				System.out.print("{" + n.name + ": Person " + n.number + "}");
				System.out.println();
			} else
				System.out.print("{" + n.name + ": Person " + n.number + "} -> ");

			n = n.pred;
		}
	}

	private void printlist() {
		QNode n = l.getMyNode();
		while (n != null) {
			if (n.next == null) {
				System.out.print("{" + n.name + ": Person " + n.number + "}");
				System.out.println();
			} else
				System.out.print("{" + n.name + ": Person " + n.number + "} -> ");

			n = n.next;
		}
	}
}
