class BTree<T extends Comparable<T>> {
	BTreeNode<T> root; // Pointer to root node
    	int m;  // B-Tree of order 2m

	// Constructor (Initializes B-Tree as empty)
    	BTree(int order)
    	{  
		root = null; 
		m = order; 
	}

	// function to print this B-Tree
    	public void print()
    	{  
		if (root != null) 
		{ 
			root.print();
			System.out.println();
		} 
	}
 
    	// function to insert the given key in this B-Tree
	public void insert(T key)
	{
    		// If the tree is empty
    		if (root == null)
    		{
        		root = new BTreeNode<T>(m, true);  // Create new root
        		root.keys[0] = key;  // Insert key
        		root.keyTally = 1;  // Update number of keys in root
    		}
		// If the tree is not empty
    		else 
    		{
        		root = root.insert(key);
    		}
	}

	// function to search a key in this B-Tree
    	public BTreeNode<T> search(T key)
    	{  
		if (root != null) 
			return root.search(key);
		else
			return null;
	}

	// function to traverse this B-Tree
    	public void traverse()
    	{  
		if (root != null) 
		{ 
			root.traverse();
			System.out.println();
		} 
	}

	public BTreeNode<T> getRoot(){
			return root;
	}
}