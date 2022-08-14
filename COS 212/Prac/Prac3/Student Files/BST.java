public class BST<T extends Comparable<T>> {
    protected BSTNode<T> root;

    public BST(){};
    int count = 0;
    String str= "";
    int[] intarr = new int[100];
    int testingcount=0;
    int i=0;
    int toarrCount=0;

    public boolean insert(T val){
        if(root == null){
            root = new BSTNode<>(val);
            return true;
        } else {
            return root.recInsert(val);
        }
    }

    //Place code below

//    public void testprint(){
//        BSTNode<T> temp = root;
//        System.out.println(temp.right.left.right.getVal());
//    }

    public int numNodes(){
        count = 0;
        return countkak(root) ;
    }

    public Object[] toArray(){
        if(root == null){
            return null;
        }
        toarrCount=0;
        Object[] obj1 = new Object[numNodes()];
        toArrayHelper(root,obj1);
        return obj1;
    }

    public void toArrayHelper(BSTNode p, Object[] obj1){
        if(p != null){
            toArrayHelper(p.left,obj1);
            obj1[toarrCount] = (BSTNode<T>) p;
            toarrCount++;
            toArrayHelper(p.right,obj1);
        }
        return;
    }

    public boolean contains(T val){
        BSTNode<T> p = root;
        while( p != null){
            if(val.equals(p.getVal())){
                return true;
            }
            else if(val.compareTo(p.getVal()) < 0){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }else {
            return false;
        }
    }

    public BSTNode<T> find(T val){
        if(root == null){
            return null;
        }
        BSTNode<T> p = root;
        while(p != null){
            if(val.equals(p.getVal())){
                return p;
            }
            else if(val.compareTo(p.getVal()) < 0){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return null;
    }

    public int height(){
        return maxDepth(root);
    }

    public Object[] nodesOnHeight(int h){
        if(h > height()){
            return null;
        }
        i = 0;
        Object[] obj = new Object[(int) Math.pow(2, h)];
//        System.out.println(numNodes());
        Levelnodies(root,0,h,obj);
//        System.out.println(obj[0]);
        return obj;
    }

    public void Levelnodies(BSTNode root, int curlvl, int level,Object obj[]) {

        if(root == null) {
            return;
        }
        if(curlvl == level) {
            obj[i] = root;
            i++;
//            System.out.println(root.getVal());
            testingcount++;
            return;
        }

        Levelnodies(root.left, curlvl+1, level,obj);
        Levelnodies(root.right, curlvl+1, level,obj);
    }

    public String DFT(){
        if(root == null){
            return null;
        }
        str="";
        if(isEmpty()){
            return "";
        }
        str = inoerder(root);
        return str.substring(0,str.length()-1);
    }
    String str2="";
    public String BFT(){
        str2 = "";
        for(int m =0; m <= height(); m++){
            bftnodes(root,0,m);
        }
        return str2.substring(0,str2.length()-1);
    }

    public void bftnodes(BSTNode root, int currentLevel, int level) {

        if(root == null) {
            return;
        }
        if(currentLevel == level) {
            str2 += root.toString() + ";";
            return;
        }

        bftnodes(root.left, currentLevel+1, level);
        bftnodes(root.right, currentLevel+1, level);
    }

   public T maxVal(){
        BSTNode<T> cur = root;
       if(root == null){
           return null;
       }
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.getVal();
    }

    public T minVal(){
        BSTNode<T> cur = root;
        if(root == null){
            return null;
        }
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.getVal();
    }

    //ADD HELPER FUNCTIONS HERE
    public String inoerder(BSTNode<T> p){
        if(p != null){
            inoerder(p.left);
            str += p.toString() + ";";
//            System.out.println(p.toString());
            inoerder(p.right);
        }
        return str;
    }

    public T itterate(BSTNode node){
        BSTNode<T> cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.getVal();
    }

    int maxDepth(BSTNode node)
    {
        if (node == null)
            return -1;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public int countkak(BSTNode node) {
        if(node != null){
            countkak(node.left);
            count++;
            countkak(node.right);
        }
        return count;
    }
}
