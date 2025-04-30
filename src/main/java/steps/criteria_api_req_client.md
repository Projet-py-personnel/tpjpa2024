# creer et executer des requete avec criteria API
>Note:execution- A CriteriaQuery is executed in a similar fashion to a string-based JPQL query via the EntityManager and Query interfaces.

1) ### update
    #### Copier la méthode update suivante dans \dao\ClientDao.java:

    ``` 
    public void updateName(String newName,String oldName) {
            //EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            CriteriaBuilder cb = this.manager.getCriteriaBuilder();
            // create update
            CriteriaUpdate<Client> update = cb.
            createCriteriaUpdate(Client.class);
            // set the root class
            Root e = update.from(Client.class);
            // set update and where clause
            update.set("name", newName);
            update.where(cb.equal(e.get("name"), oldName));
            Query query = manager.createQuery(update);
            int result = query.executeUpdate();
            tx.commit();
            // essayer de trouver la bonne formule pour cette méthode
            //retrouver le client par son id
            //et etre capable de changer tous les attributs qu'elle veut
        }
    ```
    
    #### ajouter cette ligne la dans le fichier \Service\ClientService.java:
    ```
        public static void updateName(String newName, String oldName) {
        dao.updateName(newName,oldName);
      }
    ```
    
    #### ajouter cette ligne la dans le fichier \jpa\JpaTest.java:
    ```
        public void updateClientOfDatabase(String newName, String oldName) {
        
        ClientService.updateName(newName, oldName);
        }
    ```
    #### Et transformer la méthode main du meme fichier en :
    
    ```
        public static void main(String[] args) {
    
    
            JpaTest test = new JpaTest();
    
            Client c1,c2,c3;
            c1=new Client("jojo@gmail.com", "Jojo", "jojo");
            c2=  new Client("jaja@gmail.com","jaja","jaja");
            c3=  new Client("jiji@gmail.com","jiji","jiji");
            ArrayList<Client> clientsLists= new ArrayList<>();
    
            clientsLists.add(c1);
            clientsLists.add(c2);
            clientsLists.add(c3);
            boolean creer = true; // configuration manuelle pour que le code ne se persite pas 2 fois ( à automatiser )
    
            try {
                // TODO create and persist entity
                if (!creer){
    
                for (Client c : clientsLists) {
    
                        test.addClientToDatabase(c);
    
                }
                    creer = false;
                }
                
                test.updateClientOfDatabase("francky","Franck");
                
    
            } catch (Exception e) {
                e.printStackTrace();
            }
    
    
            System.out.println(".. done");
    }
    ```
2) ### deleteClient-similaire que la méthode précédente: 1) :

   #### Copier la méthode delete suivante dans \dao\ClientDao.java:
     ```
             public void delete(Integer id) {
    
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            CriteriaBuilder cb = this.manager.getCriteriaBuilder();
    
            // create delete
            CriteriaDelete<Client> delete = cb.
                    createCriteriaDelete(Client.class);
    
            // set the root class
            Root e = delete.from(Client.class);
    
            // set where clause
            delete.where(cb.equal(e.get("id"), id));
    
            // perform update
            this.manager.createQuery(delete).executeUpdate();
            tx.commit();
       }
    ```
   #### Dans ClientService ajouter : 
   ``` 
     public static void deleteClient(Integer id) {
     dao.delete(id);
   }
   ```
   #### Dans jpaTest ajouter :
     ```
         public void deleteClientFromDatabase(Integer id) {
            ClientService.deleteClient(id);
      }
    ```
   #### et ajouter la ligne suivante au main de jpaTest :
      ```
        test.deleteClientFromDatabase(153);
     ```
#### Copier la méthode deleteClient suivante dans \Service\ClientService.java:
 ```
          public static void deleteClient() {
          dao.delete(1);
 ```
      }
#### Copier la méthode delete suivante dans \Service\JpaTest.java:
  ```
         public void deleteClientFromDatabase() {
            ClientService.deleteClient();
         }
  ```
#### l'executer dans la méthode main cela donne:
```
           public static void main(String[] args) {
           JpaTest test = new JpaTest();
            try {
                test.addClientToDatabase();
                test.deleteClientFromDatabase();
                } catch (Exception e) {
			            e.printStackTrace();
		        }
           }
           
```
Puis run (builder) la classe JpaTest
3) ### get(id)- Copier la méthode update suivante dans \dao\ClientDao.java:
```
    public Client get( Integer id ) {
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            CriteriaBuilder cb = this.manager.getCriteriaBuilder();
            // create get query
            CriteriaQuery<Client> get = cb.createQuery(Client.class);
            // set the root class
            Root e = get.from(Client.class);
            // set where clause
            get.where(cb.equal(e.get("id"), id));
            // perform the query and get the result
            Client client = manager.createQuery(get).getSingleResult();
            tx.commit();
            return client;
        }
```
#### Puis ce bloc de code dans ClienService:
```
    public static Client getClient(Integer id) {
        return dao.get(id);
    }
```
#### Puis cette méthode dans JPATEST:
```
    public Client getClientFromDatabase(Integer id) {
        return ClientService.getClient( id );
    }
```
4) ### get une liste d'id pour obtenir une liste de clients (meme schéma que les précédents ):
https://stackoverflow.com/questions/71208850/add-query-hint-inside-of-jpa-specification
https://stackoverflow.com/questions/5705291/select-in-equivalent-in-jpa2-criteria

