public class TopologicalSort extends Sorting {
    public TopologicalSort(){
        name = "TopologicalSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) throws CycleException {
        Vertex[] arr = TScall(array);
        Vertex[] temp = new Vertex[arr.length];
        for(int i = 0; i < arr.length; i++){
            temp[arr[i].tsnum - 1] = arr[i];
        }
        String[] newarr = vertexToString(temp);
        return newarr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) throws CycleException{
        String[] arr =  sortAcs(array);
        String[] temp = new String[arr.length];
        for(int i = 0,j = temp.length-1;i < arr.length;i++,j--){
            temp[j] = arr[i];
        }
        return temp;
    }
    int i, j;
    private Vertex[] TScall(Vertex[] arr)throws CycleException{
        for(int i = 0; i < arr.length; i++){
            arr[i].num = arr[i].tsnum = 0;
        }
        i =1; j = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].num == 0){
                TS(arr[i]);
            }
        }
        return arr;
    }

    private void TS(Vertex v) throws CycleException {
        v.num = i++;
        for(Edge u: v.getEdges()){
            if(u.pointB.num == 0){
                TS(u.pointB);
            } else if(u.pointB.tsnum == 0) {
                throw new CycleException();
            }
        }
        v.tsnum = j--;
    }

}



class CycleException extends Exception{
    public String message = "Cycle has been detected";
}
