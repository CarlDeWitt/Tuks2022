public class ThreadedAvlTree<T extends Comparable<T>> {
    public Node<T> root;

    public ThreadedAvlTree() {
        this.root = null;
    }


    int getHeight(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    static Node getLeftMost(Node node) {
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }

    // Inorder traversal of a threaded avl tree
    void print(Node<T> node) {
        if (node == null)
            return;

        Node<T> cur = getLeftMost(node);

        while (cur != null) {
            System.out.print(" " + cur.data + " ");


            if (cur.rightThread == true)
                cur = cur.right;
            else 
                cur = getLeftMost(cur.right);
        }
    }

    /* Do not edit the code above */


//    void convertAVLtoThreaded(Node<T> node) {
//
//    }

    /**
     * Insert the given data into the tree.
     * Duplicate data is not allowed. just return the node.
     */

//
//    Node<T> insert(Node<T> node, T data) {
//
//    }

    /**
     * Delete the given element \texttt{data} from the tree.  Re-balance the tree after deletion.
     * If the data is not in the tree, return the given node / root.
     */
//    Node<T> removeNode(Node<T> root, T data) {
//
//    }
}
