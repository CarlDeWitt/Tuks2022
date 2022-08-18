public class TestATMMachine {
	
	public static void main(String[] args){
		
		ATMMachine atmMachine = new ATMMachine();
		
		// atmMachine.insertCard();
		
		// atmMachine.ejectCard();
		
		atmMachine.insertCard();
		
		atmMachine.insertPin(1234);
		
		atmMachine.requestCash(500);

        atmMachine.insertCard();
		
		atmMachine.insertPin(1234);
        atmMachine.checkBalance();
		
		// atmMachine.insertCard();
		
		// atmMachine.insertPin(1234);
		
	}	
}