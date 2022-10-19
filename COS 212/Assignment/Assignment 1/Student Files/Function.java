public abstract class Function {

	protected String functionName;

	public Function(){
		functionName = "Unknown function";
	}

	public Function(String fName) {
		functionName = fName;
	}

	public abstract float calculate(int v1, int v2);

	public String getFunctionName() {
		return this.functionName;
	}

	public abstract Function clone();

}