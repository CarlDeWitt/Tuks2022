public interface Consensus<T>
{
	void decide();
	void propose(T value);
}
