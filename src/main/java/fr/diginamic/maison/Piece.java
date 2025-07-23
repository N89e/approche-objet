package fr.diginamic.maison;

public abstract class Piece {
    private final double superficie;
    private final int nbEtage;

    public Piece(double superficie, int nbEtage) {
        if (superficie < 0) {
            System.out.println("La supperficie doit être suppérieur à 0 !");
        }
        if (nbEtage < 0) {
            System.out.println("L'étage doit être suppérieur à 0 !");
        }
        this.superficie = superficie;
        this.nbEtage = nbEtage;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getNbEtage() {
        return nbEtage;
    }
}

