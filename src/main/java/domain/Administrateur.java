package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="administrateurs")
public class Administrateur extends Personne{
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="admin_id")
    private List<Concert> concerts = new ArrayList<>();

    /// methodes Administrateur
    ///
    /// constructeurs


    public Administrateur(String email, String name, String password) {
        super(email, name, password);
    }

    public Administrateur() {

    }

    /// getters et setters
    public List<Concert> getConcerts() {
        return concerts;
    }
    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }


}

