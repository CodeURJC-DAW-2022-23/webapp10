package com.nutri.backend.model;

public class DietRefactor {
    private String [][] dietRefactorized;

    public DietRefactor() {
    }

    public String[][] getDietRefactorized() {
        return dietRefactorized;
    }

    public String[][] setDietRefactorized(Triplet [] week) {
        String [][] aux = new String[7][3];
        for (int i =0; i<7; i++){
            aux[i][0]= (String) week[i].Breakfast;
            aux[i][1]= (String) week[i].Lunch;
            aux[i][2]= (String) week[i].Dinner;
        }
        this.dietRefactorized = aux;
        return aux;
    }
}
