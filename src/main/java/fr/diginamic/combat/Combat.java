package fr.diginamic.combat;

import java.util.Random;

public class Combat {

    private Personnage personnage;
    private Creature creature;
    private Random random = new Random();

    public Combat(Personnage perso, Creature cree) {
        this.personnage = perso;
        this.creature = cree;
    }

    /**
     * Démarre le combat, renvoie true si victoire du personnage, false sinon.
     */
    public boolean demarrerCombat() {
        System.out.println("Début du combat...");
        int tour = 1;

        while (personnage.getPointsDeSante() > 0 && creature.getPointsDeSante() > 0) {

            System.out.printf("Tour %d :%n", tour);

            int attaquePerso = personnage.attaqueEffective() + random.nextInt(10) + 1; // force + 1..10
            int attaqueCreature = creature.getForce() + random.nextInt(10) + 1;

            System.out.printf("Attaque personnage: %d (force+bonus+1..10)%n", attaquePerso);
            System.out.printf("Attaque créature : %d (force+1..10)%n", attaqueCreature);

            if (attaquePerso > attaqueCreature) {
                // personnage gagne le tour
                int degats = attaquePerso - attaqueCreature;
                creature.appliquerDegats(degats);
                System.out.printf("Le personnage inflige %d points de dégâts à la créature.%n", degats);
            } else if (attaqueCreature > attaquePerso) {
                int degats = attaqueCreature - attaquePerso;
                personnage.appliquerDegats(degats);
                System.out.printf("La créature inflige %d points de dégâts au personnage.%n", degats);
            } else {
                System.out.println("Égalité aucune perte de points de santé ce tour.");
            }

            System.out.printf("Points de santé personnage: %d%n", personnage.getPointsDeSante());
            System.out.printf("Points de santé créature: %d%n", creature.getPointsDeSante());

            tour++;
        }

        if (personnage.getPointsDeSante() <= 0) {
            System.out.println("Le personnage est mort au combat.");
            return false;
        } else {
            System.out.println("La créature est vaincue !");
            return true;
        }
    }
}
