import java.util.LinkedList;
import java.util.Queue;

public class Project
{

	private static int size;
	private volatile Queue<Component> develop = new LinkedList<>(), testing = new LinkedList<>(), finished = new LinkedList<>();
	
	public Project(){
		develop.add(new Component('s', "Calculator"));
		develop.add(new Component('m', "Calendar"));
		develop.add(new Component('s', "Billing"));
		develop.add(new Component('l', "Timetable"));
		develop.add(new Component('m', "Phonebook"));
		develop.add(new Component('l', "User Manager"));
		develop.add(new Component('s', "Api"));
		size = develop.size();
	}

	public Queue<Component> getDevelop() {
		return develop;
	}

	public Queue<Component> getTesting() {
		return testing;
	}

	public Queue<Component> getFinished() {
		return finished;
	}

	public void removedev(){
		develop.remove(develop.peek());
	}

	public void adddev(Component c){
		develop.add(c);
	}

	public Component nexttest(){
		return testing.remove();
	}

	public void addtest(Component c){
		testing.add(c);
	}


	public void removeTest() {
		testing.remove(testing.peek());
	}

	public void addfin(Component c) {
		finished.add(c);
	}

	public int getsize(){
		return size;
	}
}
