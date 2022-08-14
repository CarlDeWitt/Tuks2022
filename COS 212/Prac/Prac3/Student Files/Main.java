public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        // tree.insert(1);
        // tree.insert(5);
        // tree.insert(4);
        // tree.insert(7);
        // tree.insert(99999);
//        System.out.println("null testing");
//        System.out.println(tree.minVal());
//        System.out.println(tree.maxVal());
//        System.out.println(tree.height());
//        System.out.println(tree.DFT());
//        System.out.println(tree.nodesOnHeight(5));
//        System.out.println(tree.find(8));
//        System.out.println(tree.contains(99999));
//
//        System.out.println("null testing done");

        tree.insert(73);
        tree.insert(11);
        tree.insert(95);
        tree.insert(82);
        tree.insert(87);
        tree.insert(7);
        tree.insert(32);
        tree.insert(60);
        tree.insert(72);

//        System.out.println(tree.toArray().length);
//         System.out.println(tree.nodesOnHeight(2));
        /*Object[] treenodes = tree.toArray();
        System.out.println("num tree nodes");
        System.out.println(tree.numNodes());
        tree.numNodes();

        System.out.println("find:");
        System.out.println(tree.find(73));
        System.out.println("contains:");
        System.out.println(tree.contains(99999));
        System.out.println("contains true:");
        System.out.println(tree.contains(7));
        System.out.println("min:");
        System.out.println(tree.minVal());
        System.out.println("max:");
        System.out.println(tree.maxVal());
        System.out.println("height:");
        System.out.println(tree.height());
        System.out.println("dft:");*/
//        System.out.println(tree.DFT());

//        System.out.println(tree.DFT());
        System.out.println(tree.BFT());


//        int h = 4;
//        Object[] jjt = tree.nodesOnHeight(h);
//        for (int i = 0; i < (int) Math.pow(2, h); i++) {
//            System.out.println(i + " | " + jjt[i]);
//        }

//        System.out.println(tree.nodesOnHeight(4));
        /*System.out.println(tree.BFT());*/
    }
}
/*
 * null
 * null
 * -1
 * 
 * null
 * null
 * false
 * 9
 * null
 * false
 * false
 * 7
 * 95
 * 4
 * L[]V[7]R[];L[7]V[11]R[32];L[]V[32]R[60];L[]V[60]R[72];L[]V[72]R[];L[11]V[73]R
 * [95];L[]V[82]R[87];L[]V[87]R[];L[82]V[95]R[]
 * 0 | L[]V[72]R[]
 * 1 | null
 * 2 | null
 * 3 | null
 * 4 | null
 * 5 | null
 * 6 | null
 * 7 | null
 * 8 | null
 * 9 | null
 * 10 | null
 * 11 | null
 * 12 | null
 * 13 | null
 * 14 | null
 * 15 | null
 * null
 * L[11]V[73]R[95];L[7]V[11]R[32];L[82]V[95]R[];L[]V[7]R[];L[]V[32]R[60];L[]V[82
 * ]R[87];L[]V[60]R[72];L[]V[87]R[];L[]V[72]R[]
 */
