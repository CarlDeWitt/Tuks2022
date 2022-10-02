public class Main {
    public static void main(String args[]) {
        // MSQ LOCK
        MCSQueue mcs = new MCSQueue();
        Timeout tmt = new Timeout();

        // // MCS LOCK
        // // Arhers
        // VotingStation vs1 = new VotingStation(mcs);

        // TIMEOUT LOCK
        // Arhers
        VotingStation vs1 = new VotingStation(tmt);

        // Archers Marshall
        Marshal msh1 = new Marshal(vs1);
        // Giants Marshall
        Marshal msh2 = new Marshal(vs1);
        // Barbarians Marshall
        Marshal msh3 = new Marshal(vs1);
        // Golems Marshall
        Marshal msh4 = new Marshal(vs1);
        // Pekka Marshall
        Marshal msh5 = new Marshal(vs1);

        msh1.start();
        msh2.start();
        msh3.start();
        msh4.start();
        msh5.start();
    }
}
