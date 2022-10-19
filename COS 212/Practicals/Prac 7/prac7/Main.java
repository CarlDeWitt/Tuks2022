public class Main {
    public static void main(String[] args) throws Exception {
//        ExampleA();
//        ExampleB();
        ExampleE();
    }

    public static void ExampleA() {
        Graph g = new Graph(10);
        g.addVertex("0", 6);
        g.addVertex("1", 1);
        g.addVertex("2", 1);
        g.addVertex("3", 1);
        g.addVertex("4", 0);
        g.addVertex("5", 1);
        g.addVertex("6", 0);
        g.addVertex("69", 1);

        g.addEdge("0", "1", 1, "01");
        g.addEdge("0", "2", 10, "02");
        g.addEdge("1", "3", 2, "13");
        g.addEdge("2", "3", -10, "23");
        g.addEdge("3", "4", 3, "34");
        g.addEdge("5", "6", 1, "69");

        System.out.println("DFT");
        System.out.println(g.DFT(g.getVertex("0")));
        System.out.println();

        System.out.println("SHRT dist");
        System.out.println(g.shortestDistance(g.getVertex("0"), g.getVertex("4")));
        System.out.println();
        System.out.println("getPAth NULL");
        System.out.println(g.shortestPath(g.getVertex("2"), g.getVertex("1")));
        System.out.println();

        System.out.println("getPAth");
        for (Vertex v : g.shortestPath(g.getVertex("2"), g.getVertex("4"))) {
            System.out.print(v.getVName() + ";");
        }


//        g.shortestPath(g.getVertex("0"), g.getVertex("4"));
        System.out.println();
        System.out.println();
        System.out.println("IS accesable 2 -> 4");
        System.out.println(g.isAccessable(g.getVertex("2"),g.getVertex("4")));
        System.out.println();
        System.out.println("IS accesable 2 -> 0");
        System.out.println(g.isAccessable(g.getVertex("2"),g.getVertex("0")));
        System.out.println();
        System.out.println("IS accesable 5 -> 6");
        System.out.println(g.isAccessable(g.getVertex("5"),g.getVertex("6")));
        System.out.println();
//        g.isAccessable(g.getVertex("5"),g.getVertex("6"));
        System.out.println("Count");
        System.out.println(g.countEdges());
        System.out.println();
        System.out.println("Cyles");
        g.listCycles();
//        g.listCycles();
        System.out.println();
        System.out.println("DFT");
//        g.DFT(g.getVertex("0"));
        System.out.println(g.DFT(g.getVertex("0")));
        System.out.println();
        System.out.println("Contains cycle");
        System.out.println(g.containsCycle(g.getVertex("0")));
        System.out.println();
        System.out.println("part b");
        System.out.println();
    }

        public static void ExampleB() {
         Graph g = new Graph(5);
            g.addVertex("1", 1);
            g.addVertex("2", 1);
            g.addVertex("3", 1);
            g.addVertex("4", 1);
//            contains cycle is fucked !!!!!!!!!!!!!!!!!!!!!!


//            // g.addVertex("4", 1);
            g.addEdge("1", "2", 3, "01");
            g.addEdge("2", "3", 3, "12");
            g.addEdge("3", "1", 3, "20");
//            g.addEdge("3", "1", 3, "34");
//            g.addEdge("3", "2", 3, "31");
//            g.addVertex("0", 1);

         // g.addEdge("4", "3", 3, "43");
         System.out.println("COUNT Edges: " + g.countEdges());

         System.out.print("CYCLES: ");            g.listCycles();

 //        System.out.println(g.containsCycle("0"));
         System.out.println("CONTAINS CYCLE: " + g.containsCycle(g.getVertex("1")));
         System.out.print("DFT: ");
         System.out.println(g.DFT(g.getVertex("1")));
//            g.isAccessable((g.getVertex("1")), (g.getVertex("2")));
         System.out.println(g.isAccessable((g.getVertex("3")), (g.getVertex("4"))));
         System.out.println(g.shortestDistance(g.getVertex("3"), g.getVertex("4")));
            for (Vertex v : g.shortestPath(g.getVertex("1"), g.getVertex("1"))) {
             System.out.print(v.getVName() + ";");
         }
//            System.out.println(g.shortestPath(g.getVertex("1"), g.getVertex("4")));
         System.out.println();

            System.out.println();

         System.out.println( g.DFT(g.getVertex("0")));
//            System.out.println(g.getVertex("0").isAccessable(g.getVertex("4")));
//            g.getVertex("0").isAccessable(g.getVertex("4"));
     }
    public static void ExampleE() {
        Graph g = new Graph(11);
        g.addVertex("7", 2);
        g.addVertex("0", 1);
        g.addVertex("1", 1);
        g.addVertex("2", 1);
        g.addVertex("3", 1);
        g.addVertex("4", 3);
        g.addVertex("5", 1);

        g.addVertex("10", 1);
        g.addVertex("11", 0);

        g.addVertex("69", 0);


//        g.addEdge("0", "2", 3, "01");
        g.addEdge("0", "1", 3, "01");
        g.addEdge("1", "2", 3, "21");
        g.addEdge("2", "0", 3, "23");
        g.addEdge("7", "3", 3, "23");
        g.addEdge("7", "1", 3, "23");
        g.addEdge("3", "4", 3, "23");
        g.addEdge("4", "5", 3, "23");
        g.addEdge("4", "0", -20, "23");
        g.addEdge("5", "3", 3, "23");
        g.addEdge("10", "11", 3, "23");

        System.out.println("CONTAINS CYCLE: " + g.containsCycle(g.getVertex("7")));
        g.listCycles();
//        System.out.println(g.shortestPath(g.getVertex("7"), g.getVertex("2")));
//       g.shortestDistance(g.getVertex("7"), g.getVertex("2"));
        for (Vertex v : g.shortestPath(g.getVertex("7"), g.getVertex("2"))) {
            System.out.print(v.getVName() + ";");
        }
        System.out.println();
        System.out.println(g.shortestDistance(g.getVertex("7"), g.getVertex("2")));

        System.out.println(g.DFT(g.getVertex("7")));
    }
    /*output-------------
CONTAINS CYCLE: true
3-4-5-3
0-1-2-0
7;3;4;0;1;2;
-8.0
7;3;4;5;0;1;2;10;11;69

     */
}