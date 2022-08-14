import java.text.DecimalFormat;

public class Node {

	private int v1; // this is the first variable
	private int v2; // this is the second variable
	public Node left; // this is the node left of this node
	public Node right; // this is the node right of this node
	public Node up; // this is the node up of this node
	public Node down; // this is the node down of this node
	public Node nextVal; // this is the next value of the current node
	public Node prevVal; // this is the prev value of the current node
	private Function nodeFunction; // this is the function associated with the current node

	private String floatFormatter(float value){
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(value);
	}
	
	//DO NOT CHANGE THE ABOVE FUNCTION
	//Place your code below

	public Node(Function function, int v1, int v2) {
		this.nodeFunction = function;
		this.v1 =v1;
		this.v2 = v2;
	}
	//helper functions
	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}

	public Function setFunction(Function function) {
		nodeFunction = function;
		return function;
	}

	public float getValue() {
		if(this.getFunction() == null){
			return Float.NEGATIVE_INFINITY;
		}
		else{
			return this.nodeFunction.calculate(this.v1,this.v2);
		}
	}

	public int[] getVariables() {
		int[] var = new int[2];
		var[0] = v1;
		var[1] = v2;
		return var;
	}

	public Function getFunction(){
		return nodeFunction;
	}

	public String[] getNodeLinks(){
		String[] str = new String[6];
		//up
		if(up != null){
			str[0] = "U[" + up.v1 + "][" + up.v2 + "]{" + floatFormatter(up.v1 +up.v2) +"}";
		}
		else {
			str[0] = "U[][]{}";
		}
		//down
		if(down != null){
			str[1] = "D[" + down.v1 + "][" + down.v2 + "]{" + floatFormatter(down.v1 +down.v2) +"}";
		}
		else {
			str[1] = "D[][]{}";
		}
		//right
		if(right != null){
			str[2] = "R[" + right.v1 + "][" + right.v2 + "]{" + floatFormatter(right.v1 +right.v2) +"}";
		}
		else {
			str[2] = "R[][]{}";
		}
		//left
		if(left != null){
			str[3] = "L[" + left.v1 + "][" + left.v2 + "]{" + floatFormatter(left.v1 + left.v2) +"}";
		}
		else {
			str[3] = "L[][]{}";
		}
		//prev
		if(prevVal != null){
			str[4] = "P[" + prevVal.v1 + "][" + prevVal.v2 + "]{" + floatFormatter(prevVal.v1 +prevVal.v2) +"}";
		}
		else {
			str[4] = "P[][]{}";
		}
		//next
		if(nextVal != null){
			str[5] = "U[" + nextVal.v1 + "][" + nextVal.v2 + "]{" + floatFormatter(nextVal.v1 + nextVal.v2) +"}";
		}
		else {
			str[5] = "U[][]{}";
		}
		return str;
	}

}