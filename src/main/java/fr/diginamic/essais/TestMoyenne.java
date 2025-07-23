package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

import java.util.Locale;
import java.util.Scanner;

public class TestMoyenne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.FRANCE);

        System.out.print("Combien de notes souhaitez-vous saisir ? ");
        int nombreNotes = scanner.nextInt();

        if (nombreNotes <= 0) {
            System.out.println("Le nombre de notes doit être supérieur à 0.");
            scanner.close();
            return;
        }

        CalculMoyenne moyenne = new CalculMoyenne();

        for (int i = 1; i < nombreNotes; i++) {
            System.out.print("Entrez la note n°" + (i) + " : ");
            double note = scanner.nextDouble();
            moyenne.ajouterNote(note);
            System.out.println(moyenne.getNotes());
        }

        double moyenneNote = moyenne.calcul();
        System.out.printf("La moyenne est : %.2f\n", moyenneNote);

        scanner.close();
    }
}
