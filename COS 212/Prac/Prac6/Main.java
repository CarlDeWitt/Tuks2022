public class Main {
    public static void main(String[] args) 
    {
	BTree<Integer> t = new BTree<Integer>(2); // A B-Tree with order 4 (2*m)
   
	t.insert(20);
	t.insert(10);
	t.insert(30);
	t.insert(50);
	t.insert(40);
	t.insert(60);
	t.insert(90);
	t.insert(70);
	t.insert(80);
	/*t.insert(15);
	t.insert(25);
	t.insert(35);
	t.insert(100);
	t.insert(1);
	t.insert(32);
	t.insert(19);
	t.insert(27);
	t.insert(17);
	t.insert(170);
	t.insert(12);
	t.insert(9);
	t.insert(8);
	t.insert(7);
	t.insert(6);
	t.insert(5);
	t.insert(4);*/

	System.out.println("Search the constucted tree for 80: ");
    	BTreeNode result = t.search(80);
	if (result != null)
		System.out.println("Found in node " + result);
	else
		System.out.println("Not found!");
	System.out.println("Search the constucted tree for 100: ");
    	result = t.search(100);
	if (result != null)
		System.out.println("Found in node " + result);
	else
		System.out.println("Not found!");

	System.out.println("Traversal of the constucted tree is : ");
    	t.traverse();
	System.out.println("Structure of the constucted tree is : ");
	t.print();

	/* Expected Output:
	Search the constucted tree for 80:
	Found in node [70,80,90]
	Search the constucted tree for 100:
	Not found!
	Traversal of the constucted tree is :
	 10 20 30 40 50 60 70 80 90
	Structure of the constucted tree is :
	Level 1 [ 40]
	Level 2 [ 20]
	Level 3 [ 10]
	Level 3 [ 30]
	Level 2 [ 60]
	Level 3 [ 50]
	Level 3 [ 70 80 90]
	*/
    }


    
}