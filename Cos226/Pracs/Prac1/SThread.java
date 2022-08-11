public class SThread extends Thread{

    Scrumboard ptrs;
    PetersonLock p1;
    public SThread(Scrumboard n,PetersonLock lock){
        ptrs = n;
        p1 = lock;
    }

    public void run(){

        for(int i = 0; i < 5;i++){
                p1.lock();
            try{
                String Todo = ptrs.nextItem();
                System.out.println(this.getName() + " Task: " + Todo);
                ptrs.store(Todo);
            }finally {
                p1.unlock();
            }

        }
    }

}
