package com.polytech.tp;

public class CoursEnLigne extends CoursDecorator {
    CoursEnLigne(ICours cours) {
        //TODO: Implémenter le reste ...
        super(cours);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        
        return coursDecorated.getDescription() + " (en ligne)";
    }

    @Override
    public double getDuree() {
        // TODO Auto-generated method stub
        
        return coursDecorated.getDuree() + 0.5;
    };
}
