package fr.diginamic.combat;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int PROBA_RECOMPENSE = 50; // 50% de chance

    private Personnage personnage;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void lancer() {
        int choix = -1;
        System.out.println("Bienvenue dans le jeu de combat !");
        while (choix != 6) {
            afficherMenu();
            choix = demanderChoix();

            switch (choix) {
                case 1:
                    creerPersonnage();
                    break;
                case 2:
                    combattreCreature();
                    break;
                case 3:
                    prendrePotion();
                    break;
                case 4:
                    afficherScore();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    choix = 6; // Sortir
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private void afficherMenu() {
        System.out.println("\nMenu :");
        System.out.println("1. Créer le personnage");
        System.out.println("2. Combattre une créature");
        System.out.println("3. Prendre une potion");
        System.out.println("4. Afficher score");
        System.out.println("5. Sortir");
        System.out.print("Votre choix : ");
    }

    private int demanderChoix() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private void creerPersonnage() {
        personnage = new Personnage();
        System.out.println("Personnage créé !");
        System.out.println(personnage);
    }

    private void combattreCreature() {
        if (personnage == null) {
            System.out.println("Veuillez créer un personnage avant de combattre.");
            return;
        }
        if (personnage.getPointsDeSante() <= 0) {
            System.out.printf("Votre personnage est décédé. Il a obtenu le score de %d points. Veuillez créer un nouveau personnage.%n",
                    personnage.getScore());
            personnage = null;
            return;
        }

        Creature creature = choisirCreatureAleatoire();
        System.out.println("Vous rencontrez une créature : " + creature);

        Combat combat = new Combat(personnage, creature);
        boolean victoire = combat.demarrerCombat();

        if (victoire) {
            int ptsScore = creature.getPointsScore();
            personnage.ajouterScore(ptsScore);
            System.out.printf("Vous avez vaincu la créature ! Votre score augmente de %d points, total = %d.%n",
                    ptsScore, personnage.getScore());

            // Diminuer durée des potions d'attaqueActives
            personnage.decrementerDureePotionsAttaque();

            // Tentative de récompense
            if (random.nextInt(100) < PROBA_RECOMPENSE) {
                distribuerRecompenseAleatoire();
            }
        } else {
            System.out.println("Votre personnage est décédé. Fin de la partie.");
            System.out.printf("Score final : %d%n", personnage.getScore());
            personnage = null;
        }
    }

    private Creature choisirCreatureAleatoire() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: return new Loup();
            case 1: return new Gobelin();
            case 2:
            default: return new Troll();
        }
    }

    private void distribuerRecompenseAleatoire() {
        int type = random.nextInt(4);
        switch(type) {
            case 0: // Potion de soin
                PotionSoin soin = new PotionSoin(random.nextInt(6) + 5); // 5 à 10 pts soin
                personnage.ajouterPotion(soin);
                System.out.println("Récompense : Vous avez reçu une potion de soin !");
                break;
            case 1: // Potion attaque mineure
                PotionAttaqueMineure mineure = new PotionAttaqueMineure();
                personnage.ajouterPotion(mineure);
                System.out.println("Récompense : Vous avez reçu une potion d'attaque mineure !");
                break;
            case 2: // Potion attaque majeure
                PotionAttaqueMajeure majeure = new PotionAttaqueMajeure();
                personnage.ajouterPotion(majeure);
                System.out.println("Récompense : Vous avez reçu une potion d'attaque majeure !");
                break;
            case 3: // +5 au score directement
                personnage.ajouterScore(5);
                System.out.println("Récompense : Votre score augmente de 5 points !");
                break;
        }
    }

    private void prendrePotion() {
        if (personnage == null) {
            System.out.println("Veuillez créer un personnage d'abord.");
            return;
        }
        if (personnage.getPointsDeSante() <= 0) {
            System.out.println("Le personnage est décédé. Créez un nouveau personnage.");
            return;
        }

        if (personnage.getInventairePotions().isEmpty()) {
            System.out.println("Vous ne possédez aucune potion.");
            return;
        }

        System.out.println("Potions disponibles :");
        for (int i = 0; i < personnage.getInventairePotions().size(); i++) {
            System.out.printf("%d. %s%n", i + 1, personnage.getInventairePotions().get(i));
        }

        System.out.print("Choisissez une potion à consommer (numéro) : ");
        int choixPotion = demanderChoix();
        if (choixPotion < 1 || choixPotion > personnage.getInventairePotions().size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Potion potion = personnage.getInventairePotions().get(choixPotion - 1);
        if (potion.estUtilisableEntreCombats()) {
            potion.utiliser(personnage);
            personnage.getInventairePotions().remove(potion);
            System.out.println("Potion consommée avec succès.");
            System.out.println(personnage);
        } else {
            System.out.println("Cette potion ne peut être consommée qu'entre 2 combats. Attendez la fin de vos combats.");
        }
    }

    private void afficherScore() {
        if (personnage == null) {
            System.out.println("Aucun personnage créé.");
        } else {
            System.out.printf("Score actuel : %d%n", personnage.getScore());
        }
    }
}
