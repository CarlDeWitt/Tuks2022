import java.util.ArrayList;
public class Scrumboard {
    ArrayList<String> Todo = new ArrayList<String>();
    String[] alphabet={"A","B","C","D","E","F","G","H","I","J"};
    ArrayList<String> Completed = new ArrayList<String>();

    public Scrumboard(){
        for(int i = 0; i < alphabet.length; i++){
            Todo.add(alphabet[i]);
        }
    }

    public void print(){
        System.out.println();
        System.out.println("Printing Todo");
        if(!Todo.isEmpty()){
            for(String n : Todo){
                System.out.print(n + " ");
            }
        }else{
            System.out.print("Empty");
        }
        System.out.println();
        System.out.println("Printing Completed");
        if(!Completed.isEmpty()){
            for(String n : Completed){
                System.out.print(n + " ");
            }
        }
        else{
            System.out.println("Empty");
        }
        System.out.println();
    }

    public String nextItem(){
        return Todo.remove(0);
    }

    public void store(String n){
        Completed.add(n);
    }
}
