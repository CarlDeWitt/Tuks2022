

@SuppressWarnings("unchecked")
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(int capacity) {
	super(capacity);
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    @Override
    public void insert(T elem) {
        if(isFull()){
            return;
        }

        mH[++currentSize] = elem;
        hublybublyUP(currentSize);
    }

    private void hublybublyUP(int place){
        T newval;
        int dadAbove;
        newval = (T) mH[place];
        while(place > 1 && newval.compareTo((T) mH[getParent(place)]) < 0){
            mH[place] =  mH[getParent(place)];
            place  = getParent(place);
        }

        mH[place] = newval;
    }

    public T removeMin() {
        int index = 1;
        if(isEmpty()){
            return null;
        }

        T deleteVal;
        deleteVal = (T) mH[index];
        mH[index] = mH[currentSize];
        //        System.out.println(deleteVal);
        //pass it into the fillter down
        int prnt = getParent(currentSize);
//        System.out.println(prnt);
        DownLikeThatYeahDownLikeThatOOOOOHHHHyeah(1,currentSize);
        prnt = getParent(currentSize);
//        System.out.println(prnt);
        currentSize--;
        return deleteVal;
    }

    public void delete(T elem) {
        int index = indexing(elem);
        int daddy;
        if(isEmpty()){
            return;
        }

        if(index == -1){
            return;
        }
        daddy = getParent(index);
        T deleteVal = (T) mH[index];

        mH[index] = mH[currentSize];

        if(index == 1 || mH[index].compareTo((T) mH[daddy]) > 0){ // <
            DownLikeThatYeahDownLikeThatOOOOOHHHHyeah(index, currentSize);
        }else
            hublybublyUP(index);

//        System.out.println(daddy);
//        System.out.println(mH[index]);
        currentSize--;
//        System.out.println(deleteVal);
    }

    private void DownLikeThatYeahDownLikeThatOOOOOHHHHyeah(int index, int lastheap){
        int LC;
        int RC;
        int CTS;
        T LV;
        T RV;
        T CTV;

        while( index <= lastheap) {
            LC = getChild(index, "L");
            RC = getChild(index, "R");
            if (LC <= lastheap) {// <=
                if (RC > lastheap) {  //>
                    T valueof;
                    valueof = (T) mH[index];
                    CTS = LC;
                } else {
                    if (mH[LC].compareTo((T) mH[RC]) < 0) { // >
                        CTV = (T) mH[LC];
                        CTS = LC;
//                        System.out.println(CTV);
                    } else{
                        CTV = (T) mH[RC];
                        CTS = RC;
                        //                        System.out.println(CTV);
                    }

                }
                    if (mH[index].compareTo((T) mH[CTS]) > 0) { // <
                        CTV = (T) mH[index];
                        T temp = (T) mH[index];
                        LV = (T) mH[LC];
                        mH[index] = mH[CTS];
                        RV = (T) mH[RC];
                        mH[CTS] = temp;
//                        System.out.println(RV);
//                        System.out.println(LV);
//                        System.out.println(CTV);
                    } else
                        break;

                    index = CTS;

            }else
                break;
        }
    }
}