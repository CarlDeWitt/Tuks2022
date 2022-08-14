import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentExample();
        return;
    }

    @SuppressWarnings("unchecked")
    public static void StudentExample(){
        GraphDB graphDB = new GraphDB();
        String[] userNames = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        for(int i=0; i < userNames.length; i++){
            graphDB.addUser(userNames[i], i);
        }

        Tuple<String, String, Integer>[] arr = new Tuple[]{new Tuple<>("F", "G", 1), 
                                                            new Tuple<>("A", "B", 2),
                                                            new Tuple<>("G", "C", 3),
                                                            new Tuple<>("E", "B", 6),
                                                            new Tuple<>("C", "F", 7),
                                                            new Tuple<>("D", "E", 8),
                                                            new Tuple<>("B", "F", 9),
                                                            new Tuple<>("A", "D", 15),
                                                            new Tuple<>("E", "F", 15),
                                                            new Tuple<>("A", "C", 23)};

        for(Tuple<String, String, Integer> tuple: arr){
            graphDB.addFriendship(getUserId(tuple.t, graphDB), getUserId(tuple.u, graphDB), tuple.s);
        }

        Object[] result = sort(graphDB.minSpanningTree());
        for(Object relationship: result){
            System.out.println((Relationship)relationship);
        }

        User[][] res = graphDB.clusterUsers();
        for(int i=0; i < res.length; i++){
            String temp = "";
            for(int j=0; j < res[i].length; j++){
                temp += res[i][j].toString() + ";";
            }
            System.out.println(temp);
        }

        Object[] userArr = sort(graphDB.getUsersAtDistance(graphDB.getUser("A"), 2));
        for(Object user: userArr){
            System.out.println((User)user);
        }

        coloring();
    }

    public static int getUserId(String userName, GraphDB graphDB){
        return graphDB.getUser(userName).userID;
    }

    public static void coloring(){
        GraphDB graphDB = new GraphDB();
        String[] uName = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        for(int i=0; i < uName.length; i++){
            graphDB.addUser(uName[i], i);
        }

        String[][] edges = new String[][]{{"a","e"}, {"a", "f"}, {"a", "g"}, {"b", "e"}, {"b", "c"}, {"b", "h"}, {"c", "g"}, {"d", "f"}, {"d", "g"}, {"f", "g"}, {"f", "h"}, {"g", "h"}};
        for(String[] edge : edges){
            graphDB.addFriendship(getUserId(edge[0], graphDB), getUserId(edge[1], graphDB), 0);
        }

        User[][] res = graphDB.clusterUsers();
        for(int i=0; i < res.length; i++){
            String temp = "";
            for(int j=0; j < res[i].length; j++){
                temp += res[i][j].toString() + ";";
            }
            System.out.println(temp);
        }    
    }

    private static <T> Object[] sort(T[] sort){
        ArrayList<T> result = new ArrayList<>();
        for(T relationship: sort){
            result.add(relationship);
        }

        ArrayList<T> temp = new ArrayList<>();
        while(!result.isEmpty()){
            int maxVal = Integer.MIN_VALUE;
            T maxRelationship = result.get(0);
            for(T relationship: result){
                if(relationship.toString().hashCode() > maxVal){
                    maxVal = relationship.toString().hashCode();
                    maxRelationship = relationship;
                }
            }
            temp.add(maxRelationship);
            result.remove(maxRelationship);
        }

        return temp.toArray();
    }
}

class Tuple<T,U,S>{
    public T t;
    public U u;
    public S s;

    public Tuple(T t, U u, S s){
        this.s = s;
        this.t = t;
        this.u = u;
    }
}

/*
Expected Output:
A[0]-(2.0)->B[1]
B[1]-(6.0)->E[4]
B[1]-(9.0)->F[5]
C[2]-(3.0)->G[6]
D[3]-(8.0)->E[4]
F[5]-(1.0)->G[6]
A[0];F[5];
B[1];C[2];D[3];
E[4];G[6];
E[4]
F[5]
G[6]
b[1];g[6];
c[2];e[4];f[5];
a[0];d[3];h[7];
*/
