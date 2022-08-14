import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SuppressWarnings({ "unused" })
public class main2<T extends Comparable<T>> {
    public static void main(String[] args) {
        testSuperMegaRandomTreeAndHopeForTheBest();
    }

    private static void print(Node<Integer> node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print("[" + node.data + ":" + node.height + ":" + getBalanceFactor(node) + ":" + node.rightThread + "] ");
        if(node.rightThread == false){
            print(node.right);
        }
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
        if (node != null) {
            int LH = 0;
            int RH = 0;
            if (node.left != null) {
                LH = node.left.height + 1;
            }

            if (node.right != null && node.rightThread == false) {
                RH = node.right.height + 1;
            }

            return LH - RH;
        }
        return 0;
    }

    private static int getHeight(Node<Integer> node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    // -----------NON LEAF NODES DELETES-----------
    public static void testSuperMegaRandomTreeAndHopeForTheBest() {
        ThreadedAvlTree<Integer> tree = new ThreadedAvlTree<>();

        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 65);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 82);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 91);
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 25);
        print(tree.root);
        System.out.println();

        /*tree.root = tree.insert(tree.root, 'F');
        tree.root = tree.insert(tree.root, 'O');
        tree.root = tree.insert(tree.root, 'C');
        tree.root = tree.insert(tree.root, 'D');
        tree.root = tree.insert(tree.root, 'G');
        tree.root = tree.insert(tree.root, 'X');
        tree.root = tree.insert(tree.root, 'H');
        tree.root = tree.insert(tree.root, 'Q');
        tree.root = tree.insert(tree.root, 'U');
        tree.root = tree.insert(tree.root, 'T');
        tree.root = tree.insert(tree.root, 'M');
        tree.root = tree.insert(tree.root, 'A');
        tree.root = tree.insert(tree.root, 'Z');
        tree.root = tree.insert(tree.root, 'N');
        tree.root = tree.insert(tree.root, 'K');
        tree.root = tree.insert(tree.root, 'B');
        tree.root = tree.insert(tree.root, 'W');
        tree.root = tree.insert(tree.root, 'J');
        tree.root = tree.insert(tree.root, 'Y');
        tree.root = tree.insert(tree.root, 'L');
        tree.root = tree.insert(tree.root, 'I');
        tree.root = tree.insert(tree.root, 'E');
        tree.root = tree.insert(tree.root, 'P');
        tree.root = tree.insert(tree.root, 'R');
        tree.root = tree.insert(tree.root, 'S');
        tree.root = tree.insert(tree.root, 'V');

        print(tree.root);
        System.out.println();

        tree.root = tree.removeNode(tree.root, 'L');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'Z');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'D');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'E');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'F');
        tree.root = tree.removeNode(tree.root, 'F');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'I');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'X');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'M');
        tree.root = tree.removeNode(tree.root, 'X');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'O');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'G');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'A');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'J');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'K');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'B');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'W');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'Y');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'C');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'S');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'Q');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'V');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'N');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'H');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'P');
        tree.root = tree.removeNode(tree.root, ' ');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'R');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'T');
        print(tree.root);
        System.out.println();
        tree.root = tree.removeNode(tree.root, 'U');
        print(tree.root);
        System.out.println();*/

    }
}


/*
[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [L:0:0] [M:1:0] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:0] [Y:0:0] [Z:1:-1]
[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:0] [Y:0:0] [Z:1:-1]
[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:1:1] [B:0:0] [C:2:-1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:0] [C:0:0] [F:2:-1] [G:0:0] [H:3:0] [I:0:0] [J:1:-1] [K:2:0] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [I:0:0] [J:1:-1] [K:2:0] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [J:0:0] [K:2:1] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [J:0:0] [K:2:1] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:-1] [J:0:0] [K:1:0] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:-1] [J:0:0] [K:1:-1] [N:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:0] [C:0:0] [H:2:0] [J:0:0] [K:1:-1] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:1:1] [C:0:0] [H:2:0] [J:0:0] [K:1:-1] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:1:1] [C:0:0] [H:2:-1] [K:0:0] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:0:0] [C:1:0] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:0:0] [W:1:0] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:0:0] [W:1:0] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:1:1] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:0] [P:0:0] [Q:3:1] [R:0:0] [S:1:0] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:0] [P:0:0] [Q:3:1] [R:1:1] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:-1] [P:3:1] [R:1:1] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:-1] [P:2:0] [R:0:0] [T:1:0] [U:0:0]
[H:0:0] [P:2:1] [R:0:0] [T:1:0] [U:0:0]
[P:1:1] [R:0:0] [T:2:-1] [U:0:0]
[R:0:0] [T:1:0] [U:0:0]
[T:1:1] [U:0:0]
[U:0:0]

[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [L:0:0] [M:1:0] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:0] [Y:0:0] [Z:1:-1]
[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:0] [Y:0:0] [Z:1:-1]
[A:1:1] [B:0:0] [C:2:0] [D:1:1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:1:1] [B:0:0] [C:2:-1] [E:0:0] [F:4:1] [G:0:0] [H:2:1] [I:0:0] [J:1:-1] [K:3:-1] [M:1:1] [N:0:0] [O:5:-1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:0] [C:0:0] [F:2:-1] [G:0:0] [H:3:0] [I:0:0] [J:1:-1] [K:2:0] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [I:0:0] [J:1:-1] [K:2:0] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [J:0:0] [K:2:1] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:0] [V:0:0] [W:1:-1] [X:2:-1] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:0] [J:0:0] [K:2:1] [M:1:1] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:-1] [J:0:0] [K:1:0] [N:0:0] [O:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:-1] [C:2:-1] [G:0:0] [H:3:-1] [J:0:0] [K:1:-1] [N:4:0] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[A:0:0] [B:1:0] [C:0:0] [H:2:0] [J:0:0] [K:1:-1] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:1:1] [C:0:0] [H:2:0] [J:0:0] [K:1:-1] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:1:1] [C:0:0] [H:2:-1] [K:0:0] [N:4:1] [P:0:0] [Q:2:1] [R:0:0] [S:1:0] [T:0:0] [U:3:-1] [V:0:0] [W:1:0] [Y:0:0]
[B:0:0] [C:1:0] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:0:0] [W:1:0] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:0:0] [W:1:0] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:0] [V:1:1] [Y:0:0]
[C:1:1] [H:0:0] [N:2:-1] [P:0:0] [Q:3:0] [R:0:0] [S:1:0] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:0] [P:0:0] [Q:3:1] [R:0:0] [S:1:0] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:0] [P:0:0] [Q:3:1] [R:1:1] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:-1] [P:3:1] [R:1:1] [T:0:0] [U:2:-1] [V:0:0]
[H:0:0] [N:1:-1] [P:2:0] [R:0:0] [T:1:0] [U:0:0]
[H:0:0] [P:2:1] [R:0:0] [T:1:0] [U:0:0]
[P:1:1] [R:0:0] [T:2:-1] [U:0:0]
[R:0:0] [T:1:0] [U:0:0]
[T:1:1] [U:0:0]
[U:0:0]


Process finished with exit code 0


*/
