package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Concerts {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    private Double price;
    private int capacity;

    @ManyToOne
    private Users organizer;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<Tickets> tickets = new ArrayList<>();

    public Concerts() {}

    public Concerts(int capacity, LocalDateTime date, String description, Long id, String location, Users organizer, Double price, List<Tickets> tickets, String title) {
        this.capacity = capacity;
        this.date = date;
        this.description = description;
        this.id = id;
        this.location = location;
        this.organizer = organizer;
        this.price = price;
        this.tickets = tickets;
        this.title = title;
    }

    public Concerts(int capacity, LocalDateTime date, String description, String location, Users organizer, Double price, String title, List<Tickets> tickets) {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Users getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Users organizer) {
        this.organizer = organizer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
