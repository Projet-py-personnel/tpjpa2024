# Template de projet pour le TP JPA 2021 UniR
# Compte Rendu du Projet : À la découverte de JPA

# Introduction
Le projet a pour objectif la mise en place d'une application de vente de tickets de concert en ligne en utilisant Java Persistence API (JPA) pour la gestion des données. La première étape du projet s'est concentrée sur la modélisation du métier et l'implémentation de la couche de persistance.
# Déroulement du Projet
# 2. Modélisation du Métier
Un diagramme de classes a été conçu pour représenter les entités principales du système, incluant :
Utilisateur (id, nom, email, liste de tickets)
Concert (id, artiste, date, lieu, prix, capacité)
Ticket (id, type, prix, statut, utilisateur)
Organisateur (id, nom, liste de concerts)
Administrateur (id, nom, rôle, gestion des événements)
Ces entités ont été transformées en classes Java avec annotations JPA.
Mise en Place de JPA , des Services et des DAO
Actuellement, le travail se concentre sur la mise en place des services et des DAO.
# 3. Difficultés Rencontrées
Des difficultés ont été rencontrées lors de la fusion des branches avec le master, notamment en raison de conflits liés aux fichiers propres au serveur et aux ide. Ces problèmes ont été résolus après plusieurs tentative de résolutions de conflits et d'ignorer ces fichiers.
# 4. Etape suivante
La prochaine étape concerne l'intégration des DTO, Servlet et API REST.
# 5. Repositorie
Sur notre repo, nous avons trois branches
branch2, branch/franck et le master.
La branche master et la branch 2 comporte l'integralité du projet.
