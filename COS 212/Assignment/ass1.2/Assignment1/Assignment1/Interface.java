import java.text.DecimalFormat;

public class Interface {

	private Node origin;

	private String floatFormatter(float value){
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(value);
	}

	//DO NOT CHANGE THE ABOVE FUNCTION
	//Place your code below

	public Interface() {
		Node newog = new Node(new Origin(),0,0);
		origin = newog;
	}

	public Interface(Node[] arr) {
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null){
				addPoint(arr[i].getFunction(),arr[i].getV1(),arr[i].getV2());
			}
		}
	}

	public Node getOrigin() {
		return origin;
	}

	public float addPoint(Function function, int v1, int v2) {
		if(v1 == 0 || v2 ==0){
			return Float.NaN;
		}
		if(origin == null){
			return Float.NaN;
		}
		Node newnode = new Node(function,v1,v2);
		setAllNull(newnode);
		Node uptemp = origin;
		Node righttemp = origin;
		Node lefttemp = origin;
		Node downtemp = origin;
		if(newnode.getV1() == 0 || newnode.getV2() == 0){
			return Float.NaN;
		}
		Node containingNode = contains(v1,v2);

		if(containingNode != null){
			backANDfront(containingNode,newnode);
			return newnode.getValue();
		}

		//v1 axis
		if(v1 > 0 && v2 > 0) {
			//q1----------
			while (righttemp.right != null && righttemp.getV1() < v1) {//find v1 node
				righttemp = righttemp.right;
			}

			if (righttemp.getV1() == v1) {
				//go up
				while (righttemp.up != null && righttemp.up.getV2() < v2) {
					righttemp = righttemp.up;
				}
				if (righttemp.up != null) {
					Node nextUp = righttemp.up;
					righttemp.up = newnode;
					newnode.down = righttemp;
					newnode.up = nextUp;
					nextUp.down = newnode;
				} else {
					righttemp.up = newnode;
					newnode.down = righttemp;
				}
			} else {
				//make new v1 node
				Node v1Helper = new Node(new V1Axis(), v1, 0);
				righttemp.right = v1Helper;
				v1Helper.left = righttemp;
				v1Helper.up = newnode;
				newnode.down = v1Helper;
			}

			//v2 axis
			while (uptemp.up != null && uptemp.getV2() < v2) {
				uptemp = uptemp.up;
			}

			if (uptemp.getV2() == v2) {
				while (uptemp.right != null && uptemp.right.getV1() < v1) {
					uptemp = uptemp.right;
				}
				if (uptemp.right != null) {
					Node nextright = uptemp.right;
					uptemp.right = newnode;
					newnode.left = uptemp;
					newnode.right = nextright;
					nextright.left = newnode;
				} else {
					uptemp.right = newnode;
					newnode.left = uptemp;
				}
			} else {
				Node v2Helper = new Node(new V2Axis(), 0, v2);
				uptemp.up = v2Helper;
				v2Helper.down = uptemp;
				v2Helper.right = newnode;
				newnode.left = v2Helper;
			}
		}else if(v1 < 0 && v2 > 0){
			//Q2
			while (lefttemp.left != null && lefttemp.getV1() > v1) {//find v1 node
				lefttemp = lefttemp.left;
			}

			if (lefttemp.getV1() == v1) {
				//go up
				while (lefttemp.up != null && lefttemp.up.getV2() < v2) {
					lefttemp = lefttemp.up;
				}
				if (lefttemp.up != null) {
					Node nextUp = lefttemp.up;
					lefttemp.up = newnode;
					newnode.down = lefttemp;
					newnode.up = nextUp;
					nextUp.down = newnode;
				} else {
					lefttemp.up = newnode;
					newnode.down = lefttemp;
				}
			} else {
				//make new v1 node
				Node v1Helper = new Node(new V1Axis(), v1, 0);
				lefttemp.left = v1Helper;
				v1Helper.right = lefttemp;
				v1Helper.up = newnode;
				newnode.down = v1Helper;
			}

			//v2 axis
			while (uptemp.up != null && uptemp.getV2() < v2) {
				uptemp = uptemp.up;
			}

			if (uptemp.getV2() == v2) {
				while (uptemp.left != null && uptemp.left.getV1() > v1) {
					uptemp = uptemp.left;
				}
				if (uptemp.left != null) {
					Node nextright = uptemp.left;
					uptemp.left = newnode;
					newnode.right = uptemp;
					newnode.left = nextright;
					nextright.right = newnode;
				} else {
					uptemp.left = newnode;
					newnode.right = uptemp;
				}
			} else {
				Node v2Helper = new Node(new V2Axis(), 0, v2);
				uptemp.up = v2Helper;
				v2Helper.down = uptemp;
				v2Helper.left = newnode;
				newnode.right = v2Helper;
			}
		}else if(v1 < 0 && v2 < 0){
			/*---------------------------q3*/
			while (lefttemp.left != null && lefttemp.getV1() > v1) {//find v1 node
				lefttemp = lefttemp.left;
			}

			if (lefttemp.getV1() == v1) {
				//go up
				while (lefttemp.down != null && lefttemp.down.getV2() > v2) {
					lefttemp = lefttemp.down;
				}
				if (lefttemp.down != null) {
					Node nextUp = lefttemp.down;
					lefttemp.down = newnode;
					newnode.up = lefttemp;
					newnode.down = nextUp;
					nextUp.up = newnode;
				} else {
					lefttemp.down = newnode;
					newnode.up = lefttemp;
				}
			} else {
				//make new v1 node
				Node v1Helper = new Node(new V1Axis(), v1, 0);
				lefttemp.left = v1Helper;
				v1Helper.right = lefttemp;
				v1Helper.down = newnode;
				newnode.up = v1Helper;
			}

			//v2 axis
			while (downtemp.down != null && downtemp.getV2() > v2) {
				downtemp = downtemp.down;
			}

			if (downtemp.getV2() == v2) {
				while (downtemp.left != null && downtemp.left.getV1() > v1) {
					downtemp = downtemp.left;
				}
				if (downtemp.left != null) {
					Node nextright = downtemp.left;
					downtemp.left = newnode;
					newnode.right = downtemp;
					newnode.left = nextright;
					nextright.right = newnode;
				} else {
					downtemp.left = newnode;
					newnode.right = downtemp;
				}
			} else {
				Node v2Helper = new Node(new V2Axis(), 0, v2);
				downtemp.down = v2Helper;
				v2Helper.up = downtemp;
				v2Helper.left = newnode;
				newnode.right = v2Helper;
			}
		}else if(v1 > 0 && v2 < 0){
			//--------------------------Q4
			while (righttemp.right != null && righttemp.getV1() < v1) {//find v1 node
				righttemp = righttemp.right;
			}

			if (righttemp.getV1() == v1) {
				//go up
				while (righttemp.down != null && righttemp.down.getV2() > v2) {
					righttemp = righttemp.down;
				}
				if (righttemp.down != null) {
					Node nextUp = righttemp.down;
					righttemp.down = newnode;
					newnode.up = righttemp;
					newnode.down = nextUp;
					nextUp.up = newnode;
				} else {
					righttemp.down = newnode;
					newnode.up = righttemp;
				}
			} else {
				//make new v1 node
				Node v1Helper = new Node(new V1Axis(), v1, 0);
				righttemp.right = v1Helper;
				v1Helper.left = righttemp;
				v1Helper.down = newnode;
				newnode.up = v1Helper;
			}

			//v2 axis
			while (downtemp.down != null && downtemp.getV2() > v2) {
				downtemp = downtemp.down;
			}

			if (downtemp.getV2() == v2) {
				while (downtemp.right != null && downtemp.right.getV1() > v1) {
					downtemp = downtemp.right;
				}
				if (downtemp.right != null) {
					Node nextright = downtemp.right;
					downtemp.right = newnode;
					newnode.left = downtemp;
					newnode.right = nextright;
					nextright.left = newnode;
				} else {
					downtemp.right = newnode;
					newnode.left = downtemp;
				}
			} else {
				Node v2Helper = new Node(new V2Axis(), 0, v2);
				downtemp.down = v2Helper;
				v2Helper.up = downtemp;
				v2Helper.right = newnode;
				newnode.left = v2Helper;
			}
		}
		return newnode.getValue();
	}

	private void backANDfront(Node old,Node newn){

		if((old.getFunction().toString()).compareTo((old.getFunction()).toString()) > 0) {
			Node temp = old;
			while (temp.nextVal != null && (old.getFunction().toString()).compareTo((temp.getFunction()).toString()) > 0) {
				temp = temp.nextVal;
			}
			if(temp.nextVal != null){
				newn.nextVal = temp.nextVal;
				newn.prevVal = temp;
				temp.nextVal.prevVal = newn;
				temp.nextVal = newn;
			}
			else{
				newn.prevVal = temp;
				temp.nextVal = newn;
			}
		}else{
			old.nextVal = newn;
			newn.prevVal = old;


			if(old.up != null){
				newn.up = old.up;
			}
			if(old.down != null){
				newn.down = old.down;

			}
			if(old.right != null){
				newn.right = old.right;

			}
			if(old.left != null){
				newn.left = old.left;

			}
			old.left = null;
			old.right = null;
			old.up = null;
			old.down = null;
		}

	}

	public void printfornow(){
		/*Node ptr1 = origin;
		while(ptr1.right != null){
			ptr1 = ptr1.right;
		}
		while(ptr1.up != null){
			ptr1=ptr1.up;
		}
		Node tempTop = ptr1;
		while(tempTop.down != null){
			ptr1 = tempTop;
			while(ptr1.left != null){
				System.out.println(ptr1.getV1() + " " + ptr1.getV2());
				ptr1 = ptr1.left;
				int[] arr = new int[10]
			}
			tempTop = tempTop.down;
		}*/
		System.out.println(origin.right.up.getV1() + " " + origin.right.up.getV2() +  " "  +origin.right.up.getFunction());
		System.out.println(origin.right.up.nextVal.getV1() + " " + origin.right.up.nextVal.getV2() +  " "  +origin.right.up.nextVal.getFunction());

/*
/*
		//v1
		System.out.println("---------------------1,1");
		System.out.println(origin.right.up.getV1() + " " + origin.right.up.getV2());
		System.out.println(origin.up.right.getV1() + " " + origin.up.right.getV2());
		System.out.println(origin.right.right.up.left.getV1() + " " + origin.right.right.up.left.getV2());
		System.out.println(origin.up.up.right.down.getV1() + " " + origin.up.up.right.down.getV2());
		//1,2
		System.out.println("---------------------1,2");
		System.out.println(origin.up.up.right.getV1() + " " + origin.up.up.right.getV2());
		System.out.println(origin.right.up.up.getV1() + " " + origin.right.up.up.getV2());
		System.out.println(origin.right.right.up.up.left.getV1() + " " + origin.right.right.up.up.left.getV2());
		System.out.println(origin.right.right.up.left.up.getV1() + " " + origin.right.right.up.left.up.getV2());
		//2,2
		System.out.println("---------------------2,2");
		System.out.println(origin.up.up.right.right.getV1() + " " + origin.up.up.right.right.getV2());
		System.out.println(origin.up.right.up.right.getV1() + " " + origin.up.right.up.right.getV2());
		System.out.println(origin.right.right.up.up.getV1() + " " + origin.right.right.up.up.getV2());
		System.out.println(origin.right.up.right.up.getV1() + " " + origin.right.up.right.up.getV2());
		//2.1
		System.out.println("---------------------2,1");
		System.out.println(origin.right.right.up.getV1() + " " + origin.right.right.up.getV2());
		System.out.println(origin.up.right.right.getV1() + " " + origin.up.right.right.getV2());
		System.out.println(origin.up.up.right.down.right.getV1() + " " + origin.up.up.right.down.right.getV2());
		System.out.println(origin.up.up.right.right.down.getV1() + " " + origin.up.up.right.right.down.getV2());

//		System.out.println(origin.right.right.up.up.getV1() + " " + origin.right.right.up.up.getV2());
//		System.out.println(origin.right.up.getV1() + " " + origin.right.up.getV2());
//		System.out.println(origin.up.up.right.getV1() + " " + origin.up.up.right.getV2());
//		System.out.println(origin.right.right.up.getV1() + " " + origin.right.right.up.getV2());
*/
	}

	public Node removePoint(int v1, int v2) {
		if(v1 == 0 || v2 == 0){
			return null;
		}
		Node node2 = contains(v1,v2);
		System.out.println(node2.getV1() + " " + node2.getV2());
		removeDambichhhh(node2);
		return node2;
	}

	public Node getPoint(int v1, int v2) {
		////////////////////////////issue in Q3
		if(v1 == 0 || v2 == 0){
			return null;
		}
		Node temp = origin;
		if(v2 > 0 && v1 > 0){
			/*-----------------q1*/
			while(temp.up != null && v2 > temp.getV2()){
				while(temp.right != null && v1 > temp.getV1()){
					temp = temp.right;
				}
				temp = temp.up;
			}
		}else if(v2 > 0 && v1 < 0){
			/*--------------------------q2*/
			while(temp.up != null && v2 > temp.getV2()){
				while(temp.left != null && v1 < temp.getV1()){
					temp = temp.left;
				}
				temp = temp.up;
			}
		}else if(v2 < 0 && v1 < 0){
			/*---------------------q3*/
			while(temp.down != null && v2 < temp.getV2()){
				while(temp.left != null && v1 > temp.getV1()){
					temp = temp.left;
				}
				temp = temp.down;
			}
		}else{
			/*-------------------------q4*/
			while(temp.down != null && v2 < temp.getV2()){
				while(temp.right != null && v1 > temp.getV1()){
					temp = temp.right;
				}
				temp = temp.down;
			}
		}
		if(v1 == temp.getV1() && v2 == temp.getV2()){
			System.out.println(temp.getV1() + " " + temp.getV2());
			return temp;
		}else
			return null;
	}

	/*public Node[] toArray() {
	}*/

	public float calculateValue(Function function, int v1, int v2) {
		if(function == null){
			return Float.NaN;
		}else{
			return function.calculate(v1,v2);
		}
	}

	/*public float findMaxValue() {
		if(isEmpty(origin)){
			return Float.NaN;
		}
		Node temp = topright();
		if(temp == origin){

		}
	}*/

	public Node findMax() {
		if(origin == null){
			return null;
		}
		Node bottom = leftbottom();
		while(bottom.right != null){
			bottom = bottom.right;
		}
		while(bottom.up != null){
			bottom = bottom.up;
		}
		return bottom;
	}

	/*public float findMinValue() {
//		Node min = findMin();
	}*/

	public Node findMin() {
		if(origin == null){
			return null;
		}
		Node top = findMax();
		while(top.left != null){
			top = top.left;
		}
		while(top.down != null){
			top = top.down;
		}
		return top;
	}

