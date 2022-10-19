public class InsertSort extends Sorting {

    public InsertSort(){
        name="InsertSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        int j;
       String[] arr = vertexToString(array);
       for(int i = 1;i < arr.length;i++){
           String temp = arr[i];
           for(j = i; j > 0 && temp.compareTo(arr[j -1]) < 0; j--){
               arr[j] = arr[j - 1];
           }
           arr[j] = temp;
           printArr(arr);
       }
       return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) {
        int j;
        String[] arr = vertexToString(array);
        for(int i = 1;i < arr.length;i++){
            String temp = arr[i];
            for(j = i; j > 0 && temp.compareTo(arr[j -1]) > 0; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            printArr(arr);
        }
        return arr;
    }
}
