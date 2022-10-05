class main {
    public static void main(String[] args) {
        GalleryQueue g = new GalleryQueue();
        Popo p = new Popo(g);

        Thread ACCESSPOINT1 = new Thread(p);
        Thread ACCESSPOINT2 = new Thread(p);
        Thread ACCESSPOINT3 = new Thread(p);
        Thread ACCESSPOINT4 = new Thread(p);
        Thread ACCESSPOINT5 = new Thread(p);
        ACCESSPOINT1.start();
        ACCESSPOINT2.start();
        ACCESSPOINT3.start();
        ACCESSPOINT4.start();
        ACCESSPOINT5.start();
    }
}