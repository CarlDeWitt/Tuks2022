public class Main {
    public static void main(String args[]) {
        ConsensusProtocol<Integer> c = new RMWConsensus<Integer>(2);
        ConsensusThread thread1 = new ConsensusThread(c);
        ConsensusThread thread2 = new ConsensusThread(c);
        thread1.start();
        thread2.start();
    }
}
