@SuppressWarnings("unchecked")
class BTreeNode<T extends Comparable<T>> {
	boolean leaf;
	int keyTally;
	Comparable<T> keys[];
	BTreeNode<T> references[];
	int m;
	static int level = 0;
	// Constructor for BTreeNode class
	public BTreeNode(int order, boolean leaf1)
	{
    		// Copy the given order and leaf property
		m = order;
    		leaf = leaf1;
 
    		// Allocate memory for maximum number of possible keys
    		// and child pointers
    		keys =  new Comparable[2*m-1];
    		references = new BTreeNode[2*m];
 
    		// Initialize the number of keys as 0
    		keyTally = 0;
	}

	// Function to print all nodes in a subtree rooted with this node
	public void print()
	{
		level++;
		if (this != null) {
			System.out.print("Level " + level + " ");
			this.printKeys();
			System.out.println();

			// If this node is not a leaf, then 
        		// print all the subtrees rooted with this node.
        		if (!this.leaf)
			{	
				for (int j = 0; j < 2*m; j++)
    				{
        				if (this.references[j] != null)
						this.references[j].print();
    				}
			}
		}
		level--;
	}

	// A utility function to print all the keys in this node
	private void printKeys()
	{
		System.out.print("[");
    		for (int i = 0; i < this.keyTally; i++)
    		{
        		System.out.print(" " + this.keys[i]);
    		}
 		System.out.print("]");
	}

