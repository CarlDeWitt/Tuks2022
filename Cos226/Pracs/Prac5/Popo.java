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
            String hashname = i + Thread.currentThread().getName();
            if (p != null)
                p.add(i, hashname, accesTime);
            else if (f != null)
                f.add(i, hashname, accesTime);
            else
                o.add(i, hashname, accesTime);
            System.out.println("[" + Thread.currentThread().getName() + "] added ([P-" +
                    i + "],["
                    + accesTime + "ms])");
            try {
                this.sleep(accesTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (p != null) {
                p.remove(hashname);
                p.print();
            } else if (f != null) {
                f.remove(hashname);
                f.print();
            } else {
                o.remove(hashname);
                o.print();
            }
        }

    }

    private int Random() {
        return 100 + (int) (Math.random() * 1000);
    }
}
