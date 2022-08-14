public class main {
    public static void main(String[] args) {
        Interface interface1 = new Interface();
        interface1.addPoint(new ExampleFunction1(), 1, 1);
        interface1.addPoint(new ExampleFunction1(), 2, 2);
        interface1.addPoint(new ExampleFunction1(), 1, 2);
        interface1.addPoint(new ExampleFunction1(), 2, 1);
        interface1.addPoint(new ExampleFunction1(), -2, 2);
        interface1.addPoint(new ExampleFunction1(), -1, 1);
        interface1.addPoint(new ExampleFunction1(), -2, -2);
        interface1.addPoint(new ExampleFunction1(), 2, -2);
        interface1.addPoint(new ExampleFunction2(),2,2);
//        interface1.findMin();
//        System.out.println(interface1.countNumberOfPoints());
//        interface1.getPoint(-1,-1);
//        interface1.numPointsPerQuadrant();
//        interface1.removePoint(2,-2);
        System.out.println(interface1.removeAllFunctionPoints("ExampleFunction1"));
        interface1.removeAllFunctionPoints("ExampleFunction1");
//        System.out.println(interface1.addPoint(new ExampleFunction1(), 2, 2));
//        System.out.println(interface1.addPoint(new ExampleFunction1(), 1, 2));
//        interface1.addPoint(new ExampleFunction1(), 3, 3);
//        System.out.println(interface1.addPoint(new ExampleFunction1(), 2, 2));
//        System.out.println(interface1.addPoint(new ExampleFunction1(), 2, 1));
//        interface1.printfornow();
        /*for(int i=-1; i <= 1; i++)
        {
            for(int j=1; j >= -1; j--)
            {
                interface1.addPoint(new ExampleFunction1(), i, j);
            }
        }
        System.out.println(interface1.printFunctionValues((new ExampleFunction1()).getFunctionName()));
        for(int i=-2; i <= 2; i++)
        {
            for(int j=-2; j <= 2; j++)
            {
                interface1.addPoint(new ExampleFunction2(), i, j);
            }
        }
        System.out.println(interface1.printFunctionValues((new ExampleFunction2()).getFunctionName()));
        Node n1 = interface1.getPoint(1, 1);
        for(int i=0; i < 6; i++)
        {
            System.out.print(n1.getNodeLinks()[i]);
        }
        System.out.println();
        Node n2 = interface1.getPoint(2, 2);
        for(int i=0; i < 6; i++)
        {
            System.out.print(n2.getNodeLinks()[i]);
        }
        System.out.println();
        for(int i=0; i < 4; i++)
        {
            System.out.println("Count in Q" + i + ": " + interface1.numPointsPerQuadrant()[i]);
        }
        System.out.println("Number of nodes/points: " + interface1.countNumberOfPoints());
        System.out.println(n1.getFunction().getFunctionName());
        System.out.println(n1.prevVal.getFunction().getFunctionName());
        System.out.println(n2.getFunction().getFunctionName());
        Node n3 = interface1.removePoint(1, 1);
        if(n3 == n1)
            System.out.println("Correct");
        else 
            System.out.println("Problem");
        Node n4 = interface1.getPoint(1, 1);
        if(n4 != n1)
            System.out.println("Correct");
        else 
            System.out.println("Problem");
        System.out.println(n4.getFunction().getFunctionName());
        System.out.println(n4.getValue() + " == " + interface1.calculateValue((new ExampleFunction2()), 1, 1));*/
    }
}

class ExampleFunction1 extends Function{
    public ExampleFunction1(){
        functionName = "Example function 1";
    }

    public float calculate(int v1, int v2){
        return Math.abs(v1+v2);
    }

    public Function clone(){
        return new ExampleFunction1();
    }
}

class ExampleFunction2 extends Function{
    public ExampleFunction2(){
        functionName = "Example function 2";
    }

    public float calculate(int v1, int v2){
        return Math.max(v1, v2);
    }

    public Function clone(){
        return new ExampleFunction2();
    }
}

/*
Expected output:
2;0;0;2
-2;-1;1;2;-1;-1;1;2;1;1;1;2;2;2;2;2
U[1][2]{2}D[1][0]{0}R[2][1]{2}L[0][1]{0}P[1][1]{1}N[][]{}
U[][]{}D[2][1]{2}R[][]{}L[1][2]{2}P[][]{}N[][]{}
Count in Q0: 5
Count in Q1: 5
Count in Q2: 5
Count in Q3: 5
Number of nodes/points: 20
Example function 1
Example function 2
Example function 2
Correct
Correct
Example function 2
1.0 == 1.0
*/
