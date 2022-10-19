public class V1Axis extends Function {
    public V1Axis(){
        functionName = "V1Axis";
    }

	public float calculate(int v1, int v2) {
        return v2;
	}

    public Function clone(){
        return new V1Axis();
    }
}