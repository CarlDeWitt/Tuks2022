import java.util.Random;

public class process {
    public static final String yellow = "\033[0;35m";
    public static final String blue = "\u001B[34m";
    public static final String RESET = "\033[0m";
    public static final String purple = "\033[0;31m";

    public process(){}
    public void workoncomp(Thread t,Component comp,Project p) throws InterruptedException {
        Random r = new Random();
        int num = r.nextInt(500 - 100) + 100;
        System.out.println(blue +Thread.currentThread().getName() + " is working for " + num + " and is working on " + comp.name + " and comp has " + comp.developTime + " left" + RESET);
        comp.developTime = comp.developTime - num;
//        Thread.currentThread().sleep(num);
        if(comp.developTime < 0){
            System.out.println(blue + t.getName() + " finished developing " + comp.name + RESET);
        }else{
            System.out.println(blue +t.getName() + " developed " + comp.name + " for " + num + "ms. Time remaining: " + comp.developTime + RESET);
        }
    }

    public void sleeping()throws InterruptedException{
        Random r = new Random();
        int num = r.nextInt(100 - 50) + 50;
        Thread.currentThread().sleep(num);
        System.out.println(purple + Thread.currentThread().getName() + " is taking a break" + RESET);
    }

    public void workoncompTest(Test t, Component comp, Project p) throws InterruptedException{
        Random r = new Random();
        int num = r.nextInt(500 - 100) + 100;
        System.out.println(yellow + Thread.currentThread().getName() + " is working for " + num + " and is working on " + comp.name + " and comp has " + comp.testTime + " left" + RESET);
        comp.testTime = comp.testTime - num;
        Thread.currentThread().sleep(num);
        if(comp.developTime < 0){
            System.out.println(yellow + t.getName() + " finished testing " + comp.name + RESET);
        }else{
            System.out.println(yellow + t.getName() + " testing " + comp.name + " for " + num + "ms. Time remaining: " + comp.testTime +RESET);
        }
    }

}
