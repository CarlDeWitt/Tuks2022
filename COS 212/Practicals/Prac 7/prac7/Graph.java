public class Graph {
    private Vertex[] vertices;
    public Graph(int numVertex){
        vertices = new Vertex[numVertex];
    }

    int countEdges=0;
    public boolean addVertex(String nName, int numVertices){
        int openPos = -1;
        for(int i=0; i < vertices.length; i++)
        {
            if(vertices[i] == null){
                if(openPos == -1)
                    openPos = i;
            } else {
                if(vertices[i].getVName().equals(nName)){
                    return false;
                }
            }
        }
        if(openPos == -1)
            return false;

        vertices[openPos] = new Vertex(nName, numVertices);
        return true;
    }

    public Vertex getVertex(String nName){
        for(int i=0; i < vertices.length; i++){
            if(vertices[i] != null && vertices[i].getVName().equals(nName)){
                return vertices[i];
            }
        }
        return null;
    }

    public boolean addEdge(String pointA, String pointB, float value, String vName){
        Vertex pA = getVertex(pointA);
        Vertex pB = getVertex(pointB);
        if(pA == null || pB == null)
            return false;

        Edge v = new Edge(value, vName);
        countEdges++;
        v.pointA = pA;
        v.pointB = pB;
        pA.addEdge(v);
        return true;
    }

    //Do not change the above functions
    //Implement the functions below

    public boolean isAccessable(Vertex vertexFrom, Vertex vertexTo){
        if(shortestDistance(vertexFrom,vertexTo) == Float.POSITIVE_INFINITY){
            return false;
        }else{
            return true;
        }
    }

    public float shortestDistance(Vertex vertexFrom, Vertex vertexTo){
        if(vertexFrom ==null|| vertexTo == null ){
//            System.out.println("null");
            return Float.POSITIVE_INFINITY;
        }
        if(vertexFrom == vertexTo){
            return 0;
        }
       /* queue TBC = new queue();
        float dist = Float.POSITIVE_INFINITY;

        for(int i = 0; i < vertices.length; i++){
            if(vertices[i] != null){
                vertices[i].distance = Float.POSITIVE_INFINITY;
                vertices[i].pre =null;
                TBC.nq(vertices[i]);
            }
        }
//        System.out.println(vertexFrom.getVName());
        vertexFrom.distance = 0;
//make start vertex
        while(TBC.mt() == false){
            Vertex v = TBC.dq();
            for(Edge u: v.getEdges()) {
                if (u != null && u.pointB.distance > v.getDistance() + u.getValue()) {
                    u.pointB.distance = v.distance + u.getValue();
//                    System.out.println(u.pointB.getVName());

                    if (u.pointB == vertexTo && u.pointB.pre != v) {
                        dist = u.pointB.distance;
                        if (u.pointB == vertexFrom) {
                            break;
                        }
                    }
                    u.pointB.pre = v;
                    if (!TBC.ct(u.pointB) && u.pointB.pre != v) {
//                        System.out.println("here2");
                        TBC.nq(u.pointB);
                    }
                }
                else{
//                    System.out.println("here");
                    TBC.dq();
                    break;
                }
            }

        }
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                vertices[i].num = 0;
                vertices[i].pre = null;
            }
        }*/
       queue TBC = new queue();
        float dist = Float.POSITIVE_INFINITY;
        float newdist = Float.POSITIVE_INFINITY;

        for(int i = 0; i < vertices.length; i++){
            if(vertices[i] != null){
                vertices[i].distance = Float.POSITIVE_INFINITY;
                vertices[i].pre =null;
//                TBC.nq(vertices[i]);
            }
        }
        vertexFrom.distance =0;
        TBC.nq(vertexFrom);
        Vertex curr;

        while(!TBC.mt()){
            curr = TBC.dq();
            for(Edge u: curr.getEdges()){
                if(u != null) {
                    newdist = curr.distance + u.getValue();
                    if (newdist < u.pointB.distance) {
                        u.pointB.distance = newdist;
                        u.pointB.pre = curr;
                        if (u.pointB == vertexTo) {
                            dist = u.pointB.distance;
                        }
                        if (!TBC.ct(u.pointB)) {
                            TBC.nq(u.pointB);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < vertices.length; i++){
            if(vertices[i] != null){
                vertices[i].distance = Float.POSITIVE_INFINITY;
                vertices[i].pre =null;
//                TBC.nq(vertices[i]);
            }
        }

        return dist;
    }

    public Vertex[] shortestPath(Vertex vertexFrom, Vertex vertexTo){
        if(vertexFrom != null && vertexTo != null) {
            if(!isAccessable(vertexFrom,vertexTo)){
                return null;
            }
            queue TBC = new queue();
            float dist = 0;

            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] != null) {
                    vertices[i].distance = Float.POSITIVE_INFINITY;
                    vertices[i].pre = null;
                }
            }
            vertexFrom.distance = 0;
            TBC.nq(vertexFrom);

            float curDist = vertexFrom.distance;
            float newdist = Float.POSITIVE_INFINITY;
            Vertex curr;

            while(!TBC.mt()){
                curr = TBC.dq();
                for(Edge u: curr.getEdges()){
                    if(u != null) {
                        newdist = curr.distance + u.getValue();
                        if (newdist < u.pointB.distance) {
                            u.pointB.distance = newdist;
                            u.pointB.pre = curr;
                            if (u.pointB == vertexTo) {
                                dist = u.pointB.distance;
                            }
                            if (!TBC.ct(u.pointB)) {
                                TBC.nq(u.pointB);
                            }
                        }
                    }
                }
            }

            queue path = new queue();
            path.nq(vertexTo);
            getpath(vertexTo, path, vertexFrom);
            int counter = path.ln();
            Vertex[] shrtpath = new Vertex[counter];
            counter = counter - 1;
            while (!path.mt()) {
//            System.out.println(path.dequeue().getVName());
                shrtpath[counter] = path.dq();
                counter--;
            }
            for(int i=0;i< vertices.length;i++){
                if(vertices[i] != null) {
                    vertices[i].num = 0;
                    vertices[i].pre = null;
                }

            }

            return shrtpath;
        }
        return null;
    }

    private void getpath(Vertex n, queue q1,Vertex from){
        if(n == from)
            return;
        else{
            q1.nq(n.pre);
            getpath(n.pre,q1,from);
        }
    }

    int cl = 0;
    boolean doeshave = false;
    public boolean containsCycle(Vertex startingVertex){
        int index = 1;
        DFTstr="";
        doeshave = false;
        for(int i=0;i< vertices.length;i++){
            if(vertices[i] != null) {
                vertices[i].num = 0;
                vertices[i].pre = null;
            }

        }
        boolean out = DFTCycle2(startingVertex,index);
        for (int m = 0; m < vertices.length; m++) {
            if (vertices[m] != null) {
                vertices[m].num = 0;
                vertices[m].pre = null;
            }
        }
//        return DFTCycle2(startingVertex,index);
        return out;
    }

    private boolean DFTCycle2(Vertex v,int i){
        if(v != null) {
            v.num = i++;
            for (Edge u : v.getEdges()) {
                if (u != null) {
                    if (u.pointB.num == 0) {
                        u.pointB.pre = v;
                        DFTCycle2(u.pointB, i);
                    } else if (u.pointB.num != Float.POSITIVE_INFINITY) {
                        u.pointB.pre = v;
//                    System.out.println("true babaycakes");
                        doeshave = true;
                    }
                }
            }
            v.num = Float.POSITIVE_INFINITY;
        }

        return doeshave;
    }

    public void listCycles(){
//        0-2-3-1-0
        int index = 1;
        DFTstr="";
        for(int i=0;i< vertices.length;i++){
            if(vertices[i] != null){
                vertices[i].num = 0;
                vertices[i].pre = null;
            }
        }
        DFTCycle(vertices[0],index);
        for(int i=0;i< vertices.length;i++){
            if(vertices[i] != null) {
                vertices[i].num = 0;
                vertices[i].pre = null;
            }

        }
        return;
    }

    private void DFTCycle(Vertex v,int i){
        if(v != null) {
            v.num = i;
            i = i +1;
            for (Edge u : v.getEdges()) {
                if (u != null) {
                    if (u.pointB.num == 0) {
                        u.pointB.pre = v;
                        DFTCycle(u.pointB, i);
                    } else if (u.pointB.num != Float.POSITIVE_INFINITY) {
                        u.pointB.pre = v;
                        printCycle(u.pointB);
                    }
                }
            }
            v.num = Float.POSITIVE_INFINITY;
        }
    }

    private void printCycle(Vertex v){
        String str = v.getVName() + "-";
        Vertex temp;
        temp = v.pre;
        while(temp != v){
            str += temp.getVName() + "-";
//            System.out.print(v.getVName() + "-");
//            temp.pre.num = Float.POSITIVE_INFINITY;
            temp = temp.pre;
        }
        str += v.getVName();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }

    public int countEdges(){
        int count = 0;
        for(int i = 0; i < vertices.length; i++){
            if(vertices[i] != null){
                for(Edge u: vertices[i].getEdges()){
                    if(u != null){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    int DFTi = 0;
    String DFTstr;
    public String DFT(Vertex startVertex){
        if(startVertex != null) {
            DFTi = 1;
            DFTstr = "";
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] != null) {
                    vertices[i].num = 0;
                    vertices[i].pre = null;
                }
            }
            DFTHelp(startVertex);
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] != null && vertices[i].num == 0) {
//                System.out.println(vertices[i].getVName());
//                DFTstr += vertices[i].getVName() + ";";
//                System.out.println("in dft help");
                    DFTHelp(vertices[i]);
                }
            }

            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] != null) {
                    vertices[i].num = 0;
                    vertices[i].pre = null;
                }
            }

            return DFTstr.substring(0, DFTstr.length() - 1);
        }
        return "";
    }

    private void DFTHelp(Vertex v){
        if(v != null) {
            DFTstr += v.getVName() + ";";
            v.num = DFTi++;
            for (Edge u : v.getEdges()) {
                if (u != null && u.pointB.num == 0) {
                    DFTHelp(u.pointB);
                }
            }
        }
    }

