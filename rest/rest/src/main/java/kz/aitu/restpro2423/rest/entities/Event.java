package kz.aitu.restpro2423.rest.entities;

import java.util.Objects;

// Event class
public class Event {
    private String eventName;
    private String date;
    private String location;
    private int maxParticipants;
    private double ticketPrice;
    private String organizer;
    private String description;

    public Event(String eventName, String date, String location, int maxParticipants, double ticketPrice, String organizer, String description) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.ticketPrice = ticketPrice;
        this.organizer = organizer;
        this.description = description;
    }

    // Getters and Setters
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }

    public String getOrganizer() { return organizer; }
    public void setOrganizer(String organizer) { this.organizer = organizer; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Event: " + eventName + ", Date: " + date + ", Location: " + location + ", Max Participants: " + maxParticipants +
                ", Ticket Price: $" + ticketPrice + ", Organizer: " + organizer + ", Description: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        kz.aitu.restpro2423.rest.entities.Event event = (kz.aitu.restpro2423.rest.entities.Event) o;
        return maxParticipants == event.maxParticipants &&
                Double.compare(event.ticketPrice, ticketPrice) == 0 &&
                eventName.equals(event.eventName) &&
                date.equals(event.date) &&
                location.equals(event.location) &&
                organizer.equals(event.organizer) &&
                description.equals(event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, date, location, maxParticipants, ticketPrice, organizer, description);
    }
}
