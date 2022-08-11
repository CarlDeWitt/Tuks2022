public class Component
{
	public volatile long developTime, testTime;
	public String name;

	public Component(char c, String n){
		name = n;

		switch(c){
			case 's': 	developTime = 500;
						testTime = 1000;
						break;
			case 'm':	developTime = 1000;
						testTime = 1500;
						break;
			case 'l':	developTime = 1500;
						testTime = 2000;
		}
	}
}
