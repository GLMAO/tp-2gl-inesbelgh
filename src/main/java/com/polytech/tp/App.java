package com.polytech.tp;

public class App {
    public static void main(String[] args) {

        System.out.println("===== TP2 – Test des Design Patterns =====\n");

        // ===========================
        // Exercice 1 : Builder
        // ===========================
        System.out.println(">>> Test Builder Pattern");
        Cours cours1 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr prof")
                .setSalle("D25")
                .setDate("2025-12-01")
                .setHeureDebut("08:00")
                .setEstOptionnel(false)
                .setNiveau("Licence 3")
                .setProjecteur(true)
                .build();

        System.out.println("Cours construit : " + cours1.getDescription() + "\n");

        // ===========================
        // Exercice 2 : Observer
        // ===========================
        System.out.println(">>> Test Observer Pattern");
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        Etudiant e1 = new Etudiant("ines");
        Etudiant e2 = new Etudiant("hiba");
        Responsable r1 = new Responsable("Dr mazari");

        gestionnaire.attach(e1);
        gestionnaire.attach(e2);
        gestionnaire.attach(r1);

        // Ajout d’un cours → notification automatique
        gestionnaire.ajouterCours(cours1);

        // Modification d’un cours → notification automatique
        gestionnaire.setChangement("Salle changée à B202");
        System.out.println();

        // ===========================
        // Exercice 3 : Decorator
        // ===========================
        System.out.println(">>> Test Decorator Pattern");
        ICours coursEnLigne = new CoursEnLigne(cours1);

        System.out.println("Description décorée : " + coursEnLigne.getDescription());
        System.out.println("Durée du cours : " + coursEnLigne.getDuree() + " heures");
        System.out.println("\n===== Fin des tests =====");
    }
}