```
    public List<Client> get(List<Integer> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        // create get query
        CriteriaQuery<Client> get = cb.createQuery(Client.class);
        // set the root class

        Root e = get.from(Client.class);
        // set where clause
        get.where(
                cb.in(
                        e.get("id")).value(ids)
        );
        List<Client> posts = manager
                .createQuery(get)
                .setHint("hint_name", "hint_value")
                .getResultList();
        tx.commit();
        return posts;
    }
```
#### Dans clientService:
```
    public static List<Client> getClient(List<Integer> ids) {
        return dao.get(ids);
    }
```
#### Dans JPA TEST :
```
    public List<Client> getClientsFromDatabase(List<Integer> ids) {
        return ClientService.getClient( ids );
    }
```
#### Dans le main :
```
    List<Integer> ids = new ArrayList<>();
    ids.add(203);
    ids.add(252);
    ids.add(253);
    List<Client> clients_result=test.getClientsFromDatabase(ids);
      int i=0;
      for (Client c : clients_result) {
        System.out.println(clients_result.get(i).getName());
        ++i;
      }
```
5) ### charger la table entière des clients
https://stackoverflow.com/questions/11669868/jpa-criteria-query-load-entire-table
#### in dao file paste this code : 
```
       public List<Client> getAllClients() {
    
    
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            CriteriaBuilder cb = this.manager.getCriteriaBuilder();
            // create get query
            CriteriaQuery<Client> get = cb.createQuery(Client.class);
            // set the root class
            Root e = get.from(Client.class);
            // match the entire root( table to the query get ) 
            get.select(e);
            //execute the query
            List<Client> table_content= manager.createQuery(get).getResultList();
            tx.commit();
            return table_content;
        }
```
#### in clientService file :
```
    public static List<Client> getAllClients() {
        return dao.getAllClients();
    }
```
#### in JPATEST methods :
```
    public List<Client> getAllClients() {
        return ClientService.getAllClients();
    }
```
#### in JPATEST main method:
```
    List<Client>all_clients=test.getAllClients();
    int j=0;
    for (Client c : all_clients) {
        System.out.println(all_clients.get(j).getName());
        ++j;
    }
```
6) ### suppressions simultanés d'une liste de clients :
#### dans le dao coller le code suivant :
```
       public void delete(List<Integer> ids) {
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            CriteriaBuilder cb = this.manager.getCriteriaBuilder();
            CriteriaDelete<Client> delete = cb.createCriteriaDelete(Client.class); // create delete
            Root e = delete.from(Client.class);// set the root class
            delete.where(cb.in(e.get("id")).value(ids)); // set where clause
            this.manager
                    .createQuery(delete)
                    .setHint("id", "client")
                    .executeUpdate();  // perform update
            tx.commit();
        }
   ```
####   Dans la couche service :
```
   public static void deleteClient(List<Integer> ids) {
      dao.delete(ids);
   }
 ```
#### Dans la couche JpaTest :
 ```
   public void deleteClientFromDatabase(List<Integer> ids) {
        ClientService.deleteClient(ids); 
   }
 ```
#### Dans la method main du meme JPATEST :
```
    List<Integer> ids_to_delete = new ArrayList<>();
    ids_to_delete.add(2);
    ids_to_delete.add(52);
    ids_to_delete.add(53);
    ids_to_delete.add(54);
    ids_to_delete.add(102);
    ids_to_delete.add(104);
    test.deleteClientFromDatabase(ids_to_delete);
 ```
Après si on veut extrapoler on peut faire suppression de la table entière.
# Ressources
    https://openjpa.apache.org/builds/3.2.0/apache-openjpa/docs/jpa_overview_criteria.html
    https://www.objectdb.com/api/java/jpa/Query/executeUpdate() (question 2)
    https://thorben-janssen.com/criteria-updatedelete-easy-way-to/ (syntax)
    https://stackoverflow.com/questions/36601251/how-to-open-an-entity-manager-after-a-close (reopen an em)
    https://www.jmdoudoux.fr/java/dej/chap-javadoc.htm (tuto javadoc)
    https://www.markdowntutorial.com/lesson/2/ 