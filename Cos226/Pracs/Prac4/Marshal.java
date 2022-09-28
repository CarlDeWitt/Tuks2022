public class Marshal extends Thread {

	private VotingStation vs;

	Marshal(VotingStation _vs) {
		vs = _vs;
	}

	@Override
	public void run() {
		try {
			vs.castBallot();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
