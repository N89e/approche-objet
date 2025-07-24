package fr.diginamic.recensement.modele;

public class Departement {
    private String codeDepartement;
    private int populationTotale;

    public Departement(String codeDepartement, int populationTotale) {
        this.codeDepartement = codeDepartement;
        this.populationTotale = populationTotale;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    @Override
    public String toString() {
        return "Département " + codeDepartement + " - Population : " + populationTotale;
    }
}
