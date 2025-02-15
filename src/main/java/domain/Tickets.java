package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Tickets {

    /// Les attributs de Tickets:
    /// Les informations du clients et
    /// Les informations du concert
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Client buyer;
    @ManyToOne
    private Concerts concert;
    private LocalDateTime purchaseDate;
    private String paymentMethod;

    /// Les constructeurs de Tickets:
    public Tickets() {}
    public Tickets(Client buyer, Concerts concert, LocalDateTime purchaseDate, String paymentMethod) {
        this.buyer = buyer;
        this.concert = concert;
        this.purchaseDate = purchaseDate;
        this.paymentMethod = paymentMethod;
    }
    /// Les méthodes de Tickets:

    /// les getters
    public Long getId() {
        return id;
    }

    public Client getBuyer() {
        return buyer;
    }

    public Concerts getConcert() {
        return concert;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    /// les setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public void setConcert(Concerts concert) {
        this.concert = concert;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
