public class Main {

    public static void main(String[] args){
        studentExample();
    }
    
    public static void studentExample() {
        Graph g = new Graph(4);
        for (int i = 9; i < 12; i++) {
            g.addVertex(Integer.toString(i), 1);
        }
        g.addVertex("12", 0);
        for (int i = 9; i < 12; i++) {
            g.addEdge(Integer.toString(i), Integer.toString(i + 1), 0, Integer.toString(i) + Integer.toString(i + 1));
        }
       /* try {
            g.printSort(new InsertSort(), g, true);
        } catch (CycleException e) {
            e.printStackTrace();
        }
        try {
            g.printSort(new BubbleSort(), g, true);
        } catch (CycleException e) {
            e.printStackTrace();
        }
        try {
            g.printSort(new SelectionSort(), g, true);
        } catch (CycleException e) {
            e.printStackTrace();
        }
        try {
            g.printSort(new CombSort(), g, true);
        } catch (CycleException e) {
            e.printStackTrace();
        }
        try {
            g.printSort(new TopologicalSort(), g, true);
        } catch (CycleException e) {
            e.printStackTrace();
        }
        Graph g2 = new Graph(4);
        for (int i = 0; i < 4; i++) {
            g2.addVertex(Integer.toString(i), 1);
        }
        for (int i = 0; i < 3; i++) {
            g2.addEdge(Integer.toString(i), Integer.toString(i + 1), 0, Integer.toString(i) + Integer.toString(i + 1));
        }
        g2.addEdge("3", "0", 0, "30");
        try {
            g.printSort(new TopologicalSort(), g2, true);
        } catch (CycleException e) {
            System.out.println(e.message);
        }*/

        try{
            g.printSort(new InsertSort(), g, false);}
        catch(CycleException e)
        {
            e.printStackTrace();
        }
        try{
            g.printSort(new BubbleSort(), g, false);}
        catch(CycleException e)
        {
            e.printStackTrace();
        }
        try{
            g.printSort(new SelectionSort(), g, false);}
        catch(CycleException e)
        {
            e.printStackTrace();
        }
        try{
            g.printSort(new CombSort(), g, false);}
        catch(CycleException e)
        {
            e.printStackTrace();
        }
        try{
            g.printSort(new TopologicalSort(), g, false);}
        catch(CycleException e)
        {
            e.printStackTrace();
        }
        Graph g2 = new Graph(4);
        for(int i=0; i < 4; i++)
        {
            g2.addVertex(Integer.toString(i), 1);
        }
        for(int i=0; i < 3; i++)
        {
            g2.addEdge(Integer.toString(i), Integer.toString(i+1), 0, Integer.toString(i) + Integer.toString(i+1));
        }
        g2.addEdge("3", "0", 0, "30");
        try{
            g.printSort(new TopologicalSort(), g2, false);}
        catch(CycleException e)
        {
            System.out.println(e.message);
        }
    }}

/*
Sorted using: InsertSort
10;9;11;12
10;11;9;12
10;11;12;9
10|11|12|9|
Sorted using: BubbleSort
10;9;11;12
10;11;9;12
10;11;12;9
10|11|12|9|
Sorted using: SelectionSort
10;9;11;12
10;11;9;12
10;11;12;9
10;11;12;9
10|11|12|9|
Sorted using: CombSort
12;10;11;9
Gap: 3
11;10;12;9
Gap: 2
10;11;12;9
Gap: 1
10;11;12;9
Gap: 1
10|11|12|9|
Sorted using: TopologicalSort
9|10|11|12|
Sorted using: TopologicalSort
Cycle has been detected
*/