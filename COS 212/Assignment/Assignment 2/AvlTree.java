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
        if (node == null) {
            newnode = new Node(data);
            newnode.height = 0;
//            root = newnode;
            return newnode;
        }

        Node<T> veryTemp;
        if (data.compareTo(node.data) > 0 ) {
            veryTemp = insert(node.right, data);
//            System.out.println(veryTemp);
            node.right = veryTemp;
        } else if (data.compareTo(node.data) < 0) {
            veryTemp = insert(node.left, data);
            //            System.out.println(veryTemp);
            node.left = veryTemp;
        } else if(data.compareTo(node.data) > 0 && node.rightThread == true) {

        }else {
            return node;
        }

        //heigth of the node
        int hgt;
        hgt= getheights(node);
        int saveHGT;
        hgt++;
        saveHGT= hgt;
//        System.out.println(hgt);
        node.height = hgt;

        //get the balance of the node
        //bf = balance factor
        int bf = 0;
        bf = BF(node);
//        if (node != null) {
//            int LH = 0;
//            int RH = 0;
//            if (node.left != null) {
//                LH = node.left.height +1;
//            }
//
//            if (node.right != null) {
//                RH = node.right.height + 1;
//            }
//            bf = LH - RH;
//        }
//        System.out.println("please update this doc before submit");

        String balanceMove = balanceTheNode(node, bf, data);
        String nm1 = "", nm2 = "";
        if(balanceMove !="N") {
            nm1 = balanceMove.substring(0, 1);
            nm2 = balanceMove.substring(1, 2);
        }
      if (balanceMove == "LL") {
//            System.out.println("LL");
            return rotateR(node);

        }
        if (balanceMove == "RR") {
//            System.out.println("RR");
            return rotateL(node);

        }
        if (balanceMove == "RL") {
//            System.out.println("RL");
            node.right = rotateR(node.right);
            return rotateL(node);
        }
        if (balanceMove == "LR") {
//            System.out.println("LR");
            node.left = rotateL(node.left);
            return rotateR(node);
        }

        return node;
    }
    private int BF(Node<T> node){
        if (node != null) {
            int LH = 0;
            int RH = 0;
            if (node.left != null) {
                LH = node.left.height + 1;
            }

            if (node.right != null) {
                RH = node.right.height + 1;
            }

            return LH - RH;
        }
        return 0;
    }


    /**
     * Remove / Delete the node based on the given data
     * Return the node / root if the data do not exist
     */
    Node<T> ogroot;
    Node<T> removeNode(Node<T> root, T data) {
        ogroot=root;
        if (root == null) {
            return root;
        }

//        root = firstDeleteHelp(root,data);
        Node<T> veryTemp = null;
        if (data.compareTo(root.data) > 0) {
            veryTemp = removeNode(root.right, data);
//            System.out.println(veryTemp);
            root.right = veryTemp;
        } else if (data.compareTo(root.data) < 0) {
            veryTemp = removeNode(root.left, data);
//            System.out.println(veryTemp);
            root.left = veryTemp;
        }
        else {
            root = removeTheLinks(root);
        }

//        root = removeTheLinks(root);

        if (isRootEmpty(root)){
            return root;
        }

        //update the height of the tree
        int hgt;
        hgt= getheights(root);
        int saveHGT;
        saveHGT= hgt;
        hgt++;
//        System.out.println(hgt);
        root.height = hgt;

        //get the balance fatctor of the root
        int bf = 0;
        bf = BF(root);

        //go and check for nescaseray rotations
        String balanceMove = balanceTheNode(root, bf, data);
        String nm1 = "", nm2 = "";
        if(balanceMove !="N") {
            nm1 = balanceMove.substring(0, 1);
            nm2 = balanceMove.substring(1, 2);
        }

        if (balanceMove == "LL") {
//            System.out.println("LL");
            return rotateR(root);

        }
        if (balanceMove == "RR") {
//            System.out.println("RR");
            return rotateL(root);

        }
        if (balanceMove == "RL") {
//            System.out.println("RL");
            root.right = rotateR(root.right);
            return rotateL(root);
        }
        if (balanceMove == "LR") {
//            System.out.println("LR");
            root.left = rotateL(root.left);
            return rotateR(root);
        }
        return root;
    }

    //helper functions
    /*----------------------------------------------rotate node right--------------------------------------*/
    private Node rotateR(Node<T> node) {
        Node<T> holder;
        holder = node.left;
        Node<T> tempNodeLeft = holder;
        Node<T> holder2;
        holder2 = tempNodeLeft.right;
        node.left = holder2;
        int heightOFtemp=0;
        tempNodeLeft.right = node;
        int heightOFnode=0;
//        root = tempNodeLeft;

        node.height = getheights(node) + 1;
        heightOFnode = getheights(node) + 1;
        //        System.out.println(heightOFnode);
        tempNodeLeft.height = getheights(tempNodeLeft) + 1;
        heightOFtemp = getheights(node) + 1;
//        System.out.println(heightOFtemp);


        return tempNodeLeft;
    }

    /*--------------------------rotate node left---------------------------*/
    private Node rotateL(Node<T> node) {
       Node<T> holder;
        holder =node.right;
        Node<T> tempNodeRight = holder;
        Node<T> holder2;
        holder2 = tempNodeRight.left;
        node.right = holder2;
        int heightOFtemp=0;
        int heightOFnode=0;
        tempNodeRight.left = node;
//        root = tempNodeRight;

        node.height = getheights(node) + 1;
        heightOFnode = getheights(node) + 1;
        //        System.out.println(heightOFnode);
        tempNodeRight.height = getheights(tempNodeRight) + 1;
        heightOFtemp = getheights(node) + 1;
//        System.out.println(heightOFtemp);

//        heightOFnode = getheights(node) + 1;
//        //        System.out.println(heightOFnode);
//        tempNodeRight.height = getheights(tempNodeRight) + 1;
//        heightOFtemp = getheights(node) + 1;
        return tempNodeRight;
    }

    /*----------------------Helper to make balance rotations-------------------------*/
    //bf == balnceFactor
    //data is the data from the insert function
    private String balanceTheNode(Node<T> node, int bf, T data) {

        if (bf > 1) {
            if (BF(node.left) >= 0)
                return "LL";
            else
                return "LR";
        } else if (bf < -1) {
            if (BF(node.right) <= 0)
                return "RR";
            else
                return "RL";
        }
        return "N";
    }

    /*-----------------------node height helper function----------------*/
    private int getheights(Node<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = node.left.height;
        }else{
            leftHeight = -1;
        }

        if (node.right != null) {
            rightHeight = node.right.height;
        }else
            rightHeight= -1;

        //check which height to return
        if (leftHeight > rightHeight) {
            return leftHeight;
        } else {
            return rightHeight;
        }
    }

    /*------------function helps with delete-----------------*/
    private Node removeTheLinks(Node<T> node) {
//        System.out.println("this is og root");
//        System.out.println(ogroot.data);
//        System.out.println("this was og root");
        ogroot = ogroot;
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
//            Node<T> holderOfLeft = leftMOSTrightNode;
            Node<T> replacementValue = null;
            T value;
            while (leftMOSTrightNode.right != null) {
                leftMOSTrightNode = leftMOSTrightNode.right;
            }
            replacementValue = leftMOSTrightNode;
            node.data = replacementValue.data;
            value = replacementValue.data;
            node.left = removeNode(ogroot.left, value);

        }
        return node;
    }

    /*--------------isempty function------------------*/
    private boolean isRootEmpty(Node<T> node){
        return node == null;
    }

}


