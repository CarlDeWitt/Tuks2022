public class Vertex {
    private String vName;
    private Edge[] edges;

    public int num;
    public int tsnum;
    public Vertex(String vName, int numedges){
        this.vName = vName;
        edges = new Edge[numedges];
        num = 0;
        tsnum = 0;
    }

    public String getVName(){
        return vName;
    }

    public Edge[] getEdges(){
        return edges;
    }

    public boolean addEdge(Edge e){
        if(e == null)
            return false;

        for(int i=0; i < edges.length; i++)
        {
            if(edges[i] == null)
            {
                edges[i] = e;
                return true;
            }
        }
        return false;
    }

    //Do not change the above functions
    //Implement the functions below 


}
