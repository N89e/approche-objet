package fr.diginamic.combat;

/* REGLE POUR LE PERSONNAGE :
* lorsqu’on choisit cette option, un personnage va être créé avec 3 attributs :
▪ force (entre 12 et 18) tirée aléatoirement
▪ points de santé (entre 20 et 50) tirés aléatoirement
▪ score (à 0)
o Le personnage débute avec un inventaire de 3 potions : une potion de soin, une potion d’attaque mineure et une potion de robustesse. Les potions ne peuvent être consommées qu’entre 2 combats.
▪ Potion de soin (+5 à 10 points de santé).
▪ Potion d’attaque mineure (+3 points en attaque) valable uniquement pendant la durée du prochain combat
▪ Potion d’attaque majeure (+5 points en attaque) valable pendant 2 combats
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personnage {
    private Random random = new Random();

    private String nom;
    private int force;
    private int pointsDeSante;
    private int score;
    private List<Potion> inventairePotions;

    // durée 1 combat
    private int bonusAttaqueProchainCombat;
    // durée 2 combats
    private int bonusAttaqueDeuxCombatsRestants;


    public Personnage(String nom) {
        //Caractéristiques des personnages
        this.nom = nom;
        this.force = 12 + random.nextInt(7);
        this.pointsDeSante = 20 + random.nextInt(31);
        this.score = 0;
        this.inventairePotions = new ArrayList<>();

        // Potions initiales (soin, attaque mineure, attaque majeure)
        inventairePotions.add(new PotionSoin(random.nextInt(6) + 5));
        inventairePotions.add(new PotionAttaqueMineure());
        inventairePotions.add(new PotionAttaqueMajeure());
    }

    public int getPointsDeSante() {
        return pointsDeSante;
    }

    public void appliquerDegats(int degats) {
        pointsDeSante -= degats;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void ajouterScore(int pts) {
        score += pts;
    }

    public List<Potion> getInventairePotions() {
        return inventairePotions;
    }

    public void ajouterPotion(Potion p) {
        inventairePotions.add(p);
    }

    /**
     * Calcule attaque effective lors d'un combat, prend en compte bonus potions.
     * Ajouter bonus attaque majeures et mineures valides.
     * @return force totale + bonus
     */
    public int attaqueEffective() {
        int bonus = bonusAttaqueProchainCombat + bonusAttaqueDeuxCombatsRestants;
        return force + bonus;
    }

    /**
     * Appliquer potion d'attaque active.
     * Certaines potions sont valides uniquement pendant le prochain combat, d'autres 2 combats.
     */
    public void appliquerPotionAttaque(PotionAttaqueMineure potion) {
        bonusAttaqueProchainCombat += potion.getBonus();
    }

    public void appliquerPotionAttaque(PotionAttaqueMajeure potion) {
        bonusAttaqueDeuxCombatsRestants += potion.getBonus();
    }

    /**
     * Diminuer la durée des potions d'attaque valides pour 2 combats.
     * Une fois utilisé, on enlève le bonus majeur.
     * Il est appelé après chaque combat remporté.
     */
    public void decrementerDureePotionsAttaque() {
        // Le bonus du potion mineure est pour un combat, on réinitialise à 0 à chaque fin combat gagné
        bonusAttaqueProchainCombat = 0;

        // La potion majeur dure 2 combats, on enlève un combat restant
        if (bonusAttaqueDeuxCombatsRestants > 0) {
            bonusAttaqueDeuxCombatsRestants -= 5;
            if (bonusAttaqueDeuxCombatsRestants < 0) bonusAttaqueDeuxCombatsRestants = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder inv = new StringBuilder();
        for (Potion p : inventairePotions) {
            inv.append(p.toString()).append(", ");
        }
        if (inv.length() > 2) inv.setLength(inv.length() - 2);

        return String.format("Personnage [force=%d, pointsDeSante=%d, score=%d, potions=[%s]]",
                force, pointsDeSante, score, inv.toString());
    }


}
