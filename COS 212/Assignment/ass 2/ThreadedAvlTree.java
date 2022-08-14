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

    Node<T> getLeftMost(Node<T> node) {
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


    void convertAVLtoThreaded(Node<T> node) {
        int rootheight;
        rootheight= node.height;
        root = node;
        for(int i =1; i<=rootheight +1;i++){
            BFT(node, i);
        }
        return;
    }

    void BFT(Node<T> node, int level)
    {
        if (node == null)
            return;
        if (level == 1){
            if(node.data != null){
                insert(root,node.data);
            }
        }

        else if (level > 1) {
            BFT(node.left, level - 1);
            BFT(node.right, level - 1);
        }
    }

    Node<T> insert(Node<T> node, T data) {
        Node<T> newnode;
        if (node == null) {
            newnode = new Node(data);
            newnode.height = 0;
//            root = newnode;
            return newnode;
        }

        Node<T> veryTemp;
        if (data.compareTo(node.data) > 0 && node.rightThread == false) {
            veryTemp = insert(node.right, data);
            node.right = veryTemp;
            if(veryTemp.right == null && veryTemp.rightThread == false && getTheSuc(root, veryTemp.data) != null){
                veryTemp.right = getTheSuc(root, veryTemp.data);
                veryTemp.rightThread = true;
            }
        } else if (data.compareTo(node.data) < 0) {
            veryTemp = insert(node.left, data);
            node.left = veryTemp;
            if(veryTemp.right == null && veryTemp.rightThread == false && getTheSuc(root, veryTemp.data) != null){
                veryTemp.right = getTheSuc(root, veryTemp.data);
                veryTemp.rightThread = true;
            }
        }else if (data.compareTo(node.data) > 0 && node.rightThread == true){
            newnode = new Node(data);
            newnode.height =0;
            node.right = newnode;
            node.rightThread = false;
//            node.height++;
            //assign new node thread
            int hgt;
            hgt= getheights(node);
            int saveHGT;
            hgt++;
            saveHGT= hgt;
            node.height = hgt;
            Node<T> temp = getTheSuc(root, newnode.data);
            if(temp != null) {
                if (temp.equals(newnode)) {
                    newnode.rightThread = false;
                } else {
                    newnode.right = getTheSuc(root, newnode.data);
                    newnode.rightThread = true;
                }
            }

            return node;
        } else {
            return node;
        }

        //heigth of the node
        int hgt;
        hgt= getheights(node);
        int saveHGT;
        hgt++;
        saveHGT= hgt;
        node.height = hgt;

        //get the balance of the node
        //bf = balance factor
        int bf = 0;
        bf = BF(node);

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
        else if(node.rightThread == false && node.right == null && getTheSuc(root, veryTemp.data) != null){
            Node<T> temp = getTheSuc(root, veryTemp.data);
            if(temp != null && temp.equals(node)){
                node.rightThread = false;
//                System.out.println(node.data);
            }else if(temp != null){
            node.right = getTheSuc(root, veryTemp.data);
            node.rightThread = true;
            }
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

            if (node.right != null && node.rightThread == false) {
                RH = node.right.height + 1;
            }

            return LH - RH;
        }
        return 0;
    }

    public Node<T> getTheSuc(Node<T> node, T key) {
        Node<T> temp = null;
        if (node == null) {
            return null;
        }

        Node<T> sucNode = null;

        while (true) {
            if (key.compareTo((T) node.data) > 0) {
                temp = node.right;
//                System.out.println(temp);
                node = temp;
            }

            else if (key.compareTo((T) node.data) < 0) {
                temp = node;
                //                System.out.println(temp);
                sucNode = temp;
                //                System.out.println(temp);
                node = temp.left;
            }

            else {
                if (node.right != null && node.rightThread == false) {
                    temp = findMinimum(node.right);
                    sucNode = temp;
                }
                break;
            }

            if (root == null) {
                return sucNode;
            }
        }
        return sucNode;
    }
private Node<T> findMinimum(Node<T> node)
{
    while (node.left != null) {
        node = node.left;
    }

    return node;
}

    /**
     * Remove / Delete the node based on the given data
     * Return the node / root if the data do not exist
     */
    Node<T> ogroot;
    Node<T> removeNode(Node<T> root, T data) {
            Node<T> newroot;
           dethread(root);
          newroot = removeHelper(root,data);
          if(newroot != null){
              dethread(newroot);
              convertAVLtoThreaded(newroot);
          }
//        System.out.println(root.data);
          return newroot;
    }

    private void dethread(Node<T> node){
            if (node == null)
                return;

        dethread(node.left);
        if(node.rightThread == true){
            node.right = null;
            node.rightThread = false;
        }
        dethread(node.right);
    }

    private Node<T> removeHelper(Node<T> root,T data){
        ogroot=root;
        if (root == null) {
            return root;
        }

//        root = firstDeleteHelp(root,data);
        Node<T> veryTemp = null;
        if (data.compareTo(root.data) > 0) {
            veryTemp = removeHelper(root.right, data);
//            System.out.println(veryTemp);
            root.right = veryTemp;
        } else if (data.compareTo(root.data) < 0) {
            veryTemp = removeHelper(root.left, data);
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
    private Node<T> rotateR(Node<T> node) {
        if(node.rightThread == true){
            node.right = null;
            node.rightThread = false;
        }
        if(node.left.rightThread == true){
            node.left.right = null;
            node.left.rightThread = false;
        }
        Node<T> holder = node.left;
        Node<T> tempNodeLeft = holder;
        Node<T> holder2 =tempNodeLeft.right;
        node.left = holder2;
        tempNodeLeft.right = node;

        //reassign the right node
        if(node.right == null){
            Node<T> temp = getTheSuc(root, node.data);
            if(temp != null && temp.equals(node)){
                node.rightThread = false;
//                System.out.println("here");
            }else{
                node.right = getTheSuc(root, node.data);
                node.rightThread = true;
            }
        }

        node.height = getheights(node) + 1;
        tempNodeLeft.height = getheights(tempNodeLeft) + 1;

        return tempNodeLeft;
    }

    /*--------------------------rotate node left---------------------------*/
    private Node<T> rotateL(Node<T> node) {
        Node<T> holder =node.right;
        Node<T> tempNodeRight = holder;
        Node<T> holder2 = tempNodeRight.left;
        node.right = holder2;
        tempNodeRight.left = node;

        if(node.right == null && node.rightThread == false){
            node.right = holder;
            node.rightThread = true;
        }

        node.height = getheights(node) + 1;
        tempNodeRight.height = getheights(tempNodeRight) + 1;

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

        if (node.right != null && node.rightThread == false) {
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
    private Node<T> removeTheLinks(Node<T> node) {
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
            while (leftMOSTrightNode.right != null && node.rightThread == false) {
                leftMOSTrightNode = leftMOSTrightNode.right;
            }
            replacementValue = leftMOSTrightNode;
            node.data = replacementValue.data;
            value = replacementValue.data;
            node.left = removeHelper(ogroot.left, value);

        }
        return node;
    }

    /*--------------isempty function------------------*/
    private boolean isRootEmpty(Node<T> node){
        return node == null;
    }

}
