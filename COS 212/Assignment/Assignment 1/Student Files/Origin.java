public class Origin extends Function {
    public Origin(){
        functionName = "Origin";
    }

	public float calculate(int v1, int v2) {
        return 0;
	}

    public Function clone(){
        return new Origin();
    }
}