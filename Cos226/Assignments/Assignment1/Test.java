import java.util.Queue;
import java.util.Random;

public class Test extends Thread {
    bakeryT lock;
    process p;
    Project project;
    Component c;
    int size;
    boolean loop;

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
            if(project.getsize() == project.getFinished().size()){
                loop = false;
                break;
            }
            if (project.getTesting().isEmpty()) {

            } else {
                System.out.println(this.getName() + " is ready to test a component");
                lock.lock();
                try {
                    if (project.getTesting().peek() == null ) {//&& (project.getDevelop().size() == 0 && project.getTesting().size() == project.getsize())
                        loop = false;
//                        System.out.println("here");
                        break;
                    }else {
                        c = project.getTesting().peek();
                        project.removeTest();
                        p.workoncompTest(this, c, project);
                        if (c.testTime < 0) {
                            project.addfin(c);
                            System.out.println(c.name + " is done test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
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
//                try {
//                    p.sleeping();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}