	// A utility function to give a string representation of this node
	public String toString() {
		String out = "[";
		for (int i = 1; i <= (this.keyTally-1); i++)
			out += keys[i-1] + ",";
		out += keys[keyTally-1] + "] ";
		return out;
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////
	private int getTheorder(){
		return 2*m-1;
	}

	private void coppyTheRefs(BTreeNode<T> nr,BTreeNode<T> or){
		nr.references[0] = or;
	}

	private void itterateOverKeys(BTreeNode<T> newroot,T key,int index){
		if(newroot.keys[0].compareTo(key) < 0){
			index++;
		}
		newroot.references[index].maybeItsFullMaybeITsnotJKitsNot(key);
	}

	// Function to insert the given key in tree rooted with this node
	public BTreeNode<T> insert(T key)
	{
				int index =0;
				BTreeNode<T> ThisSHouldBeRoot = this;
				int order = getTheorder();

				if(ThisSHouldBeRoot.keyTally != order){
					ThisSHouldBeRoot.maybeItsFullMaybeITsnotJKitsNot(key);
				}else {
					BTreeNode<T> newroot = new BTreeNode<>(m,false);

					//go and coppy the refrences
					coppyTheRefs(newroot,ThisSHouldBeRoot);
					if(newroot == null){
						return null;
					}else{
						newroot.IWillFLipACoinToDecideToSplit(0,ThisSHouldBeRoot);

						if(newroot != null){
							itterateOverKeys(newroot,key,index);
							BTreeNode<T> temp = newroot;
//							System.out.println(temp);
							ThisSHouldBeRoot = temp;
						}else
							return null;
					}

				}
			return ThisSHouldBeRoot;
	}

	private int getOrder(){
		return 2*m-1;
	}

	void maybeItsFullMaybeITsnotJKitsNot(T Value)
	{
		int index;
		index = keyTally;
		index = index -1;
		int order = getOrder();

		if (leaf == false)
		{
			while (index >= 0 && keys[index].compareTo(Value) > 0)
				index--;

			order = getOrder();
			if(references[index+1] != null) {
				int kt = keyTally;
				int mm = m;
				boolean lf = leaf;
				Comparable<T> ks[] = keys;
				BTreeNode<T> rf[] = references;

				/*kt++;
				mm = kt*2-1;

				for(int n=0;n<1;n++){
					ks[n]=null;
					rf[n]=null;
				}*/

//				System.out.println(kt);
//				System.out.println(mm);
//				System.out.println(lf);
//				System.out.println(ks);
//				System.out.println(rf);

				if (references[index + 1].keyTally == order) {
					IWillFLipACoinToDecideToSplit(index + 1, references[index + 1]);
					if(references[index+1] != null) {
						if (keys[index + 1].compareTo(Value) < 0)
							index = index + 1;
					}
				}
			}else
				return;
			references[index+1].maybeItsFullMaybeITsnotJKitsNot(Value);
		}
		else
		{
			while (index >= 0 && keys[index].compareTo(Value) > 0)
			{
				keys[index+1] = keys[index];
				index--;
			}

			int kt = keyTally;
				int mm = m;
			boolean lf = leaf;

							/*kt++;
				mm = kt*2-1;

				for(int n=0;n<1;n++){
					ks[n]=null;
					rf[n]=null;
				}*/

//				System.out.println(kt);
//				System.out.println(mm);
//				System.out.println(lf);
//				System.out.println(ks);
//				System.out.println(rf);


			keys[index + 1] = Value;

			Comparable<T> ks[] = keys;
			BTreeNode<T> rf[] = references;

						/*kt++;
				mm = kt*2-1;

				for(int n=0;n<1;n++){
					ks[n]=null;
					rf[n]=null;
				}*/

			keyTally = keyTally + 1;


		}
	}

	private int returnM(){
		return m;
	}

	private void goAnDCoPpY(BTreeNode<T> newnode, BTreeNode<T> y) {
		int j = 0;
		int fakeM = m-1;
		for (j = 0; j < fakeM; j++) {
			newnode.keys[j] = y.keys[j + fakeM + 1];
		}

		goAnDCoPpYMoRe(newnode,y);
		return;
	}

	private void goAnDCoPpYMoRe(BTreeNode<T> newnode, BTreeNode<T> y) {
		if (newnode.leaf == true)
			return;
		else{
			int j = 0;
			int fakeM = m;
			for (j = 0; j < fakeM; j++)
				newnode.references[j] = y.references[j+fakeM];
		}
		return;
	}

	void IWillFLipACoinToDecideToSplit(int index, BTreeNode why)
	{
		BTreeNode newnode;
		newnode = new BTreeNode(why.m, why.leaf);
		newnode.keyTally = returnM();
		newnode.keyTally = newnode.keyTally - 1;

		goAnDCoPpY(newnode,why);

		why.keyTally = returnM();
		why.keyTally = why.keyTally -1;

		int countJ;
		countJ = keyTally;
		int param;
		param = index + 1;
		for (; countJ >= param; countJ--)
			references[countJ+1] = references[countJ];

		unlinkTheNode(newnode,why,index);
//		references[index+1] = newnode;
//		int lnght = why.references.length;
//		if(newnode.references[0] != null && why.references[0] != null) {
//			for (int m = 0; m < lnght ; m++) {
//				for (int n = 0; n < newnode.references.length - 1; n++) {
//					if (why.references[m] != null && why.references[m].equals(newnode.references[n])) {
//						why.references[m] = null;
//					}
//				}
//			}
//		}

		countJ =0;
		param = 0;
		countJ = keyTally;
		countJ--;
		param = index;
		for (; countJ >= param; countJ--)
			keys[countJ+1] = keys[countJ];

		int fakeM;
		fakeM = returnM() -1;

		param = index;
		keys[param] = why.keys[fakeM];

		keyTally = keyTally + 1;
	}

	private void unlinkTheNode(BTreeNode Holder, BTreeNode oldRoot,int i) {
		setRefrences(Holder,i);
		if(Holder.references[0] != null && oldRoot.references[0] != null) {
			NowGoAhead(Holder,oldRoot,i);
		}else{
//			System.out.println("not hello");
		}
	}

	private void setRefrences(BTreeNode<T> Holder, int i) {
		references[i+1] = getNode(Holder);
	}

	private BTreeNode<T> getNode(BTreeNode<T> n){
		return n;
	}

	private void NowGoAhead(BTreeNode Holder, BTreeNode oldRoot,int i) {
//		System.out.println("hello");
		int thelenght;
		int theOtherLenght;
		thelenght = oldRoot.references.length;
		BTreeNode<T> tempH;
		theOtherLenght = Holder.references.length - 1;
		BTreeNode<T> tempO;
		for (int ab = 0; ab < thelenght ; ab++) {
			tempH = Holder;
//			System.out.println(tempH);
			tempO = oldRoot;
//			System.out.println(oldRoot);
			tempH = null;
			tempO =null;
			for (int ba = 0; ba < theOtherLenght; ba++) {
				tempH = Holder;
//			System.out.println(tempH);
				tempO = oldRoot;
//			System.out.println(oldRoot);
				tempH = null;
				tempO =null;
				if (oldRoot.references[ab] != null && oldRoot.references[ab].equals(Holder.references[ba])) {
					tempH = Holder;
//			System.out.println(tempH);
					tempO = oldRoot;
//			System.out.println(oldRoot);
					tempH = null;
					tempO =null;
					goMakeOldRootNull(oldRoot,ab);
				}
			}
		}
	}

	private void goMakeOldRootNull(BTreeNode<T> oldRoot, int ab) {
		oldRoot.references[ab] = null;
	}

	// Function to search a key in a subtree rooted with this node
    	public BTreeNode<T> search(T key)
    	{
			BTreeNode<T> BigDADDY = this;
			return srchForNode(BigDADDY,key);
		}

		private BTreeNode<T> srchForNode(BTreeNode<T> node, T key){
			if(node !=null) {
				int i = 1;
				for (; i <= node.keyTally && node.keys[i - 1].compareTo(key) < 0; i++);
				if (i > node.keyTally || node.keys[i - 1].compareTo(key) > 0) {
					return srchForNode(node.references[i - 1], key);
				} else
					return node;
			}
			return null;
		}

		private void helpPrint(int index){
			if (leaf == true){
//				System.out.println("here");
			}else
				references[index].traverse();
			this.Output(index);

		}

		private void Output(int index){
			System.out.print(" " + keys[index]);
		}

		private void lastCheck(int index){
			if (leaf == true){
//				System.out.println("here");
			}else
				references[index].traverse();
		}

	// Function to traverse all nodes in a subtree rooted with this node
	public void traverse()
	{
		int i ;
		i= 0;
		while(i < keyTally)
		{
			this.helpPrint(i);
			i++;
		}
		this.lastCheck(i);

	}
}