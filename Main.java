public class Main {

    public static void Main(String[] args){

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for(int i=0; i<=count; i++){
            System.out.println("Enter your name,surname: ");
            Scanner scan2 = new Scanner(System.in);
            String name = scan2.nextLine();
            System.out.println("Enter your surname: ");
            Scanner scan3 = new Scanner(System.in);
            String surname = scan3.nextLine();
            Participant part1 = new Participant(name, surname);
        }

        Event date1 = new Event(12,45,9);

        EventManager name1 = new EventManager("Serikbai Mansur");

    }

}
