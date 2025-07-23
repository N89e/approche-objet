package fr.diginamic.combat;

import java.util.Random;

public class Gobelin extends Creature {

    private static Random random = new Random();

    public Gobelin() {
        this.nom = "Gobelin";
        this.force = 5 + random.nextInt(6); // 5 à 10
        this.pointsDeSante = 10 + random.nextInt(6); // 10 à 15
        this.pointsScore = 2;
    }
}
