package domain;

import jakarta.persistence.*;
import javax.management.relation.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personnes")
public class Personne {
    /// les attributs de la classse personne
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    /// les constructeur de la classse personne:
    /// constructeur vide
    /// Constructeurs paramétrés
    /// après on pourra ajouter d'autres constructeurs
    /// si le modèle métier le permet

    public Personne() {
    }
    public Personne(String email, Long id, String name, String password){
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /// les getters de la classse personne:
    /// le id n'est pas dans un constructeur
    /// car il sera généré à chaque getId()


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    /// les setters de la classse personne:
    /// le id n'est pas dans un constructeur
    /// car il sera généré à chaque getId()
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPassword(String password) { this.password = password;}
    public void setEmail(String email) {this.email = email;}

    /// nous créons ce toString Par défaut afin de
    /// afficher un objet de la classe
    /// quand on en a besoin
    @Override
    public String toString() {
        return "Personne [id=" + id + ", name=" + name + ", email="
                + email + "]";
    }

    /*
    @Enumerated(EnumType.STRING)
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
    */
}












