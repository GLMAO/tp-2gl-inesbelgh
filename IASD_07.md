IASD_07


# TP2 – Génie Logiciel : Design Patterns

## Sujet
Gestion de l’emploi du temps : amélioration du système actuel en utilisant trois design patterns :
- **Builder** pour construire des objets `Cours`
- **Observer** pour notifier automatiquement les changements
- **Decorator** pour ajouter des fonctionnalités aux cours

---

## Exercice 1 : Builder
### Objectif
Simplifier la création de cours avec de nombreux attributs.

### Réalisation
- Création de la classe `CoursBuilder`  
- Méthodes fluides (`setMatiere()`, `setEnseignant()`, etc.)  
- `build()` retourne un objet `Cours` complet

### Exemple
```java
Cours cours = new CoursBuilder()
    .setMatiere("Génie Logiciel")
    .setEnseignant("Beghaouti ines")
    .setSalle("D25")
    .build();  

## Exercice 2 : Notification de changement (Pattern Observer)
### Objectif
Notifier automatiquement les étudiants et le responsable pédagogique lorsqu’un cours est modifié ou annulé.

### Réalisation
   .GestionnaireEmploiDuTemps implémente Subject

   .Méthodes : attach(Observer), detach(Observer), notifyObservers(String message)

   .Etudiant et Responsable implémentent Observer

   .Méthodes ajouterCours() et modifierCours() notifient les observateurs
### Exemple
```java
Etudiant e1 = new Etudiant("Racha");
Responsable r1 = new Responsable("mr prof");

gestionnaire.attach(e1);
gestionnaire.attach(r1);

gestionnaire.ajouterCours(cours); 

## Exercice 3 : Extension des caractéristiques (Pattern Decorator)
### Objectif
Ajouter dynamiquement des caractéristiques aux cours sans modifier la classe de base.

### Réalisation
   .Création de CoursDecorator abstrait

   .Exemple : CoursEnLigne ajoute "(En ligne)" à la description

   .Possibilité de combiner plusieurs décorateurs
### Exemple
```java
ICours coursEnLigne = new CoursEnLigne(cours);
System.out.println(coursEnLigne.getDescription()); // "Génie Logiciel (En ligne)"
System.out.println(coursEnLigne.getDuree());
###Diagramme de classes (ASCII)
          +----------------------+
          |       ICours         |
          +----------------------+
          | +getDescription()    |
          | +getDuree()          |
          +----------------------+
                    ^
                    |
           +------------------+
           |      Cours       |
           +------------------+
           | -matiere         |
           | -enseignant      |
           | -salle           |
           | ...              |
           +------------------+
                    ^
                    |
           +----------------------+
           |    CoursDecorator    |
           +----------------------+
           | -coursDecorated      |
           +----------------------+
                    ^
                    |
           +------------------+
           |   CoursEnLigne   |
           +------------------+

          +-----------------------------+
          | GestionnaireEmploiDuTemps  |<------ Subject
          +-----------------------------+
          | -listeCours                |
          | -observers                 |
          +-----------------------------+
          | +attach(Observer)          |
          | +detach(Observer)          |
          | +notifyObservers(String)   |
          | +ajouterCours(ICours)      |
          | +modifierCours(ICours,String)|
          +-----------------------------+
                    ^
                    |
          +-------------------+
          |   Observer        |<---- interface
          +-------------------+
          | +update(String)   |
          +-------------------+
           /              \
          /                \
 +---------------+   +----------------+
 |   Etudiant    |   |  Responsable   |
 +---------------+   +----------------+
 | -nom          |   | -nom           |
 | +update()     |   | +update()      |
 +---------------+   +----------------+
Le code respecte globalement les principes SOLID : SRP, OCP, DIP.

La conception est modulaire, maintenable et extensible.

Les seules limites théoriques concernent le LSP et le couplage potentiel si on ajoutait trop de logique dans notifyObservers()