public class ConsensusThread extends Thread {
	private Consensus<Integer> consensus;

	ConsensusThread(Consensus<Integer> consensusObject) {
		consensus = consensusObject;
	}

	public synchronized void run() {
		for (int i = 0; i < 5; i++) {

			consensus.propose(randomnum(200, 100));
			consensus.decide();
			try {
				Thread.currentThread().sleep(randomnum(100, 50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int randomnum(int max, int min) {
		double i = Math.random() * (max - min) + min;
		return (int) i;
	}
}
