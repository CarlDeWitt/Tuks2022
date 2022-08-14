import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main<T extends Comparable<T>> {
    public static void main(String[] args) {
        testInsert();
        testDelete();
    }

    private static void print(Node<Integer> node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print("[" + node.data + ":" + node.height + ":" + getBalanceFactor(node) + "] ");
        print(node.right);
    }

    private static String getResult(Node<Integer> node) {
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));

        print(node);

        String result = newConsole.toString();
        System.setOut(previousConsole);

        return result;
    }

    private static int getBalanceFactor(Node<Integer> node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    private static int getHeight(Node<Integer> node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    /*----------------------------------------------------TEST INSERT----------------------------------------------------*/
    private static void testInsert() {
        System.out.println("----------------------------TEST INSERT----------------------------");
        testNormalInsertRoot();
        testLeftRotateInsertRoot();
        testRightRotateInsertRoot();
        testLeftRightRotateInsertRoot();
        testRightLeftRotateInsertRoot();
        testLargeTreeRandomInsertions();
    }

    private static void testNormalInsertRoot() {
        System.out.println("Basic Insert: No Rotations");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);

        if (getResult(tree.root).equals("[1:0:0] [2:1:0] [3:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    private static void testLeftRotateInsertRoot() {
        System.out.println("Left Branch Insert: Case 1");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        System.out.println(getResult(tree.root));
        if (getResult(tree.root).equals("[1:0:0] [2:1:0] [3:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    private static void testRightRotateInsertRoot() {
        System.out.println("Right Branch Insert: Case 4");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);
        System.out.println(getResult(tree.root));
        if (getResult(tree.root).equals("[1:0:0] [2:1:0] [3:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    private static void testLeftRightRotateInsertRoot() {
        System.out.println("Left Branch Insert: Case 2");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);
        System.out.println(getResult(tree.root));
        if (getResult(tree.root).equals("[2:0:0] [3:1:0] [4:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    private static void testRightLeftRotateInsertRoot() {
        System.out.println("Right Branch Insert: Case 3");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 5);
        System.out.println(getResult(tree.root));
        if (getResult(tree.root).equals("[4:0:0] [5:1:0] [6:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    private static void testLargeTreeRandomInsertions() {
        System.out.println("Random Inserts: Hopefully it tests something");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 10);
        System.out.println(getResult(tree.root));
        if (getResult(tree.root).equals(
                "[1:0:0] [2:1:0] [3:0:0] [4:2:0] [5:0:0] [6:1:0] [7:0:0] [8:3:0] [9:1:1] [10:0:0] [11:2:0] [12:0:0] [13:1:0] [14:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("\u001B[31mFailed\u001B[0m");
        }
    }

    /*----------------------------------------------------TEST DELETE----------------------------------------------------*/

    private static void testDelete() {
        System.out.println("----------------------------TEST DELETE----------------------------");
        testRootCase0LeftBranch();
        testRootCase0RightBranch();
        testRootCase1LeftBranch();
        testRootCase1RightBranch();
        testRootCase2LeftBranch();
        testRootCase2RightBranch();
        testRootCase3LeftBranch();
        testRootCase3RightBranch();
        testRootCase4LeftBranch();
        testRootCase4RightBranch();
        testDeleteRoot();
    }

    private static void testRootCase0LeftBranch() {
        System.out.println("Basic Left Branch Delete: No Rotations");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.removeNode(tree.root, 1);

        if (getResult(tree.root).equals("[2:1:1] [3:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase0RightBranch() {
        System.out.println("Basic Right Branch Delete: No Rotations");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.removeNode(tree.root, 3);

        if (getResult(tree.root).equals("[1:0:0] [2:1:-1] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase1LeftBranch() {
        System.out.println("Left Branch Delete: Case 1");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.removeNode(tree.root, 1);

        if (getResult(tree.root).equals("[2:0:0] [3:1:0] [4:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase1RightBranch() {
        System.out.println("Right Branch Delete: Case 1");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.removeNode(tree.root, 4);

        if (getResult(tree.root).equals("[1:0:0] [2:1:0] [3:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase2LeftBranch() {
        System.out.println("Left Branch Delete: Case 2");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.removeNode(tree.root, 1);

        if (getResult(tree.root).equals("[2:1:1] [3:0:0] [4:2:-1] [5:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase2RightBranch() {
        System.out.println("Right Branch Delete: Case 2");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.removeNode(tree.root, 5);

        if (getResult(tree.root).equals("[1:0:0] [2:2:1] [3:0:0] [4:1:-1] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase3LeftBranch() {
        System.out.println("Left Branch Delete: Case 3");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.removeNode(tree.root, 2);

        if (getResult(tree.root).equals("[1:0:0] [3:1:0] [5:0:0] [6:2:0] [9:1:1] [10:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase3RightBranch() {
        System.out.println("Right Branch Delete: Case 3");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.removeNode(tree.root, 9);

        if (getResult(tree.root).equals("[1:0:0] [2:1:-1] [4:2:0] [5:0:0] [6:1:0] [10:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase4LeftBranch() {
        System.out.println("Left Branch Delete: Case 4");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.removeNode(tree.root, 2);

        if (getResult(tree.root).equals("[1:0:0] [3:1:-1] [6:2:0] [7:0:0] [9:1:0] [10:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    private static void testRootCase4RightBranch() {
        System.out.println("Right Branch Delete: Case 4");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.removeNode(tree.root, 9);

        if (getResult(tree.root).equals("[1:0:0] [2:1:0] [3:0:0] [4:2:0] [6:1:1] [10:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        } else {
            System.out.println("Failed");
        }
    }

    // -----------NON LEAF NODES DELETES-----------
    private static void testDeleteRoot() {
        System.out.println("Random Inserts and Deletes: Hopefully it tests something");
        AvlTree<Integer> tree = new AvlTree<>();

        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 13);

        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));

        tree.root = tree.removeNode(tree.root, 2);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 4);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 11);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 13);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 12);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 10);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 1);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 14);
        tree.root = tree.removeNode(tree.root, 100);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 6);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 3);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 9);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 9);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 7);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 8);
        print(tree.root);
        tree.root = tree.removeNode(tree.root, 5);
        print(tree.root);

        String result = newConsole.toString();
        System.setOut(previousConsole);

        if (result.equals(
                "[1:0:0] [3:2:1] [4:1:1] [5:0:0] [6:4:1] [7:1:1] [8:0:0] [9:2:-1] [10:0:0] [11:3:-1] [12:0:0] [13:1:0] [14:0:0] [1:0:0] [3:1:0] [5:0:0] [6:2:0] [7:1:1] [8:0:0] [9:3:0] [10:0:0] [11:2:1] [12:0:0] [13:1:0] [14:0:0] [1:0:0] [3:1:0] [5:0:0] [6:2:0] [7:1:1] [8:0:0] [9:3:0] [10:1:1] [12:0:0] [13:2:-1] [14:0:0] [1:0:0] [3:1:0] [5:0:0] [6:2:0] [7:1:1] [8:0:0] [9:3:-1] [10:0:0] [12:1:0] [14:0:0] [1:0:0] [3:1:0] [5:0:0] [6:2:0] [7:1:1] [8:0:0] [9:3:-1] [10:1:1] [14:0:0] [1:0:0] [3:1:0] [5:0:0] [6:3:1] [7:1:1] [8:0:0] [9:2:-1] [14:0:0] [3:1:1] [5:0:0] [6:3:1] [7:1:1] [8:0:0] [9:2:-1] [14:0:0] [3:1:1] [5:0:0] [6:2:0] [7:0:0] [8:1:0] [9:0:0] [3:0:0] [5:2:1] [7:0:0] [8:1:0] [9:0:0] [5:1:1] [7:0:0] [8:2:-1] [9:0:0] [5:0:0] [7:1:0] [8:0:0] [5:0:0] [7:1:0] [8:0:0] [5:1:1] [8:0:0] [5:0:0] ")) {
            System.out.println("\u001B[32mSuccess\u001B[0m");
        }
    }
}
