package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Tickets {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Concerts concert;

    @ManyToOne
    private Users buyer;

    private LocalDateTime purchaseDate;

    @Enumerated(EnumType.STRING)
    private StatusTickets status;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Payment payment;

    public Tickets() {}

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Concerts getConcert() {
        return concert;
    }

    public void setConcert(Concerts concert) {
        this.concert = concert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public StatusTickets getStatus() {
        return status;
    }

    public void setStatus(StatusTickets status) {
        this.status = status;
    }
}