//	public String printFunctionValues(String functionName) {
//
//	}
	public int removeAllFunctionPoints(String functionName){
		Node node1, node2,node3;
		node1 = node2 = node3 = origin;
		int count =0;
			//-----------------------Q1
			while(node1.right != null) {
				node1 = node1.right;
				node2 = node1;
				while (node2.up != null) {
					node2 = node2.up;
					if ((node2.getFunction().toString()).equals(functionName)) {
						System.out.println("found the ting");
						if(node2.nextVal == null){
							removeDambichhhh(node2);
						}else {
							while (node2.nextVal != null) {
								if (node2.getFunction().equals(functionName)) {
									count++;
									setNewAll(node2, node2.nextVal);
								}
							}
						}

					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		node1 = node2 = node3 = origin;

			//--------------------------Q2
			while(node1.left != null){
				node1 = node1.left;
				node2 = node1;
				while(node2.up != null){
					node2 = node2.up;
					if (node2.getFunction().equals(functionName)) {
						System.out.println("found the ting");
						if(node2.nextVal == null){
							count++;
							removeDambichhhh(node2);
						}else {
							while (node2.nextVal != null) {
								if (node2.getFunction().equals(functionName)) {
									count++;
									setNewAll(node2, node2.nextVal);
								}
							}
						}
					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		node1 = node2 = node3 = origin;
			//-----------------Q3
			while(node1.left != null){
				node1 = node1.left;
				node2 = node1;
				while(node2.down != null){
					node2 = node2.down;
					if (node2.getFunction().equals(functionName)) {
						System.out.println("found the ting");
						if(node2.nextVal == null){
							count++;
							removeDambichhhh(node2);
						}else {
							while (node2.nextVal != null) {
								if (node2.getFunction().equals(functionName)) {
									count++;
									setNewAll(node2, node2.nextVal);
								}
							}
						}
					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		node1 = node2 = node3 = origin;
			//---------------------Q4
			while(node1.right != null){
				node1 = node1.right;
				node2 = node1;
				while(node2.down != null){
					node2 = node2.down;
					if (node2.getFunction().equals(functionName)) {
						if(node2.nextVal == null){
							count++;
							removeDambichhhh(node2);
						}else {
							while (node2.nextVal != null) {
								if (node2.getFunction().equals(functionName)) {
									count++;
									setNewAll(node2, node2.nextVal);
								}
							}
						}
					}

				}
			}
		return count;
	}

	public int countNumberOfPoints(){
		int count = 0;
		int[] arr = numPointsPerQuadrant();
		for(int i = 0; i < 4; i++){
			count += arr[i];
		}
//		System.out.println(count);
		return count;
	}

	public int[] numPointsPerQuadrant(){
		int[] sizeArray = new int[4];
		int count = 0;
		Node node1,node2;
		node1 = node2 = origin;
		//--------------------q1
		while(node1.right != null){
			node1 = node1.right;
			node2 = node1;
			while(node2.up != null){
				node2 = node2.up;
				if(node2.getV1() != 0 && node2.getV2() != 0){
					count++;
				}
//				System.out.println(node2.getV1() + " " + node2.getV2());
			}
		}
//		System.out.println(count);
		sizeArray[0] = count;

		//-------------------------q2
		node1 = node2 = origin;
		count = 0;
		while(node1.left != null){
			node1 = node1.left;
			node2 = node1;
			while(node2.up != null){
				node2 = node2.up;
				if(node2.getV1() != 0 && node2.getV2() != 0){
					count++;
				}
//				System.out.println(node2.getV1() + " " + node2.getV2());
			}
		}
		sizeArray[1] = count;
//		System.out.println(count);

		//---------------------------------------q3
		node1 = node2 = origin;
		count = 0;
		while(node1.left != null){
			node1 = node1.left;
			node2 = node1;
			while(node2.down != null){
				node2 = node2.down;
				if(node2.getV1() != 0 && node2.getV2() != 0){
					count++;
				}
//				System.out.println(node2.getV1() + " " + node2.getV2());
			}
		}
		sizeArray[2] = count;
//		System.out.println(count);
		//------------------q4
		node1 = node2 = origin;
		count = 0;
		while(node1.right != null){
			node1 = node1.right;
			node2 = node1;
			while(node2.down != null){
				node2 = node2.down;
				if(node2.getV1() != 0 && node2.getV2() != 0){
					count++;
				}
//				System.out.println(node2.getV1() + " " + node2.getV2());
			}
		}
//		System.out.println(count);
		sizeArray[3] = count;


		return sizeArray;

	}

	public void clearAllData(){
		setAllNull(origin);
	}

	//ADD HELPER FUNCTIONS BELOW
	/*public void setPrev(Node cur, Node newnode){
		if(cur.getFunction() > newnode.getFunction()){
			cur.nextVal = newnode;
			newnode.prevVal =cur;
		}else{
			newnode.up = cur.up;
			newnode.right = cur.right;
			newnode.down = cur.down;
			newnode.left = cur.left;
			newnode.nextVal = cur;
			cur.prevVal = newnode;
		}
		System.out.println("yeah baby a double");
	}*/
	public Node leftbottom(){
		Node temp = origin;
		while(temp.down != null ){
			while(temp.left != null){
				temp = temp.left;
			}
			temp = temp.down;
		}
		return temp;
	}

	public Node topright(){
		Node temp = origin;
		while(temp.up != null ){
			while(temp.right != null){
				temp = temp.right;
			}
			temp = temp.up;
		}
		return temp;
	}

	public boolean isEmpty(Node n1){
		if(n1.up == null && n1.right == null && n1.down == null && n1.left == null){
			return true;
		}else {
			return false;
		}
	}

	public void setAllNull(Node n1){
		n1.up = null;
		n1.down = null;
		n1.right = null;
		n1.left = null;
		n1.prevVal = null;
		n1.nextVal= null;
	}

	public void setNewAll(Node old,Node newnode){
		if(old.up != null){
			newnode.up = old.up;
			old.up.down = newnode;
		}
		if(old.down != null){
			newnode.down = old.down;
			old.down.up = newnode;
		}
		if(old.right != null){
			newnode.right = old.right;
			old.right.left = newnode;
		}
		if(old.left != null){
			newnode.left = old.left;
			old.left.right = newnode;
		}
		setAllNull(old);
	}

	public void removeDambichhhh(Node old){
		if(old.up != null && old.down != null){
			old.up.down = old.down;
			old.down.up = old.up;
			old.up = old.down = null;
		}else if(old.down != null){
			old.down.up = null;
			old.down = null;
		}
		else if(old.up != null){
			old.up.down = null ;
			old.up = null;
		}

		if(old.right != null && old.left != null){
			old.right.left = old.left;
			old.left.right = old.right;
		}else if(old.right != null){
			old.right.left = null;
			old.right = null;
		}
		else if(old.left != null){
			old.left.right = null;
			old.left = null;
		}
		setAllNull(old);
	}

	public Node contains(int v1, int v2){

		Node node1, node2;
		node1 = node2 = origin;
		if(v1 > 0 && v2 > 0){
			//-----------------------Q1
			while(node1.right != null){
				node1 = node1.right;
				node2 = node1;
				while(node2.up != null){
					node2 = node2.up;
					if(node2.getV1() == v1 && node2.getV2() == v2){
						System.out.println("found the ting");
						if(node2.nextVal != null){
							setNewAll(node2,node2.nextVal);
						}
						return node2;
					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		}else if( v1 < 0 && v2 > 0){
			//--------------------------Q2
			while(node1.left != null){
				node1 = node1.left;
				node2 = node1;
				while(node2.up != null){
					node2 = node2.up;
					if(node2.getV1() == v1 && node2.getV2() == v2){
						System.out.println("found the ting");
						if(node2.nextVal != null){
							setNewAll(node2,node2.nextVal);
						}
						return node2;
					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		}else if(v1 < 0 && v2 < 0){
			//-----------------Q3
			while(node1.left != null){
				node1 = node1.left;
				node2 = node1;
				while(node2.down != null){
					node2 = node2.down;
					if(node2.getV1() == v1 && node2.getV2() == v2){
						System.out.println("found the ting");
						if(node2.nextVal != null){
							setNewAll(node2,node2.nextVal);
						}
						return node2;
					}
//					System.out.println(node2.getV1() + " " + node2.getV2());
				}
			}
		}else if(v1 > 0 && v2 < 0){
			//---------------------Q4
			while(node1.right != null){
				node1 = node1.right;
				node2 = node1;
				while(node2.down != null){
					node2 = node2.down;
					if(node2.getV1() == v1 && node2.getV2() == v2){
						if(node2.nextVal != null){
							setNewAll(node2,node2.nextVal);
						}
						System.out.println("found the ting");
						return node2;
					}

				}
			}
		}
		return null;
	}

}