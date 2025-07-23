package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {
    public static void main(String[] args) {
        int capacite = 100;
        Theatre tivoli = new Theatre("Tivoli", capacite, 0, 0);

        for (int i = 1; i <= capacite; i++) {
            try {
                tivoli.inscrire(1, 30);
                System.out.println("Client n°" + i + " inscrit.");
                System.out.println("nom : " + tivoli.getName());
                System.out.println("Recette : " + tivoli.getRecette());
                System.out.println("Total clients inscrits : " + tivoli.getAllClients());
                System.out.println("------------------------------");
            } catch (IllegalStateException e) {
                System.out.println("Impossible d'inscrire le client n°" + i + ": " + e.getMessage());
                break;
            }
        }
    }
}
