public class Popo extends Thread {
    private CoarseGrainedGallery p;
    private FineGrainedGallery f;
    private OptimisticGallery o;

    public Popo(CoarseGrainedGallery p) {
        this.p = p;
    }

    public Popo(FineGrainedGallery f) {
        this.f = f;
    }

    public Popo(OptimisticGallery o) {
        this.o = o;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int accesTime = Random();
            if (p != null)
                p.add(i, Thread.currentThread().getName(), accesTime);
            else if (f != null)
                f.add(i, Thread.currentThread().getName(), accesTime);
            else
                o.add(i, Thread.currentThread().getName(), accesTime);
            System.out.println("[" + Thread.currentThread().getName() + "] added ([P-" +
                    i + "],["
                    + accesTime + "ms])");
            try {
                this.sleep(accesTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (p != null)
                p.remove(i, Thread.currentThread().getName());
            else if (f != null)
                f.remove(i, Thread.currentThread().getName());
            else
                o.remove(i, Thread.currentThread().getName());
        }

    }

    private int Random() {
        return 100 + (int) (Math.random() * 1000);
    }
}
