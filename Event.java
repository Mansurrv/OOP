public class Event {

    private int hour;
    private int minute;
    private int day;

    public Event(int hour, int munute, int day){
        setevent(hour, munute, day);
        System.out.println(getevent());
    }

    public void setevent(int _hour, int _minute, int _day){
        hour = _hour;
        minute = _minute;
        day = _day;
    }

    public String getevent(){
        String res2 = "Event: " + day + " number, " + hour + ":" + minute;
        return res2;
    }

}
