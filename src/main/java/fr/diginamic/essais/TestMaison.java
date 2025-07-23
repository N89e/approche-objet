package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    public static void main(String[] args) {
        Maison maison = new Maison();

        maison.ajoutPiece(new Chambre(12.5, 1));
        maison.ajoutPiece(new Chambre(12.5, 0));
        maison.ajoutPiece(new Salon(25.2, 0));
        maison.ajoutPiece(new Cuisine(15.0, 0));
        maison.ajoutPiece(new SalleDeBain(8.0, 1));
        maison.ajoutPiece(new WC(2.0, 0));

        // Test null
        maison.ajoutPiece(null);

        System.out.println("Superficie totale : " + maison.getSuperficieTotal());
        System.out.println("Superficie étage 0 : " + maison.getSuperficieParEtage(0));
        System.out.println("Superficie des chambres : " + maison.getSuperficieParType("Chambre"));
        System.out.println("Nombre de chambres : " + maison.getNombreParType("Chambre"));

        // Ajout d'une pièce invalide
        try {
            maison.ajoutPiece(new Cuisine(-5, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de l'ajout : " + e.getMessage());
        }

        // getSuperficieParEtage avec étage négatif
        try {
            maison.getSuperficieParEtage(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur méthode getSuperficieParEtage : " + e.getMessage());
        }
    }
}
