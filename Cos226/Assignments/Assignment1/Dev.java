import java.util.Queue;
import java.util.Random;

public class Dev extends Thread {

    static bakery lock;
    private process p;
    private Project project;
    private Component c;
    private int size;
    private boolean loop;
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String RESET = "\033[0m";


    public Dev(bakery b, Project pr) {
        lock = b;
        p = new process();
        project = pr;
        size = project.getDevelop().size();
        loop = true;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println(blue + this.getName() + " is ready to develop a component" + RESET);
            lock.lock();
            try {
                if (project.getDevelop().peek() != null) {
                    c = project.getDevelop().peek();
                    project.removedev();
                    p.workoncomp(this, c, project);
                    if (c.developTime < 0) {
                        project.addtest(c);
                        System.out.println(green + c.name + " is done dev" + RESET);
                    } else {
                        project.adddev(c);
                    }

                }else{
                    loop=false;
                    break;
                }
                p.sleeping();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

}
