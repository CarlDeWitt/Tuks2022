import java.util.Queue;
import java.util.Random;

public class Test extends Thread {
    private static bakeryT lock;
    private process p;
    private Project project;
    private Component c;
    private int size;
    private boolean loop;
    public static final String green = "\u001B[32m";
    public static final String yellow = "\033[0;35m";
    public static final String RESET = "\033[0m";

    public Test(bakeryT b, Project pr) {
        lock = b;
        p = new process();
        project = pr;
        size = project.getDevelop().size();
        loop = true;
    }

    @Override
    public void run() {

        while (loop) {
            if (project.getsize() == project.getFinished().size()) {
                loop = false;
                break;
            }
            if (project.getTesting().isEmpty()) {

            } else {
                System.out.println(yellow + this.getName() + " is ready to test a component" + RESET);
                lock.lock();
                try {
                    if (project.getTesting().peek() == null) {
                        break;
                    } else {
                        c = project.getTesting().peek();
                        project.removeTest();
                        p.workoncompTest(this, c, project);
                        if (c.testTime < 0) {
                            project.addfin(c);
                            System.out.println(green + c.name + " is done testing" + RESET);
                        } else {
                            project.addtest(c);
                        }
                        p.sleeping();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
