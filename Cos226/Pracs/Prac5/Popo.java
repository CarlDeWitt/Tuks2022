public class Popo extends Thread {
    private GalleryQueue p;

    public Popo(GalleryQueue p) {
        this.p = p;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            p.add(i + Thread.currentThread().getId());
            int accesTime = Random();
            System.out.println("[" + Thread.currentThread().getName() + "] added ([" +
                    i + "],["
                    + accesTime + "ms])");
            try {
                this.sleep(accesTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.remove(i);
            System.out.println("[" + Thread.currentThread().getName() + "] removed ([" +
                    i + "],["
                    + accesTime + "ms])");
        }
    }

    private int Random() {
        return 100 + (int) (Math.random() * 1000);
    }
}
