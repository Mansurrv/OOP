package kz.aitu.restpro2423.rest.entities;

import kz.aitu.restpro2423.rest.dbconnection.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventManager {
    // Save Event
    public void saveEvent(kz.aitu.restpro2423.rest.entities.Event event) {
        String query = "INSERT INTO events (event_name, date, location, max_participants, ticket_price, organizer, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getMaxParticipants());
            stmt.setDouble(5, event.getTicketPrice());
            stmt.setString(6, event.getOrganizer());
            stmt.setString(7, event.getDescription());
            stmt.executeUpdate();
            System.out.println("Event saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch all events
    public List<kz.aitu.restpro2423.rest.entities.Event> getAllEvents() {
        List<kz.aitu.restpro2423.rest.entities.Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (Connection conn = DatabaseConnector.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                events.add(new kz.aitu.restpro2423.rest.entities.Event(
                        rs.getString("event_name"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getInt("max_participants"),
                        rs.getDouble("ticket_price"),
                        rs.getString("organizer"),
                        rs.getString("description")
                ) {});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Search events by name
    public List<kz.aitu.restpro2423.rest.entities.Event> searchEventsByName(String name) {
        return getAllEvents().stream()
                .filter(event -> event.getEventName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Sort events by date
    public List<kz.aitu.restpro2423.rest.entities.Event> sortEventsByDate() {
        return getAllEvents().stream()
                .sorted((e1, e2) -> e1.getDate().compareTo(e2.getDate()))
                .collect(Collectors.toList());
    }
}
