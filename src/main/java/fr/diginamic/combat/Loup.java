package fr.diginamic.combat;

import java.util.Random;

public class Loup extends Creature {

    private static Random random = new Random();

    public Loup() {
        this.nom = "Loup";
        this.force = 3 + random.nextInt(6); // 3 à 8
        this.pointsDeSante = 5 + random.nextInt(6); // 5 à 10
        this.pointsScore = 1;
    }
}
