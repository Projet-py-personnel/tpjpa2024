package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "concerts")//on peut s'en passer si les noms sont similaires
public class Concert {
    /// attributs de concert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrémentation
    @Column(name="concert_id")// nom de la colonne en bd mais on peut s'en passer si les noms sont similaires
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;//heure de début
    private String location;
    private int capacity;// nombres de places totales
    //private int nb_participants;// nombres de tickets pris, doit etre dans une classe association entre organisateurs et concerts
    //@JoinColumn : Cette annotation permet d’indiquer le nom de la clé étrangère dans la table de l’entité concernée.
    private String artiste;
    private String genreMusical;
    private LocalDateTime heure_fin;
    private String statut;//annulé ou confirmé

   /* @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true)
    private List<Ticket> tickets = new ArrayList<>(); pour moi concert n'a pas besoin de la liste de tickets*/




    /// constructeurs

    public Concert( String title, LocalDateTime date, String location, String artiste, LocalDateTime heure_fin) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.artiste = artiste;
        this.heure_fin = heure_fin;


    }

    public Concert() {
        /*this(null);quand faut il utiliser cela ?*/
    }
    /// les méthodes de concert
    /// les getters
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

    /*public int getNb_participants() {
        return nb_participants;
        doit etre dans la classe association organisation
    }*/

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







    /// les setters
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

    /*public void setNb_participants(int nb_participants) {
        this.nb_participants = nb_participants;
    } doit etre dans la classe association organisation*/

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





   /* @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;*/
}
