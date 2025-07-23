package fr.diginamic.entites;

import fr.diginamic.chaines.ManipulationChaine;

import java.util.Arrays;

public class Salaire {
    public static void main(String[] args) {
        ManipulationChaine chaine = new ManipulationChaine();
        String[] table = chaine.getTable();
        if (table.length > 0) {
            System.out.println("nom : " + table[0]);
            System.out.println("prenom : " + table[1]);
            String salaireStr = table[2].trim().replace(" ", "");
            double salaire = Double.parseDouble(salaireStr);
            System.out.println("salaire : " + salaire);

            System.out.println("Type de table[2] : " +  table[2].getClass().getName());
            System.out.println("Type de salaire : " +  ((Object) salaire).getClass().getName());

        } else {
            System.out.println("Taleau vide");
        }
    }
}
