// Name: Carl de Witt
// Student number: U21444928
import java.util.Arrays;
public class Sort
{
	
	////// Implement the functions below this line //////
	
	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug)
	{
		if(first < last){
			mergesort(data,first,(first+last)/2,debug);
			mergesort(data,((first+last)/2)+1,last,debug);
			merge(data,first,last,debug);
		}
	}
     
	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug)
	{
		if(data[0] != null) {
			int mid = (first + last) / 2, i1 = first, i2 = first, i3 = mid + 1;
			Object[] temp = new Object[data.length];
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			T slong;
			if (data[0] != null) {
				while ((i2 <= (first + last) / 2) && (i3 <= last)) {
					if (data[0] != null) {
						if(data[0] != null) {
							if (data[i2].compareTo(data[i3]) < 0) {
								slong = data[i2++];
								temp[i1++] = slong;
							} else {
								slong = data[i3++];
								temp[i1++] =slong;
							}
						}
					}
				}
			}
			if (data[0] != null) {
				if (data[0] != null) {
					while (i2 <= mid) {
						if(data[0] != null) {
							slong= data[i2++];
							temp[i1++] = slong;
						}
					}
				}
				if (data[0] != null) {
					while (i3 <= last) {
						if(data[0] != null) {
							slong = data[i3++];
							temp[i1++] = slong;
						}
					}
				}
			}

			for (int i = 0; i <= last; i++){
				slong = (T) temp[i];
				data[i] = slong;
			}
			//DO NOT MOVE OR REMOVE!
			if (debug)
				System.out.println(Arrays.toString(data));
		}
	}
     
	/********** COUNTING **********/
	public static void countingsort(int[] data, boolean debug)
	{
		int i, largest = data[0],n = data.length;
		int[] tmp = new int[n];
		for(i = 1; i < n;i++){
			if(largest < data[i]){
				largest = data[i];
			}
		}
		int[] count = new int[largest+1];
		for(i =0; i <= largest; i++){
			count[i] = 0;
		}
		for(i =0; i < n; i++){
			count[data[i]]++;
		}
		for(i =1; i <= largest; i++){
			count[i]= count[i-1]+ count[i];
		}
		for(i = n-1; i >= 0; i--){
			tmp[count[data[i]]-1] = data[i];
			count[data[i]]--;
		}

		for(i =0; i < n; i++){
			data[i] = tmp[i];
		}
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

}