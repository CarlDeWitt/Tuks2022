class Main {
    public static void main(String args[]) throws InterruptedException {
        Queue queue = new Queue(5);
        Driveway driveway = new Driveway(queue);

        int threadSize = 5;

        // create threads
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread(driveway);
        }

        // satrt threads
        for (int i = 0; i < threadSize; i++) {
            threads[i].start();
        }

    }
}
