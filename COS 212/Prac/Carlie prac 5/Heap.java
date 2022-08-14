//carlie van wyk u21672823

@SuppressWarnings("unchecked")
public abstract class Heap<T extends Comparable<T>> {

    int capacity;
    Comparable<T> mH[];
    int currentSize;

    public Heap(int capacity) {
        this.capacity = capacity;
        mH = new Comparable[capacity+1]; //Use index positions 1 to capacity 
        currentSize = 0;
    }

    protected int getCapacity(){
        return capacity;
    }

    protected int getCurrentSize(){
        return currentSize;
    }

    public void display() {
        for(int i = 1; i <= currentSize; i++) {
            System.out.print(mH[i] + " ");
        }
        System.out.println("");
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    protected boolean isEmpty() {

        //Your code goes here
        if (this.currentSize == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public abstract void insert(T elem);


    //Helper functions
    public int getParentIndex(int indexOfChild) {
        int result = indexOfChild/2;
        return result;
    }

    public int getLeftChildIndex(int indexOfParent) {
        int result = 2*indexOfParent;
        return result;
    }

    public int getRightChildIndex(int indexOfParent) {
        int result = (2*indexOfParent) + 1;
        return result;
    }

}