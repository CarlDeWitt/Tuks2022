//carlie van wyk u21672823

@SuppressWarnings("unchecked")
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(int capacity) {
	super(capacity);
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    @Override
    public void insert(T elem) {

        //Your code goes here
        //add to array:
//        currentSize++;
        mH[++currentSize] = elem;
        int sizeOF = currentSize;
        //restore array:
        while (sizeOF > 1 && (mH[sizeOF].compareTo((T) mH[sizeOF / 2]) < 0)) {
            Comparable<T> temp = mH[sizeOF];
            mH[sizeOF] = mH[sizeOF / 2];
            mH[sizeOF / 2] = temp;
            sizeOF = sizeOF/2;
        }
    }

    public T removeMin() {

        //Your code goes here
        if(currentSize == 0) {
            return null;
        }
        else {
            T result = (T) mH[1];
            restoreHeap(1);      // to restore heap
            return result;                               // return max elem
        }
    }

    public void delete(T elem) {

	//Your code goes here
        //search for elem
        for(int i = 1; i <= currentSize; i++) {
            if(elem.equals(mH[i])) {
                restoreHeap(i);
                break;
            }
            else {
                //do nothing
            }
        }
    }


    //Helper functions
    public void restoreHeap(int indexOfToBeRemoved) {
        //remove elem from heap
        if(currentSize == 1) {
            currentSize--;
        }
        else {
            mH[indexOfToBeRemoved] = mH[currentSize];
            currentSize--;
        }

        //restore heap
        if(currentSize == 0 || currentSize == 1) {
            //do nothing
        }
        else {
            int indexOfMovingVal = indexOfToBeRemoved;
            while(indexOfMovingVal < currentSize) {
                Comparable<T> temp = mH[indexOfMovingVal];
                if(getLeftChildIndex(indexOfMovingVal) <= currentSize && getRightChildIndex(indexOfMovingVal) <= currentSize) {   //check if i has children

                    if(mH[getLeftChildIndex(indexOfMovingVal)].compareTo((T) mH[getRightChildIndex(indexOfMovingVal)]) < 0)  {  //add to left
                        mH[indexOfMovingVal] = mH[getLeftChildIndex(indexOfMovingVal)];
                        mH[getLeftChildIndex(indexOfMovingVal)] = temp;
                        indexOfMovingVal = getLeftChildIndex(indexOfMovingVal);
                    }
                    else {                                                                                                      //add to right
                        mH[indexOfMovingVal] = mH[getRightChildIndex(indexOfMovingVal)];
                        mH[getRightChildIndex(indexOfMovingVal)] = temp;
                        indexOfMovingVal = getRightChildIndex(indexOfMovingVal);
                    }
                }
                else if(getLeftChildIndex(indexOfMovingVal) < currentSize && getRightChildIndex(indexOfMovingVal) > currentSize){            //has only left child
                    mH[indexOfMovingVal] = mH[getLeftChildIndex(indexOfMovingVal)];
                    mH[getLeftChildIndex(indexOfMovingVal)] = temp;
                    indexOfMovingVal = getLeftChildIndex(indexOfMovingVal);

                }
                else {
                    // do nothing cause has no children
                    break;
                }
            }
        }
    }

}