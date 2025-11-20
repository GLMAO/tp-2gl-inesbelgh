package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>(); // <-- liste des observers

    // Méthodes pour gérer les observateurs
    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        notifyObservers("Nouveau cours : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
         notifyObservers("Cours modifié : " + message);
    }

   // public void setChangement(String string) {
        // supprime Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'setChangement'");
   // }
}