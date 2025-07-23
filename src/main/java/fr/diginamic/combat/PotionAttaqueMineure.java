package fr.diginamic.combat;

public class PotionAttaqueMineure extends Potion {

    private final int bonus = 3;

    /**
     * Potion qui donne +3 en attaque, valable uniquement pendant le prochain combat
     */
    public PotionAttaqueMineure() {
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public void utiliser(Personnage personnage) {
        personnage.appliquerPotionAttaque(this);
        System.out.println("Potion d'attaque mineure consommée : +3 force pour le prochain combat.");
    }

    @Override
    public boolean estUtilisableEntreCombats() {
        return true;
    }

    @Override
    public String toString() {
        return "PotionAttaqueMineure(+3 attaque, 1 combat)";
    }
}
