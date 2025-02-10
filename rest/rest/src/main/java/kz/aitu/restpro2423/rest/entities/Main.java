package kz.aitu.restpro2423.rest.entities;

import java.util.Scanner;
import java.util.List;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager();

        while (true) {
            System.out.println("\nEvent Management System");
            System.out.println("1. Create Event");
            System.out.println("2. View All Events");
            System.out.println("3. Search Event by Name");
            System.out.println("4. Sort Events by Date");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Event Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();

                    System.out.print("Enter Max Participants: ");
                    int maxParticipants = scanner.nextInt();

                    System.out.print("Enter Ticket Price: ");
                    double ticketPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Organizer: ");
                    String organizer = scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    kz.aitu.restpro2423.rest.entities.Event newEvent = new kz.aitu.restpro2423.rest.entities.Event(name, date, location, maxParticipants, ticketPrice, organizer, description) {
                    };
                    manager.saveEvent(newEvent);
                    System.out.println("Event created successfully!");
                    break;

                case 2:
                    List<kz.aitu.restpro2423.rest.entities.Event> events = manager.getAllEvents();
                    if (events.isEmpty()) {
                        System.out.println("No events found.");
                    } else {
                        System.out.println("\nAll Events:");
                        for (kz.aitu.restpro2423.rest.entities.Event event : events) {
                            System.out.println(event);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Event Name to Search: ");
                    String searchName = scanner.nextLine();
                    List<kz.aitu.restpro2423.rest.entities.Event> foundEvents = manager.searchEventsByName(searchName);
                    if (foundEvents.isEmpty()) {
                        System.out.println("No events found with the name: " + searchName);
                    } else {
                        System.out.println("\nFound Events:");
                        for (kz.aitu.restpro2423.rest.entities.Event event : foundEvents) {
                            System.out.println(event);
                        }
                    }
                    break;

                case 4:
                    List<kz.aitu.restpro2423.rest.entities.Event> sortedEvents = manager.sortEventsByDate();
                    if (sortedEvents.isEmpty()) {
                        System.out.println("No events to sort.");
                    } else {
                        System.out.println("\nEvents Sorted by Date:");
                        for (kz.aitu.restpro2423.rest.entities.Event event : sortedEvents) {
                            System.out.println(event);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
