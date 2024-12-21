package ProjectOOP;

public class EventManager {

    private String name;

    public EventManager(String name){
        setName(name);
        System.out.println(getName());
    }

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        String res3 = "Name eventManager is: "+name;
        return res3;
    }
}
