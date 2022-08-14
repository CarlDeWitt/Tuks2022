//carlie van wyk u21672823

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
        if(isEmpty())
            return false;
        TreeNode<T> p = root;

        return containsHelper(p, key);
    }

    /**
     * Insert the given key into the tree.
     * Duplicate keys should be ignored.
     * No Splaying should take place.
     */
    public void insert(T key) {
        // Your code here...
        if(contains(key)) {
            //duplicate, do nothing
        }
        else {
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
        /*if (root == null) {
            root = new TreeNode(key);
            return;
        }
        if ((contains(key))) {
            return;
        }
        addingdammnode(root, key);
    }
    public TreeNode<T> addingdammnode(TreeNode ptr, T key) {
        if (ptr == null) {
            ptr = new TreeNode(key);
            return ptr;
        }


        if (ptr.key.compareTo(key) < 0)
            ptr.right = addingdammnode(ptr.right, key);
        else if (ptr.key.compareTo(key) > 0)
            ptr.left = addingdammnode(ptr.left, key);
        return ptr;*/
    }

    /**
     * Return the Predecessor of the given key.
     * If the given key does not exist return null.
     * If the given key does not have a Predecessor, return null.
     */
    public T findPredecessor(T key) {
        // Your code here...
        if(isEmpty()) {
            //tree is empty
            return null;
        }
        else if (contains(key) == false) {
            //key does not exist
            return null;
        }
        else if (key.equals(root.key)) {
            //key has no predecessors since it is the root
            return null;
        }
        else {
            //has a predecessor
            TreeNode<T> p = root;
            TreeNode<T> prev = null;
            return findPredecessorHelper(p, prev, key);
        }
    }

    /**
     * Move the accessed key closer to the root using the splaying strategy.
     * If the key does not exist, insert it without splaying
     */
    public void access(T key) {
        // Your code here...
        if (contains(key)) {
            //key exists, apply splaying
            TreeNode<T> p = root;
            //accessHelper(p, key);
            DiSplayingItBaby(root,key);
        }
        else {
            //key does not exist, insert
            //also includes isEmpty == true
            this.insert(key);
        }
    }


    //helper functions:
    public boolean isEmpty(){
        if(root == null) {
            return true;
        }
        else
            return false;
    }

    protected boolean containsHelper(TreeNode<T> ptr, T theKey) {
        if(ptr != null) {
            containsHelper(ptr.left, theKey);
            if(ptr.key.equals(theKey)) {
                return true;
            }
            containsHelper(ptr.right, theKey);
        }
        return false;
    }

    public T findPredecessorHelper(TreeNode<T> ptr, TreeNode<T> prevPtr, T key) {
        if(ptr != null){
//            prevPtr = ptr;
            findPredecessorHelper(ptr.left, ptr, key);
            if(ptr.key.equals(key)) {
                return prevPtr.key;
            }
            findPredecessorHelper(ptr.right, ptr, key);
        }
        return null;
    }



    protected TreeNode rotateR(TreeNode x)
    {
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        root = y;
        return y;
       /* TreeNode L = x.left;
        TreeNode LR = L.right;

        root = L;
        L.right = x;
        x.left = LR;
        return L;*/
    }

    protected TreeNode rotateL(TreeNode x)
    {
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        root = y;
        return y;
        /*TreeNode R = x.right;
        TreeNode RL = R.left;

        root = R;
        R.left = x;
        x.right = RL;
        return R;*/
    }

    private TreeNode DiSplayingItBaby(TreeNode nodie, T val) {
        if (nodie == null || nodie.key == val)
            return nodie;

        // Key lies in left subtree
        if (nodie.key.compareTo(val) > 0)
        {
            if (nodie.left == null) {
                return nodie;
            }

            if (nodie.left.key.compareTo(val) > 0) {
                TreeNode dammnodie;
                dammnodie = DiSplayingItBaby(nodie.left.left, val);
                nodie.left.left = dammnodie;
                nodie = rotateR(nodie);
            } else if (nodie.left.key.compareTo(val) < 0) {
                TreeNode dammnodie;
                dammnodie = DiSplayingItBaby(nodie.left.right, val);
                nodie.left.right = dammnodie;
                if (nodie.left.right != null) {
                    nodie.left = rotateL(nodie.left);
                }
            }
            if (nodie.left == null) {
                return nodie;
            } else {
                return rotateR(nodie);
            }
        }
        else
        {
            if (nodie.right == null)
                return nodie;

            if (nodie.right.key.compareTo(val) > 0) {
                TreeNode dammnodie;
                dammnodie = DiSplayingItBaby(nodie.right.left, val);
                nodie.right.left = dammnodie;
                if (nodie.right.left != null)
                    nodie.right = rotateR(nodie.right);
            } else if (nodie.right.key.compareTo(val) < 0) {
                TreeNode dammnodie;
                dammnodie = DiSplayingItBaby(nodie.right.right, val);
                nodie.right.right = dammnodie;
                nodie = rotateL(nodie);
            }
            if (nodie.right == null) {
                return nodie;
            } else {
                return rotateL(nodie);
            }
        }
    }

    protected TreeNode accessHelper(TreeNode<T> ptr, T theKey)
    {
       /* if (theKey.equals(root.key)) {
            //do nothing since key is already @ root
        }

        // Key lies in left subtree
        if (theKey.compareTo(ptr.key) > 0)
        {
            // Zig-Zig (Left Left)
            if (theKey.compareTo(ptr.left.key) > 0)
            {
                // First recursively bring the
                // key as root of left-left
                ptr.left.left = accessHelper(ptr.left.left, theKey);          //?????????????????????

                // Do first rotation for root,
                // second rotation is done after else
                ptr = rotateR(ptr);
            }
            else if (theKey.compareTo(ptr.left.key) < 0)// Zig-Zag (Left Right)
            {
                // First recursively bring
                // the key as root of left-right
                ptr.left.right = accessHelper(ptr.left.right, theKey);                       //??????????????????????/

                // Do first rotation for root.left
                if (ptr.left.right != null)
                    ptr.left = rotateL(ptr.left);
            }

            // Do second rotation for root
            if (ptr.left == null) {
                return ptr;
            }
            else {
                return rotateR(ptr);
            }
        }
        else // Key lies in right subtree
        {
            if(ptr)
            // Zag-Zig (Right Left)
            if (theKey.compareTo(ptr.right.key) < 0)
            {
                // Bring the key as root of right-left
                ptr.right.left = accessHelper(ptr.right.left, theKey);                 //??????????????????????

                // Do first rotation for root.right
                if (ptr.right.left != null)
                    ptr.right = rotateR(ptr.right);
            }
            else if (theKey.compareTo(ptr.right.key) > 0)// Zag-Zag (Right Right)
            {
                // Bring the key as root of
                // right-right and do first rotation
                ptr.right.right = accessHelper(ptr.right.right, theKey);        //??????????????????????
                ptr = rotateL(ptr);
            }

            // Do second rotation for root
            if (ptr.right == null) {
                return ptr;
            }
            else {
                return rotateL(ptr);
            }
        }*/
        if (ptr == null || ptr.key == theKey)
            return ptr;

        // Key lies in left subtree
        if (ptr.key.compareTo(theKey) > 0)
        {
            // Key is not in tree, we are done
            if (ptr.left == null) return ptr;

            // Zig-Zig (Left Left)
            if (ptr.left.key.compareTo(theKey) > 0)
            {
                // First recursively bring the
                // key as root of left-left
                ptr.left.left = accessHelper(ptr.left.left, theKey);

                // Do first rotation for root,
                // second rotation is done after else
                ptr = rotateR(ptr);
            }
            else if (ptr.left.key.compareTo(theKey) < 0) // Zig-Zag (Left Right)
            {
                // First recursively bring
                // the key as root of left-right
                ptr.left.right = accessHelper(ptr.left.right, theKey);

                // Do first rotation for root.left
                if (ptr.left.right != null)
                    ptr.left = rotateL(ptr.left);
            }

            // Do second rotation for root
            return (ptr.left == null) ?
                    ptr : rotateR(ptr);
        }
        else // Key lies in right subtree
        {
            // Key is not in tree, we are done
            if (ptr.right == null) return ptr;

            // Zag-Zig (Right Left)
            if (ptr.right.key.compareTo(theKey) > 0)
            {
                // Bring the key as root of right-left
                ptr.right.left = accessHelper(ptr.right.left, theKey);

                // Do first rotation for ptr.right
                if (ptr.right.left != null)
                    ptr.right = rotateR(ptr.right);
            }
            else if (ptr.right.key.compareTo(theKey) < 0)// Zag-Zag (Right Right)
            {
                // Bring the key as root of
                // right-right and do first rotation
                ptr.right.right = accessHelper(ptr.right.right, theKey);
                ptr = rotateL(ptr);
            }

            // Do second rotation for root
            return (ptr.right == null) ?
                    ptr : rotateL(ptr);
        }
    }

}