//    queue class

    class queue
    {
        public Vertex[] Q;

        public queue() {
            Q = new Vertex[0];
        }

        public boolean mt() {
            if(Q.length != 0)
                return false;
            else
                return true;
        }

        public boolean IF(){
            return Q.length == Q.length;
        }

        public Vertex dq() {
            if(mt() == true)
                return null;
            else{
                Vertex[] temp = new Vertex[ln() -1];
                for(int m=1;m< Q.length;m++)
                    temp[m-1] = Q[m];
                Vertex dq = Q[0];
                queue tempQ = new queue();
                for(int m=0; m < Q.length; m++){
                    tempQ.nq(dq);
                }
                Q = temp;
                return dq;
            }
        }
        public Vertex pq(){
            if(mt() == false){
                return Q[0];
            }
            return null;
        }

        public Vertex bk(){
            if(mt() == false){
                return Q[ln() -1];
            }
            return null;
        }

        public void nq(Vertex v) {
            Vertex[] temp = new Vertex[Q.length+1];
            for(int m=0;m<Q.length;m++)
                temp[m] = Q[m];
            queue tempQ = new queue();
            for(int m=0; m < Q.length; m++){
                tempQ.nq(v);
            }
            temp[Q.length] = v;
            Q = temp;
        }

        public boolean ct(Vertex vertex) {
            for(int m =0;m<Q.length;m++)
                if(Q[m] == vertex)
                    return true;
            return false;
        }

        public int ln (){
            return Q.length;
        }
    }
}
