
public class Main {

    public static void insertAll(Heap<Integer> heap, Integer[] list) 
    {
        for(int i = 0; i < list.length; i++) {
            heap.insert(list[i]);
        }
    }

    public static void printHeap(Heap<Integer> heap) 
    { 
	if (heap.isEmpty()) 
	{
            System.out.println("Heap is empty");
        } 
	else
	{
	    if (heap instanceof MinHeap)
	    	System.out.println("Min-Heap Content:");
	    else
		System.out.println("Max-Heap Content:"); 
            heap.display();  
	}
    }

    public static void main(String args[])
    {
		Integer[] list = new Integer[]{};
		MinHeap<Integer> min = new MinHeap<Integer>(list.length);
		insertAll(min, list);
		printHeap(min);
		min.delete(15);
		min.removeMin();
		printHeap(min);
		System.out.println("null tetsing on max--------------------");
		MaxHeap<Integer> max = new MaxHeap<Integer>(list.length);
		insertAll(max, list);
		printHeap(max);
		max.delete(10);
		max.removeMax();
       /* Integer[] list = new Integer[]{2, 8, 6, 1, 10, 15, 3, 12, 11};

	MinHeap<Integer> min = new MinHeap<Integer>(list.length);
	insertAll(min, list);

        printHeap(min);

	min.delete(15);

	printHeap(min);

	min.delete(3);

	printHeap(min);

	System.out.println("Min : " + min.removeMin());

	printHeap(min);

	System.out.println("Min : " + min.removeMin());

	printHeap(min);

	/* Expected Output:
	Min-Heap Content:
	1 2 3 8 10 15 6 12 11
	Min-Heap Content:
	1 2 3 8 10 11 6 12
	Min-Heap Content:
	1 2 6 8 10 11 12
	Min : 1
	Min-Heap Content:
	2 8 6 12 10 11
	Min : 2
	Min-Heap Content:
	6 8 11 12 10
	*/

	/*MaxHeap<Integer> max = new MaxHeap<Integer>(list.length);
	insertAll(max, list);

	printHeap(max);

	max.delete(11);

	printHeap(max);

	max.delete(10);

	printHeap(max);

	System.out.println("Max : " + max.removeMax());

	printHeap(max);

	System.out.println("Max : " + max.removeMax());

	printHeap(max);

	/* Expected Output:
	Max-Heap Content:
	15 12 10 11 2 6 3 1 8
	Max-Heap Content:
	15 12 10 8 2 6 3 1
	Max-Heap Content:
	15 12 6 8 2 1 3
	Max : 15
	Max-Heap Content:
	12 8 6 3 2 1
	Max : 12
	Max-Heap Content:
	8 3 6 1 2
	*/

    }

}