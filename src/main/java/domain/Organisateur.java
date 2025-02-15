package domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="organisateurs")
public class Organisateur extends Personne{
    /// attributs

    private String groupe;//son entreprise par exemple
    @ManyToMany(cascade= CascadeType.ALL,mappedBy="organisateurs")
    private List<Concerts> concerts = new ArrayList<>();
    /// constructeurs

    public Organisateur(String groupe, List<Concerts> concerts) {
        this.groupe = groupe;
        this.concerts = concerts;
    }

    public Organisateur(String email, Long id, String name, String password, String groupe, List<Concerts> concerts) {
        super(email, id, name, password);
        this.groupe = groupe;
        this.concerts = concerts;
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

    public List<Concerts> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concerts> concerts) {
        this.concerts = concerts;
    }
    /// autres methodes

}
