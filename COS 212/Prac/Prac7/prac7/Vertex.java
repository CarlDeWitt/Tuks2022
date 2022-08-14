public class Vertex {
    private String vName;
    private Edge[] edges;
//    change back

    public float num;

    public Vertex pre;

    public float distance;

    public float getDistance(){
        return distance;
    }

    public float getNum() {
        return num;
    }

    public int edgesL(){
        return edges.length;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Vertex(String vName, int numedges){
        this.vName = vName;
        edges = new Edge[numedges];
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
    int i = 0;
    boolean fnd=false;
    public boolean isAccessable(Vertex e){
        int index = 1;
        fnd = false;
        return IAhelp(this,e);
    }

    public boolean IAhelp(Vertex v,Vertex srch){
        if(v == srch){
            return true;
        }
        if(v != null) {
            v.num = i;
            i = i +1;
            for (Edge u : v.getEdges()) {
                if (u != null) {
                    if (u.pointB.num == 0) {
                        u.pointB.pre = v;
                        if(u.pointB == srch){
                            fnd = true;
                            return true;
                        }
                        IAhelp(u.pointB,srch);
                    } else if (u.pointB.num != Float.POSITIVE_INFINITY) {
                        u.pointB.pre = v;
                        if(u.pointB == srch){
                            fnd = true;
                            return true;
                        }
                    }
                }
            }
            v.num = Float.POSITIVE_INFINITY;
        }
        return fnd;
    }

}
