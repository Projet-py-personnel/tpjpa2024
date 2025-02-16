package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    /// Les attributs de Tickets:
    /// Les informations du clients et
    /// Les informations du concert
    /// mappedBy. Cette propriété est valide dans le contexte de la bidirectionnalité, car elle indique le nom de l’attribut dans l’autre entité
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Client buyer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "concert_id")
    private Concert concert;
    private LocalDateTime purchaseDate;
    private String paymentMethod;
    private Double prix;

    /// Les constructeurs de Tickets:
    public Ticket() {}
    public Ticket(Client buyer, Concert concert, LocalDateTime purchaseDate, String paymentMethod) {
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

    public Concert getConcert() {
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

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
