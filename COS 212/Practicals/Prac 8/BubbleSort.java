public class BubbleSort extends Sorting {
    public BubbleSort(){
        name = "BubbleSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String arr[] = vertexToString(array);
        for(int i = 0; i < arr.length-1; i++){
            for(int j = arr.length -1; j > i;--j){
                if(arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr,j,j-1);
                }
            }
            printArr(arr);
        }
        return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) {
        String arr[] = vertexToString(array);
        for(int i = 0; i < arr.length-1; i++){
            for(int j = arr.length -1; j > i;--j){
                if(arr[j].compareTo(arr[j-1]) > 0){
                    swap(arr,j,j-1);
                }
            }
            printArr(arr);
        }
        return arr;
    }
}
