package fr.diginamic.combat;

public abstract class Creature {

    protected String nom;
    protected int force;
    protected int pointsDeSante;

    // Nombre de points score gagnés si victoire contre cette créature
    protected int pointsScore;

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeSante() {
        return pointsDeSante;
    }

    public void appliquerDegats(int degats) {
        pointsDeSante -= degats;
    }

    public int getPointsScore() {
        return pointsScore;
    }

    @Override
    public String toString() {
        return String.format("%s [force=%d, pointsDeSante=%d]", nom, force, pointsDeSante);
    }
}
