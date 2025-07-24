package fr.diginamic.recensement.utils;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputUtils {

/**
 * Lit et valide la saisie d'un code département
 * @param scanner Scanner pour lire l'entrée utilisateur
 * @param liste Liste des départements valides
 * @return Code département validé
 */
public static String lireCodeDepartement(String typeMode, Scanner scanner, List<String> liste) {

    String name;
    boolean codeValide = false;

    do {
        System.out.print("Entrez le " + (typeMode.equalsIgnoreCase("Depart") ? "code du département" : "nom de la région") + " recherché : ");
        name = scanner.nextLine().trim();

        try {
            if ("Depart".equalsIgnoreCase(typeMode)) {
                int codeNum = Integer.parseInt(name);
                if (codeNum < 10 && !name.startsWith("0")) {
                    System.out.println("Le code département est inférieur à 10, merci de le saisir sous la forme 0" + codeNum);
                    continue;
                }
            }
            if ("Region".equalsIgnoreCase(typeMode)) {
                // Vérifier si le nom de la région est dans la liste au **début** de la boucle
                if (liste != null && !liste.isEmpty() && !liste.contains(name)) {
                    System.out.println("Le nom de la région '" + name.toUpperCase(Locale.FRENCH) + "' n'est pas connu de la liste. Veuillez choisir un nom de la liste.");
                    continue;
                }
            }
        } catch (NumberFormatException e) {
            // tolérer les codes département alphanumériques (ex: 2A)
        }

        // Vérifie que la valeur saisie en fait partie de la liste (pour les départements)
        if ("Depart".equalsIgnoreCase(typeMode)) {
            if (liste != null && !liste.isEmpty() && !liste.contains(name)) {
                System.out.println("Valeur non trouvée dans la liste. Veuillez saisir un code correct.");
                continue;
            }
        }

        codeValide = true;
    } while (!codeValide);

    return name;
}

}
