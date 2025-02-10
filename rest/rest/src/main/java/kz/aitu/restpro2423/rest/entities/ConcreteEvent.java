package kz.aitu.restpro2423.rest.entities;

public class ConcreteEvent extends Event {
    public ConcreteEvent(String eventName, String date, String location, int maxParticipants, double ticketPrice, String organizer, String description) {
        super(eventName, date, location, maxParticipants, ticketPrice, organizer, description);
    }
}
