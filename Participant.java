package ProjectOOP;

public class Participant {

    public String name;
    public String surname;

    public Participant(String name, String surname){
        setvalue(name, surname);
        System.out.println(getvalue());
    }

    public void setvalue(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getvalue(){
        String res = "Participant: "+this.name+" "+this.surname;
        return res;
    }

}
