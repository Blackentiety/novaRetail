
#  Projet NovaRetail : Pipeline de Données Legacy

Salut l'équipe ! 👋 Ce dépôt contient notre solution pour le projet NovaRetail. L'objectif est de transformer nos données clients "sales" (issues de notre vieille base MySQL) en un **Data Lake** propre, anonymisé et prêt pour l'analyse.

##  C'est quoi le concept ?

On a construit un petit moteur ETL (Extract-Transform-Load) en Java qui utilise **Apache Spark**. En gros, le programme aspire les données de la base `novaretail_legacy`, fait le ménage (RGPD, erreurs de saisie) et range tout ça dans des dossiers organisés par pays.

##  Ce qu'on a mis dedans

* **Spark SQL** : Pour traiter les données à la volée sans saturer la RAM.
* **JDBC** : Pour la passerelle avec notre base MySQL.
* **Partitionnement** : Les données sont triées par pays directement dans l'arborescence des dossiers (très utile pour le futur Data Lake !).

---

##  Comment lancer le projet ?

### 1. Préparer la base de données

Pas besoin de s'embêter à créer les tables à la main !

* Allez dans le dossier `/sql`.
* Importez le fichier `dump.sql` dans votre instance MySQL locale.
* *Note : Vérifiez bien que votre utilisateur MySQL a les droits en lecture.*

### 2. Configuration rapide

Dans la classe `NovaRetailPipeline.java`, jetez un œil aux variables de connexion (URL, User, Password) pour qu'elles correspondent à votre config locale :

```java
String url = "jdbc:mysql://localhost:3306/novaretail_legacy";
String user = "votre_nom";
String password = "votre_mot_de_passe";

```

### 3. Run !

Une fois que c'est fait, lancez simplement la classe principale. Le pipeline va s'occuper du reste et vous verrez les logs s'afficher dans la console.

---

##  Où sont les résultats ?

Une fois le programme terminé, un dossier `output/data_lake/` va apparaître à la racine.
Spark a été configuré pour **partitionner** les fichiers : vous y trouverez un dossier par pays (ex: `country=France`).