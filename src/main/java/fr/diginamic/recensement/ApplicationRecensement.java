package fr.diginamic.recensement;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.services.*;

import java.nio.file.Paths;
import java.util.Scanner;

public class ApplicationRecensement {

    public static void main(String[] args) {


        String cheminFichier = String.valueOf(Paths.get("C:", "Users", "nunod", "IdeaProjects", "approche-objet", "src", "main", "java", "fr", "diginamic", "recensement", "recensement.csv"));

        System.out.println("Chargement des données...");
        Recensement recensement = new Recensement(cheminFichier);
        System.out.println("Données chargées !");

        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            afficherMenu();
            System.out.print("Votre choix : ");
            String saisie = scanner.nextLine();
            int choix = -1;
            try {
                choix = Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : veuillez entrer un nombre valide.");
                continue;
            }

            MenuService service;
            switch (choix) {
                case 1:
                    service = new RecherchePopulationVille();
                    service.traiter(recensement, scanner);
                    break;
                case 2:
                    service = new RecherchePopulationDepartement();
                    service.traiter(recensement, scanner);
                    break;
                case 3:
                    service = new RecherchePopulationRegion();
                    service.traiter(recensement, scanner);
                    break;
                case 4:
                    service = new AfficherTopRegions();
                    service.traiter(recensement, scanner);
                    break;
                case 5:
                    service = new AfficherTopDepartements();
                    service.traiter(recensement, scanner);
                    break;
                case 6:
                    service = new AfficherTopVillesDepartement();
                    service.traiter(recensement, scanner);
                    break;
                case 7:
                    service = new AfficherTopVillesRegion();
                    service.traiter(recensement, scanner);
                    break;
                case 8:
                    service = new AfficherTopVillesFrance();
                    service.traiter(recensement, scanner);
                    break;
                case 9:
                    System.out.println("Sortie de l'application.");
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Population d’une ville donnée");
        System.out.println("2. Population d’un numéro de département donné");
        System.out.println("3. Population d’un nom région donnée");
        System.out.println("4. Afficher les 10 régions les plus peuplées");
        System.out.println("5. Afficher les 10 départements les plus peuplés");
        System.out.println("6. Afficher les 10 villes les plus peuplées d’un département");
        System.out.println("7. Afficher les 10 villes les plus peuplées d’une région");
        System.out.println("8. Afficher les 10 villes les plus peuplées de France");
        System.out.println("9. Sortir");
    }
}
