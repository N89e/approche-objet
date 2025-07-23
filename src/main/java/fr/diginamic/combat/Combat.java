package fr.diginamic.combat;

/*
* Le choix de cette option va permettre au personnage d’engager un combat.
▪ Ce combat n’est possible que si votre personnage a un nombre de points de santé > 0, sinon un message est affiché : « Votre personnage est décédé. Il a obtenu le score de X points. Veuillez créer un nouveau personnage ».
o lorsqu’on choisit cette option, le personnage doit combattre une créature du bestiaire suivant (à compléter selon vos préférences):
▪ Un loup : force (entre 3 et 8) et points de santé (entre 5 et 10)
▪ Un gobelin : force (entre 5 et 10) et points de santé (entre 10 et 15)
▪ Un troll : force (entre 10 et 15) et points de santé (entre 20 et 30).
o Le combat commence par l’affichage de la créature rencontrée
o Le combat est constitué de tours :
▪ A chaque tour, on calcule l’attaque des 2 protagonistes. l’attaque est calculée de la manière suivante : force + nombre aléatoire entre 1 et 10.
▪ Celui dont l’attaque est la plus forte remporte le tour
▪ Celui qui remporte le tour inflige une quantité de dégâts égale à la différence entre les 2 valeurs d’attaque calculées précédemment.
▪ Cette quantité de dégâts se soustrait au nombre de points de santé de celui qui a perdu le tour.
▪ Si le nombre de points de santé de votre personnage est nul ou négatif le combat est terminé, la partie est finie et le score du personnage est affiché.
▪ Si votre personnage gagne le combat, son score augmente de : 1 si c’est un loup, 2 si c’est un gobelin et 5 si c’est un troll. Un message affiche alors l’issue du combat avec le nouveau score.
o Vous pouvez engager un nouveau combat tant que votre personnage est encore en vie. L’objectif du jeu étant d’atteindre le plus haut score.
o A la fin d’un combat gagné vous avez 50% de chance (paramètre réglable pour la difficulté) de récupérer une récompense :
▪ Potion de soin (+5 à 10 points de santé).
▪ Potion d’attaque mineure (+3 points en attaque) valable uniquement pendant la durée du prochain combat
▪ Potion d’attaque majeure (+5 points en attaque) valable pendant 2 combats
▪ Ou score+5
* */

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

            int attaquePerso = personnage.attaqueEffective() + random.nextInt(10) + 1;
            int attaqueCreature = creature.getForce() + random.nextInt(10) + 1;

            System.out.printf("Attaque personnage " + personnage.getNom() + " :  %d %n", attaquePerso);
            System.out.printf("Attaque créature " + creature.getNom() + " : %d %n", attaqueCreature);

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
