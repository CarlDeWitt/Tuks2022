public class ConsensusThread extends Thread {
	private Consensus<Integer> consensus;
	Sleep slp;

	ConsensusThread(Consensus<Integer> consensusObject) {
		consensus = consensusObject;
		slp = new Sleep();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {

			// System.out.println("");
			consensus.propose(randomnum(200, 100));
			consensus.decide();
//			 System.out.println("");
		}
	}

	private int randomnum(int max, int min) {
		double i = Math.random() * (max - min) + min;
		return (int) i;
	}
}
