public class Sleep {
    public void gosleep(Thread t) throws InterruptedException{
        t.sleep(randomnum(100, 50));
    }

    private int randomnum(int max, int min) {
        double i = Math.random() * (max - min) + min;
        return (int) i;
    }
}
