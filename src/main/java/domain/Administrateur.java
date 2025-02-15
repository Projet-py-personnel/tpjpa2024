package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="administrateurs")
public class Administrateur extends Personne{
    @OneToMany(cascade= CascadeType.ALL,mappedBy="organisateurs")
    private List<Concerts> concerts = new ArrayList<>();

    /// methodes Administrateur
    ///
    /// constructeurs
    public Administrateur(List<Concerts> concerts) {
        this.concerts = concerts;
    }

    public Administrateur(String email, Long id, String name, String password, List<Concerts> concerts) {
        super(email, id, name, password);
        this.concerts = concerts;
    }

    public Administrateur() {

    }

    /// getters et setters
    public List<Concerts> getConcerts() {
        return concerts;
    }
    public void setConcerts(List<Concerts> concerts) {
        this.concerts = concerts;
    }


}

