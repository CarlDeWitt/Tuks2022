import java.util.Arrays;
public class Main
{
	public static void main(String[] args)
	{

		//Unsorted array
		Integer[] arraynum = { 2, 6, 3, 5, 1 };
        	 
		int first = 0;
		int last = arraynum.length - 1;

		//Call merge sort with integers
		Sort.mergesort(arraynum, first, last, true);
         
		//Print sorted array
		System.out.println("Sorted : " + Arrays.toString(arraynum));

		//Unsorted array
		String[] arraystr = { "presence", "threshold", "download", "chemicals", "basics" };
        	 
		first = 0;
		last = arraystr.length - 1;

		//Call merge sort with strings
		Sort.mergesort(arraystr, first, last, true);
         
		//Print sorted array
		System.out.println("Sorted : " + Arrays.toString(arraystr));

		//Unsorted array
		int[] arrayint = { 2, 6, 3, 5, 1 };
        	 
		//Call counting sort with integers
		Sort.countingsort(arrayint, true);
         
		//Print sorted array
		System.out.println("Sorted : " + Arrays.toString(arrayint));

		/* Expected output
		[2, 6, 3, 5, 1]
		[2, 3, 6, 5, 1]
		[2, 3, 6, 1, 5]
		[1, 2, 3, 5, 6]
		Sorted : [1, 2, 3, 5, 6]
		[presence, threshold, download, chemicals, basics]
		[download, presence, threshold, chemicals, basics]
		[download, presence, threshold, basics, chemicals]
		[basics, chemicals, download, presence, threshold]
		Sorted : [basics, chemicals, download, presence, threshold]
		[1, 2, 3, 5, 6]
		Sorted : [1, 2, 3, 5, 6]
		*/
	}
}
