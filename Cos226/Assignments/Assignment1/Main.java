public class Main {

    public static void main(String args[]){
//        add project
        Project p = new Project();

//        add devs
        int devs = 5;
        int testers = 5;
        Dev[] dev = new Dev[devs];

//        add dev lock
        bakery dbd = new bakery(devs);
        bakeryT bdt = new bakeryT(testers,devs);

//        add Process
//        process procs = new process();

        for(int i = 0; i < devs;i++){
            dev[i] = new Dev(dbd,p);
        }

//        start dev process
        for(Dev d : dev){
            d.start();
        }
//        add testers
        Test[] tst = new Test[testers];

        for(int i = 0; i < testers;i++){
            tst[i] = new Test(bdt,p);
        }

        for(Test t : tst){
            t.start();
        }

//        boolean b1 = true;
//        while(b1){
//            if(!tst[0].isAlive()){
//                System.out.println("______________________________________________");
//                b1 = false;
//            }
//        }
    }
}
