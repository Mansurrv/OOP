package ProjectOOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();

        System.out.println("Enter the number of participants: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your surname: ");
            String surname = scanner.nextLine();
            Participant participant = new Participant(name, surname);
            participants.add(participant);
        }

        Event event = new Event(12, 45, 9);
        EventManager eventManager = new EventManager("Serikbai Mansur");

        System.out.println("Event details: " + event);
        System.out.println(eventManager);
        System.out.println("Participants: ");
        participants.forEach(System.out::println);
    }
}
