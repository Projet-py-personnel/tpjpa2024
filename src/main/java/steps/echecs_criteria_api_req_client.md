1) tentative de reouvir manager et EntityManagerFactory
    Dans les méthode add,update,delete dans \dao\ClientDao.java:
    Le fait de fermer les deux objets a la fin de chaque méthode
    nous pousse aussi à les réouvrir s'ils sont fermés en début de chaque
    méthode.Ainsi j'ai essayé les bloc de code suivants en début de chaque méthode:

   if (! manager.getEntityManagerFactory().isOpen() ) {
   EntityManagerFactory managerFactory = manager.getEntityManagerFactory();
   }

    if (!manager.isOpen())
            manager = manager.getEntityManagerFactory().createEntityManager();

   Vu que ca n'a rien changé à l'erreur : IllegalStateException: Session/EntityManager is closed

2) J'ai décidé d'adopter une autre stratégie :
   ne plus fermer les entityManagerFactory seulement en supprimant les lignes suivantes dans add, update, delete (voir si on peut les mettres ailleurs après)
   manager.close();
   EntityManagerHelper.closeEntityManagerFactory(); 
   
    Et donc plus la peine, d'avoir ces blocs de code là, les supprimer:

   if (! manager.getEntityManagerFactory().isOpen() ) {
   EntityManagerFactory managerFactory = manager.getEntityManagerFactory();
   }
   if (!manager.isOpen())
   manager = manager.getEntityManagerFactory().createEntityManager();
   
  Tenter de comprendre l'erreur avec une interpretation de cette phrase de https://stackoverflow.com/questions/36601251/how-to-open-an-entity-manager-after-a-close plutard:

  ``` In a JavaEE environment you should not use RESOURCE_LOCAL, but JTA. You can inject the EntityManager with @PersistenceContext and since EJBs are transactional already, you do not have to commit, close ect.

      For a RESOURCE_LOCAL EntityManager like in your example above you cannot re-use a closed EntityManager, but must create a new one by using the factory.
  ```