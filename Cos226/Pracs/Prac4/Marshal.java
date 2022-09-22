public class Marshal extends Thread {

	private VotingStation vs;

	Marshal(VotingStation _vs) {
		vs = _vs;
	}

	@Override
	public void run() {
		vs.castBallot();
	}
}
