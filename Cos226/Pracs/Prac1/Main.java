public class Main {

    public static void main(String args[]){

        Scrumboard s = new Scrumboard();
        PetersonLock lock = new PetersonLock();

        s.print();

        Thread t1 = new SThread(s,lock);
        Thread t2 = new SThread(s,lock);

        t1.start();
        t2.start();


//        s.print();

    }

}
