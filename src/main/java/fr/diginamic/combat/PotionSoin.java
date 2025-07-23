package fr.diginamic.combat;

public class PotionSoin extends Potion {

    private int soin;

    public PotionSoin(int points) {
        this.soin = points;
    }

    public int getSoin() {
        return soin;
    }

    @Override
    public void utiliser(Personnage personnage) {
        int avant = personnage.getPointsDeSante();

        personnage.appliquerDegats(-soin);
        System.out.printf("Potion de soin consommée, +%d pts santé.%n", soin);
        System.out.printf("Points de santé : %d => %d%n", avant, personnage.getPointsDeSante());
    }

    @Override
    public boolean estUtilisableEntreCombats() {
        return true;
    }

    @Override
    public String toString() {
        return "PotionSoin(+" + soin + " pts santé)";
    }
}
