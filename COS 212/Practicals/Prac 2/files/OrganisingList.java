/**
 * Name: Carl de Witt
 * Student Number: u21444928
 */



public class OrganisingList {

    public ListNode root = null;
    static int sum=0;
    public OrganisingList() {

    }
    
    /**
     * Calculate the sum of keys recursively, starting with the given node until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {
        // Your code here...
        if(node.next == null){
            return node.key;
        }
        sum = sumRec(node.next) + node.key;
        return sum;
    }

    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {
        // Your code here...
        if(node.next == null){
            return node.data = node.key;
        }
        return node.data = (node.key* sumRec(node) - dataRec(node.next));
    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     * DO NOT MODIFY!
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    /**
     * Retrieve the data for the node with the specified key and swap the
     * accessed node with its predecessor, then recalculate data fields.
     * @return The data of the node before it has been moved,
     * otherwise 'null' if the key does not exist.
     */
    public Integer getData(Integer key) {
        // Your code here...
        if(!contains(key)){
            return null;
        }
        ListNode cur = root,prev = null;
        if(root.key == key){
            int i = root.data;
            calculateData();
            return i;
        }
        if(root.next.key == key){
            ListNode temp = root.next;
            ListNode wasRoot = root;
            wasRoot.next =temp.next;
            temp.next = wasRoot;
            root = temp;
            int i = temp.data;
            calculateData();
            return i;
        }
        while(cur.next.key != key){
            prev = cur;
            cur = cur.next;
        }
        ListNode temp = cur.next;
        prev.next = temp;
        cur.next = temp.next;
        temp.next = cur;
        int i = temp.data;
        calculateData();
        return i;
    }

    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {
        // Your code here...
        if(contains(key)){
            if(root.key == key){
                root = root.next;
            }else {
                ListNode temp = root;
                ListNode prev = null;
                while (temp.key != key) {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = temp.next;
                calculateData();
            }
        }
    }


    /**
     * Insert a new key into the linked list.
     * 
     * New nodes should be inserted to the back
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {
        // Your code here...
        if(!contains(key)){
            ListNode newnode = new ListNode(key);
            ListNode temp = root;
            if(root == null) {
                root = newnode;
                newnode.next = null;
            }
            else{
                while (temp.next != null){
                    temp = temp.next;
                }
                temp.next = newnode;
            }
            calculateData();
        }
    }

    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public Boolean contains(Integer key) {
        // Your code here...
        if(root == null){
            return false;
        }
        ListNode temp = root;
        while(temp != null) {
            if (temp.key == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    /**
     * Return a string representation of the Linked List.
     * DO NOT MODIFY!
     */
    public String toString() {
        if (root == null) {
            return "List is empty";
        }


        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result.concat("[K: " + node.key + ", D: " + node.data + "]");

            if (node.next != null) {
                result = result.concat(" ");
            }
        }

        return result;
    }

    /**
     * Return a string representation of the linked list, showing only the keys of nodes.
     * DO NOT MODIFY!
     */
    public String toStringKeysOnly() {

        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result + node.key;

            if (node.next != null) {
                result = result.concat(", ");
            }
        }

        return result;
    }

    //helper

    
}