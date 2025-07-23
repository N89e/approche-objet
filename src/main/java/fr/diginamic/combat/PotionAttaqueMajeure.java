package fr.diginamic.combat;

public class PotionAttaqueMajeure extends Potion {

    private final int bonus = 5;

    /**
     * Potion qui donne +5 en attaque, valable pendant 2 combats
     */
    public PotionAttaqueMajeure() {
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public void utiliser(Personnage personnage) {
        personnage.appliquerPotionAttaque(this);
        System.out.println("Potion d'attaque majeure consommée : +5 force pour 2 combats.");
    }

    @Override
    public boolean estUtilisableEntreCombats() {
        return true;
    }

    @Override
    public String toString() {
        return "PotionAttaqueMajeure(+5 attaque, 2 combats)";
    }
}
