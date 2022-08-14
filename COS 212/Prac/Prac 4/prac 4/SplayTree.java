public class SplayTree<T extends Comparable<T>> {

    public TreeNode<T> root;

    public SplayTree() {
        // Your code here...
    }

    /**
     * Returns true if the key exists in the tree, otherwise false
     */
    public Boolean contains(T key) {
        // Your code here...
        if (root == null) {
            return false;
        }
        TreeNode<T> testCOntains = helpingContains(root,key);
        if(testCOntains != null && testCOntains.key.equals(key)){
            return true;
        }else
            return false;
    }

   private TreeNode<T> helpingContains(TreeNode<T> helpme,T key){
       while (helpme != null) {
           if (key.equals(helpme.key)) {
               return helpme;
           } else if (key.compareTo(helpme.key) < 0) {
               helpme = helpme.left;
           } else {
               helpme = helpme.right;
           }
       }
       return helpme;
   }

    /**
     * Insert the given key into the tree.
     * Duplicate keys should be ignored.
     * No Splaying should take place.
     */
    public void insert(T key) {
        if (contains(key)) {
            //duplicate, do nothing
        } else {
            TreeNode<T> p = root, prev = null;
            while (p != null) {
                prev = p;
                if (key.compareTo(p.key) < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (root == null) {
                root = new TreeNode<T>(key);
            } else if (key.compareTo(prev.key) < 0) {
                prev.left = new TreeNode<T>(key);
            } else {
                prev.right = new TreeNode<T>(key);
            }
        }
        // Your code here...
    }

    /**
     * Return the Predecessor of the given key.
     * If the given key does not exist return null.
     * If the given key does not have a Predecessor, return null.
     */
    public T findPredecessor(T key) {
       return root.key;
    }

    /**
     * `
     * Move the accessed key closer to the root using the splaying strategy.
     * If the key does not exist, insert it without splaying
     */
    public void access(T key) {
        // Your code here...
        if (contains(key)) {
            //key exists, apply splaying
            TreeNode<T> p = root;
            accessHelper(p, key);
        } else {
            //key does not exist, insert
            //also includes isEmpty == true
            this.insert(key);
        }

    }

    protected TreeNode accessHelper(TreeNode<T> ptr, T theKey) {
        if (ptr == null)
            return ptr;
        if (ptr.key == theKey)
            return ptr;
        TreeNode TN;

        if (ptr.key.compareTo(theKey) > 0) {

            if (ptr.left != null) {

                if (ptr.left.key.compareTo(theKey) > 0) {
                    TN = accessHelper(ptr.left.left, theKey);
                    ptr.left.left = TN;


                    ptr = rotateR(ptr);
                } else if (ptr.left.key.compareTo(theKey) < 0) {
                    TN = accessHelper(ptr.left.right, theKey);
                    ptr.left.right = TN;


                    if (ptr.left.right != null)
                        TN = rotateL(ptr.left);
                    ptr.left = TN;
                }

                if (ptr.left != null)
                    return rotateR(ptr);
                else
                    return ptr;
            } else
                return ptr;

        } else {

            if (ptr.right != null) {

                if (ptr.right.key.compareTo(theKey) > 0) {
                    TN = accessHelper(ptr.right.left, theKey);
                    ptr.right.left = TN;

                    if (ptr.right.left != null)
                        TN = rotateR(ptr.right);
                    ptr.right = TN;
                } else if (ptr.right.key.compareTo(theKey) < 0) {
                    TN = accessHelper(ptr.right.right, theKey);
                    ptr.right.right = TN;
                    ptr = rotateL(ptr);
                }

                if (ptr.right != null)
                    return rotateL(ptr);
                else
                    return ptr;
            } else {
                return ptr;
            }
        }
    }

    protected TreeNode rotateR(TreeNode x) {
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        root = y;
        return y;
    }

    protected TreeNode rotateL(TreeNode node) {
        TreeNode y = node.right;
        node.right = y.left;
        y.left = node;
        root = y;
        return y;
    }
}