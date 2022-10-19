public class BSTNode<T extends Comparable<T>> {
    private T value;
    public BSTNode<T> right;
    public BSTNode<T> left;

    public boolean recInsert(T val){
        if(val.compareTo(value) == 0)
            return false;

        if(val.compareTo(value) < 0)
        {
            if(left == null)
            {
                left = new BSTNode<>(val);
                return true;
            } else {
                return left.recInsert(val);
            }
        } else {
            if(right == null)
            {
                right = new BSTNode<>(val);
                return true;
            } else {
                return right.recInsert(val);
            }
        }
    }

    //Implement the following

    public BSTNode(T val){
        this.value = val;
    }

    public T getVal(){
        return value;
    }

    public String toString(){
        String str;
        String left,right;

        if(this.left == null){
            left = "[]";
        }
        else{
            left = "[" + this.left.value + "]";
        }

        if(this.right == null){
            right = "[]";
        }else{
            right = "[" + this.right.value + "]";
        }
        return "L" + left + "V" + "[" + this.value + "]" + "R" + right;
    }

    //ADD HELPER FUNCTIONS HERE
}
