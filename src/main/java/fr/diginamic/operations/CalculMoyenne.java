package fr.diginamic.operations;

import java.util.ArrayList;

public class CalculMoyenne {
    private ArrayList<Double> notes = new ArrayList<>();

    public void ajouterNote(double a) {
        notes.add(a);
    }

    public ArrayList<Double> getNotes() {
        return notes;
    }

    public double calcul() {
        if (notes.isEmpty()) {
            return 0;
        }
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        return somme / notes.size();
    }
}
