package kz.aitu.restpro2423.rest.dbconnection;
import kz.aitu.restpro2423.rest.entities.Event;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Manser2006";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fetch all events
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (Connection con = connect(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                events.add(new Event(
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

    // Fetch an event by name
    public Event findEventByName(String eventName) {
        String query = "SELECT * FROM events WHERE event_name = ?";
        try (Connection con = connect(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, eventName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Event(
                        rs.getString("event_name"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getInt("max_participants"),
                        rs.getDouble("ticket_price"),
                        rs.getString("organizer"),
                        rs.getString("description")
                ) {};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save a new event
    public boolean saveEvent(Event event) {
        String query = "INSERT INTO events (event_name, date, location, max_participants, ticket_price, organizer, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = connect(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getMaxParticipants());
            stmt.setDouble(5, event.getTicketPrice());
            stmt.setString(6, event.getOrganizer());
            stmt.setString(7, event.getDescription());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing event
    public boolean updateEvent(String oldName, Event updatedEvent) {
        String query = "UPDATE events SET event_name = ?, date = ?, location = ?, max_participants = ?, ticket_price = ?, organizer = ?, description = ? WHERE event_name = ?";
        try (Connection con = connect(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, updatedEvent.getEventName());
            stmt.setString(2, updatedEvent.getDate());
            stmt.setString(3, updatedEvent.getLocation());
            stmt.setInt(4, updatedEvent.getMaxParticipants());
            stmt.setDouble(5, updatedEvent.getTicketPrice());
            stmt.setString(6, updatedEvent.getOrganizer());
            stmt.setString(7, updatedEvent.getDescription());
            stmt.setString(8, oldName);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete an event
    public boolean deleteEvent(String eventName) {
        String query = "DELETE FROM events WHERE event_name = ?";
        try (Connection con = connect(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, eventName);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
