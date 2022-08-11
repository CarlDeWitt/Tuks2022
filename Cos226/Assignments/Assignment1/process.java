import java.util.Random;

public class process {

//    do work time here
//    then set rest here
//    add dev to test
//    after test add to finish

    public process(){}
    public void workoncomp(Thread t,Component comp,Project p) throws InterruptedException {
        Random r = new Random();
        int num = r.nextInt(500 - 100) + 100;
        System.out.println(Thread.currentThread().getName() + " is working for " + num + " and is working on " + comp.name + " and comp has " + comp.developTime + " left");
        comp.developTime = comp.developTime - num;
//        Thread.currentThread().sleep(num);
        if(comp.developTime < 0){
            System.out.println(t.getName() + " finished developing " + comp.name);
        }else{
            System.out.println(t.getName() + " developed " + comp.name + " for " + num + "ms. Time remaining: " + comp.developTime);
        }
    }

    public void sleeping()throws InterruptedException{
        Random r = new Random();
        int num = r.nextInt(100 - 50) + 50;
        Thread.currentThread().sleep(num);
        System.out.println(Thread.currentThread().getName() + " is taking a break");
    }

    public void workoncompTest(Test t, Component comp, Project p) throws InterruptedException{
        Random r = new Random();
        int num = r.nextInt(500 - 100) + 100;
        System.out.println(Thread.currentThread().getName() + " is working for " + num + " and is working on " + comp.name + " and comp has " + comp.testTime + " left");
        comp.testTime = comp.testTime - num;
        Thread.currentThread().sleep(num);
        if(comp.developTime < 0){
            System.out.println(t.getName() + " finished testing " + comp.name);
        }else{
            System.out.println(t.getName() + " testing " + comp.name + " for " + num + "ms. Time remaining: " + comp.testTime);
        }
    }

}
