package fr.diginamic.maison;

import java.util.ArrayList;
import java.util.List;

public class Maison {
    private List<Piece> pieces;

    public Maison() {
        pieces = new ArrayList<>();
    }

    public void ajoutPiece(Piece piece) {
        if (piece == null) {
            System.out.println("Impossible d'ajouter une pièce null.");
            return;
        }
        pieces.add(piece);
    }

    public double getSuperficieTotal() {
        int total = 0;
        for (Piece p : pieces) {
            total += p.getSuperficie();
        }
        return total;
    }

    public double getSuperficieParEtage(int etage) {
        if (etage < 0){
            throw new IllegalArgumentException("L'étage ne peut pas être négatif");
        }
        double total = 0;
        for (Piece p : pieces) {
            if (p.getNbEtage() == etage) {
                total += p.getSuperficie();
            }
        }
        return total;
    }

    // Plus difficile : l’écriture des 2 méthodes suivantes demande un peu de réflexion
    public double getSuperficieParType(String typeNom) {
        double total = 0;
        for (Piece p : pieces) {
            // récupérer le nom simple de la classe (par ex. "Chambre")
            String nomClasse = p.getClass().getSimpleName();
            if (nomClasse.equalsIgnoreCase(String.valueOf(typeNom))) {
                total += p.getSuperficie();
            }
        }
        return total;
    }

    public int getNombreParType(String typeNom) {
        int compteur = 0;
        for (Piece p : pieces) {
            String nomClasse = p.getClass().getSimpleName();
            if (nomClasse.equalsIgnoreCase(String.valueOf(typeNom))) {
                compteur++;
            }
        }
        return compteur;
    }

}
