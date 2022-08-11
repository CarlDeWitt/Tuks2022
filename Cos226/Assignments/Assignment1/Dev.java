import java.util.Queue;
import java.util.Random;

public class Dev extends Thread {

    bakery lock;
    process p;
    Project project;
    Component c;
    int size;
    boolean loop;

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
            System.out.println(this.getName() + " is ready to develop a component");
            lock.lock();
            try {
                if (project.getDevelop().peek() != null) {
                    c = project.getDevelop().peek();
                    project.removedev();
                    p.workoncomp(this, c, project);
                    if (c.developTime < 0) {
                        project.addtest(c);
                        System.out.println(c.name + " is done dev");
                    } else {
                        project.adddev(c);
                    }

                }else{
                    loop=false;
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                try {
                    p.sleeping();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
