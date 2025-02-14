package domain;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Roles role;
    private List<Tickets> tickets = new ArrayList<>();

    public Users(){

    }

    public Users(String email, Long id, String name, String password, Roles role, List<Tickets> tickets) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.tickets = tickets;
    }

    public Users(String name, String email, Roles role) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Enumerated(EnumType.STRING)
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }
}
