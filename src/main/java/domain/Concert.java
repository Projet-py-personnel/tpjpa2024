package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "concerts") // Nom de la table dans la base de données (facultatif si c'est le même que le nom de la classe)
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrémentation
    @Column(name = "concert_id") // Nom de la colonne en base (facultatif si c'est le même que le nom du champ)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime date; // Heure de début
    private String location;
    private int capacity; // Nombre de places totales
    private String artiste;
    private String genreMusical;
    private LocalDateTime heure_fin;
    private String statut; // Annulé ou confirmé

    // Constructeurs
    public Concert(String title, LocalDateTime date, String location, String artiste, LocalDateTime heure_fin) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.artiste = artiste;
        this.heure_fin = heure_fin;
    }

    public Concert() {
        // Constructeur par défaut
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getGenreMusical() {
        return genreMusical;
    }

    public LocalDateTime getHeure_fin() {
        return heure_fin;
    }

    public String getStatut() {
        return statut;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setGenreMusical(String genreMusical) {
        this.genreMusical = genreMusical;
    }

    public void setHeure_fin(LocalDateTime heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
