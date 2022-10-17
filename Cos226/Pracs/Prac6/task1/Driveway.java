class Driveway extends Thread {
    static Queue queue;

    public Driveway(Queue q) {
        queue = q;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int accesTime = Random();
            try {
                queue.enq(Thread.currentThread().getName() + " OrderNumber: " + i);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Thread.currentThread().sleep(accesTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                queue.deq();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private int Random() {
        return (int) (Math.random() * 1000);
    }
}
