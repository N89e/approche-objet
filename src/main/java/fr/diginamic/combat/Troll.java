package fr.diginamic.combat;

import java.util.Random;

public class Troll extends Creature {

    private static Random random = new Random();

    public Troll() {
        this.nom = "Troll";
        this.force = 10 + random.nextInt(6); // 10 à 15
        this.pointsDeSante = 20 + random.nextInt(11); // 20 à 30
        this.pointsScore = 5;
    }
}
