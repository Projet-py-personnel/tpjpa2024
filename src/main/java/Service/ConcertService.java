package Service;

import dao.ConcertDao;
import domain.Concert;

import java.util.List;

public class ConcertService {
    static ConcertDao dao = new ConcertDao();

    // Méthode pour ajouter un concert
    public static void addConcert(Concert concert) {
        dao.save(concert);
    }

    // Méthode pour obtenir un concert
    public static Concert getConcert(Long id) {
        return dao.get(id);
    }

    // Méthode pour récupérer plusieurs concerts
    public static List<Concert> getConcerts(List<Long> ids) {
        return dao.get(ids);
    }

    // Méthode pour récupérer tous les concerts
    public static List<Concert> getAllConcerts() {
        return dao.getAllConcerts();
    }

    // Méthode pour mettre à jour le titre d'un concert
    public static void updateTitle(String newTitle, String oldTitle) {
        dao.updateTitle(newTitle, oldTitle);
    }

    // Méthode pour supprimer des concerts
    public static void deleteConcert(List<Long> ids) {
        dao.delete(ids);
    }
}
