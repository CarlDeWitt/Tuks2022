public class SelectionSort extends Sorting {
    
    public SelectionSort(){
        name="SelectionSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr = vertexToString(array);
        int i, j , least;
//        for(i=0; i < arr.length -1;i++){
//            for(j = i +1; j < arr.length; j++){
//                least =i;
//                if(arr[j].compareTo(arr[least]) < 0) {
//                    least = j;
//                }
//                if(i != least){
//                    swap(arr,least,i);
//                    printArr(arr);
//                }
//            }
//        }
        for(i = 0; i < arr.length ;i++){
            for(least = i,j = i+1;j < arr.length;j++){
                if(arr[j].compareTo(arr[least]) < 0){
                    least = j;
                }
            }
            if(i != least){
                swap(arr,least,i);
            }
            printArr(arr);
        }
        return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) {
        String[] arr = vertexToString(array);
        int i, j , least;
        for(i = 0; i < arr.length ;i++){
            for(least = i,j = i+1;j < arr.length;j++){
                if(arr[j].compareTo(arr[least]) > 0){
                    least = j;
                }
            }
            if(i != least){
                swap(arr,least,i);
            }
            printArr(arr);
        }
        return arr;
    }
}
