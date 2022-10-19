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
	//helper

	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}

	public Node(Function function, int v1, int v2) {
		nodeFunction = function;
		this.v1 = v1;
		this.v2 = v2;
	}

	public Function setFunction(Function function) {
	}

	public float getValue() {
	}

	public int[] getVariables() {
	}

	public Function getFunction(){
	}

	public String[] getNodeLinks(){
	}

}