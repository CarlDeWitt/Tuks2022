public class V2Axis extends Function {
    public V2Axis(){
        functionName = "V2Axis";
    }

	public float calculate(int v1, int v2) {
        return v1;
	}

    public Function clone(){
        return new V2Axis();
    }
}