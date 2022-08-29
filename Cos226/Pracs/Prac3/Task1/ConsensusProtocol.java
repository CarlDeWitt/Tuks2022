public abstract class ConsensusProtocol<T> implements Consensus<T> {
	public volatile Object[] proposed;

	public ConsensusProtocol(int threadCount) {
		proposed = new Object[threadCount];
	}

	public void propose(T value) {
	}

	abstract public void decide();
}
