public class AvlTree<T extends Comparable<T>> {
    public Node<T> root;

    public AvlTree() {
        this.root = null;
    }


    int getHeight(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    /*Printing AvlTree in inorder*/
    void print(Node<T> node) {
        if (node == null)
            return;

        print(node.left);

        System.out.print(node.data + " ");

        print(node.right);
    }

    /* Do not edit the code above */

    /**
     * Insert the given data into the tree.
     * Duplicate data is not allowed. just return the node.
     */

    Node<T> insert(Node<T> node, T data) {
        Node<T> newnode;
        if (root == null) {
            newnode = new Node(data);
//            newnode.height = 1;
            root = newnode;
            return root;
        }

        if (node == null) {
            newnode = new Node(data);
//            newnode.height = 1;
            return newnode;
        }
        if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            newnode = new Node(data);
            return newnode;
        }

        //heigth of the node
        node.height = 1 + getheights(node);

        //get the balance of the node
        //bf = balance factor
        int bf = 0;
        if (node != null) {
            int LH = 0;
            int RH = 0;
            if (node.left != null) {
                LH = node.left.height;
            }

            if (node.right != null) {
                RH = node.right.height;
            }
            bf = LH - RH;
        }

        String balanceMove = balanceTheNode(node, bf, data);

        if (balanceMove == "LL") {
            return rotateR(node);

        }
        if (balanceMove == "RR") {
            return rotateL(node);

        }

        if (balanceMove == "RL") {
            node.left = rotateL(node.left);
            return rotateR(node);

        }
        if (balanceMove == "LR") {
            node.right = rotateR(node.right);
            return rotateL(node);
        }

        return node;
    }


    /**
     * Remove / Delete the node based on the given data
     * Return the node / root if the data do not exist
     */

    Node<T> removeNode(Node<T> root, T data) {
        Node<T> realRoot=root;
        if (isRootEmpty(root)){
            return root;
        }

//        root = firstDeleteHelp(root,data);
        /*add shit here for plagrism!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                        !!!!!!!!!!!!!!!!!!!!!!!!!
                                                !!!!!!!!!!!!!!!!!*/
        if (data.compareTo(root.data) > 0)
            root.right = removeNode(root.right, data);
        else if (data.compareTo(root.data) < 0)
            root.left = removeNode(root.left, data);
        else {
            root = removeTheLinks(root);
        }

//        root = removeTheLinks(root);

        if (isRootEmpty(root)){
            return root;
        }


        //update the height of the tree
        root.height = 1 + getheights(root);

        //get the balance fatctor of the root
        int bf = 0;
        if (root != null) {
            int LH = 0;
            int RH = 0;
            if (root.left != null) {
                LH = root.left.height;
            }

            if (root.right != null) {
                RH = root.right.height;
            }
            bf = LH - RH;
        }

        //go and check for nescaseray rotations
        String balanceMove = balanceTheNode(root, bf, data);
        if (balanceMove.substring(0,1) == "L") {
            if(balanceMove.substring(1,2) ==  "L")
                return rotateR(root);
            else{
                root.right = rotateR(root.right);
                return rotateL(root);
            }
        }
        if (balanceMove.substring(0,1) == "R") {
            if(balanceMove.substring(1,2) == "R")
                return rotateL(root);
            else{
                root.left = rotateL(root.left);
                return rotateR(root);
            }
        }
        return root;
    }

    //helper functions
    /*----------------------------------------------rotate node right--------------------------------------*/
    private Node rotateR(Node<T> node) {
        Node<T> tempNodeLeft = node.left;
        node.left = tempNodeLeft.right;
        tempNodeLeft.right = node;
        root = tempNodeLeft;

        node.height = getheights(node) +1 ;
        tempNodeLeft.height = getheights(tempNodeLeft) + 1;

        return tempNodeLeft;
    }

    /*--------------------------rotate node left---------------------------*/
    private Node rotateL(Node<T> node) {
        Node<T> tempNodeRight = node.right;
        node.right = tempNodeRight.left;
        tempNodeRight.left = node;
        root = tempNodeRight;

        node.height = getheights(node) +1;
        tempNodeRight.height = getheights(tempNodeRight) + 1;

        return tempNodeRight;
    }

    /*----------------------Helper to make balance rotations-------------------------*/
    //bf == balnceFactor
    //data is the data from the insert function
    private String balanceTheNode(Node<T> node, int bf, T data) {

        if (bf > 1) {
            if (data.compareTo(node.left.data) < 0)
                return "LL";
            else
                return "LR";
        } else if (bf < -1) {
            if (data.compareTo(node.right.data) > 0)
                return "RR";
            else
                return "RL";
        }
        return "N";
    }

    /*-----------------------node height helper function----------------*/
    private int getheights(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = node.left.height;
        }else{
            leftHeight= -1;
        }

        if (node.right != null) {
            rightHeight = node.right.height;
        }else {
            rightHeight = -1;
        }

        //check which height to return
        if (leftHeight > rightHeight) {
            return leftHeight;
        } else {
            return rightHeight;
        }
    }

    /*------------function helps with delete-----------------*/
    private Node removeTheLinks(Node<T> node) {
        T holdem = null;
        if (node.left == null && node.right != null) {
            holdem = node.right.data;
            node.right = null;
            node.data = holdem;
        } else if (node.right == null && node.left != null) {
            holdem = node.left.data;
            node.left = null;
            node.data = holdem;
        } else if (node.left == null && node.right == null) {
            node = null;
        } else {
            Node<T> leftMOSTrightNode = node.left;
            Node<T> replacementValue = null;
            T value;
            while (leftMOSTrightNode.right != null) {
                leftMOSTrightNode = leftMOSTrightNode.right;
            }
            replacementValue = leftMOSTrightNode;
            node.data = replacementValue.data;
            value = replacementValue.data;
            removeNode(node.left, value);

        }
        return node;
    }

    /*--------------isempty function------------------*/
    private boolean isRootEmpty(Node<T> node){
        return node == null;
    }

    /*--------------helper function for first part of delete----------------*/
    private Node<T> firstDeleteHelp(Node<T> node,T data){
        while( node != null){
            if(node.data == data){
                return node;
            }
            else if(data.compareTo(root.data) < 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return null;
    }

}
