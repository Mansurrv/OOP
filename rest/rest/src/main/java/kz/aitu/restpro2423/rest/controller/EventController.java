package kz.aitu.restpro2423.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.aitu.restpro2423.rest.dbconnection.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private DatabaseConnector databaseConnector;

    // Получить все события из базы данных
    @GetMapping
    public List<kz.aitu.restpro2423.rest.entities.Event> getAllEvents() {
        List<kz.aitu.restpro2423.rest.entities.Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (Connection conn = databaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                events.add(new kz.aitu.restpro2423.rest.entities.Event(
                        rs.getString("event_name"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getInt("max_participants"),
                        rs.getDouble("ticket_price"),
                        rs.getString("organizer"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Найти событие по имени из базы данных
    @GetMapping("/search")
    public List<kz.aitu.restpro2423.rest.entities.Event> searchEventsByName(@RequestParam String name) {
        List<kz.aitu.restpro2423.rest.entities.Event> events = new ArrayList<>();
        String query = "SELECT * FROM events WHERE LOWER(event_name) LIKE ?";
        try (Connection conn = databaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + name.toLowerCase() + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    events.add(new kz.aitu.restpro2423.rest.entities.Event(
                            rs.getString("event_name"),
                            rs.getString("date"),
                            rs.getString("location"),
                            rs.getInt("max_participants"),
                            rs.getDouble("ticket_price"),
                            rs.getString("organizer"),
                            rs.getString("description")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Добавить новое событие в базу данных
    @PostMapping
    public kz.aitu.restpro2423.rest.entities.Event createEvent(@RequestBody kz.aitu.restpro2423.rest.entities.Event event) {
        String query = "INSERT INTO events (event_name, date, location, max_participants, ticket_price, organizer, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getMaxParticipants());
            stmt.setDouble(5, event.getTicketPrice());
            stmt.setString(6, event.getOrganizer());
            stmt.setString(7, event.getDescription());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    // Удалить событие по имени из базы данных
    @DeleteMapping("/{name}")
    public String deleteEvent(@PathVariable String name) {
        String query = "DELETE FROM events WHERE event_name = ?";
        try (Connection conn = databaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Event deleted successfully." : "Event not found.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
    }

    // Сортировать события по дате из базы данных
    @GetMapping("/sort")
    public List<kz.aitu.restpro2423.rest.entities.Event> sortEventsByDate() {
        List<kz.aitu.restpro2423.rest.entities.Event> events = new ArrayList<>();
        String query = "SELECT * FROM events ORDER BY date";
        try (Connection conn = databaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                events.add(new kz.aitu.restpro2423.rest.entities.Event(
                        rs.getString("event_name"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getInt("max_participants"),
                        rs.getDouble("ticket_price"),
                        rs.getString("organizer"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}