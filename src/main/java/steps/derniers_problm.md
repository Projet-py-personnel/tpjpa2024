# Les derniers probl_mes que j'ai eu 
1) Quand je lance mon serveur jetty l'index affiché n'est pas celui dans mon webApp
        résolution: en fait mon dossier webApp était censé ce trouver dans dans main, alors que moi je l'avais mis à la mauvaise racine
2) Malgré que ya plus myForm.html, et l'ancien index.html dans mon dossier webApp 
        que je tape leur url ils s'affichent toujours est ce moi qui est mal supprimé, 
        j'ai fait un clean de maven une fois ca na pas resolu le problème, je le retente une seconde fois
        Ca n'a pas résolu le problème: 
                Analyse des probable sources du problème: soit ces deux fichiers là sont toujours enregistrés quelques part
                et il y a un mécanisme qui permet d'aller les chercher. On va parcourir tous les fichiers de style configuration plutard pour essayer de résoudre 
                ces problèmes mais pour le moment avancons.
3) >Note: est ce que c'est pas parceque j'ai mis mes codes dans le dossier servelets peut etre que je dois préciser cela dans une route mais ou ?