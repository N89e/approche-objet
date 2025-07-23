package fr.diginamic.entites;

public class Theatre {
    private final String name;
    private final int capacityMax;
    private int allClients;
    private int recette;

    public Theatre(String name, int capacityMax, int allClients, int recette) {
        this.name = name;
        this.capacityMax = capacityMax;
        this.allClients = allClients;
        this.recette = recette;
    }

    public int inscrire(int nbClients, double prixParPlace) {
        if (this.allClients + nbClients <= this.capacityMax){
            this.allClients += nbClients;
            this.recette += (int) (nbClients * prixParPlace);
            return this.allClients;
        } else {
            throw new IllegalStateException("Capacité max atteinte, inscription refusée");
        }
    }

    public int getRecette() {
        return recette;
    }

    public String getName() {
        return name;
    }

    public int getAllClients() {
        return allClients;
    }
}
