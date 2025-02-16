package domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*Au sein de la base de données, ces relations seront modélisées grâce à des clés étrangères (pour Un à un et Un à plusieurs), ou bien une table de jointure (pour Plusieurs à plusieurs)*/

@Entity
@Table(name="organisateurs")
public class Organisateur extends Personne implements Serializable {
    /// attributs

    private String groupe;//son entreprise par exemple
    @ManyToMany(cascade= CascadeType.REMOVE,
    fetch = FetchType.LAZY
    )
    @JoinTable(
        name="organisateur_concert",
            joinColumns = @JoinColumn(name="organisateur_id"),
            inverseJoinColumns = @JoinColumn(name="concert_id")

    )
    private List<Concert> concerts = new ArrayList<>();
    /// constructeurs


    public Organisateur(String email, String name, String password) {
        super(email, name, password);
    }

    public Organisateur() {

    }
    /// getters et setters
    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
    /// autres methodes

}
