package fr.diginamic.recensement.modele;

public class Region {
    private int codeRegion;
    private String nomRegion;
    private int populationTotale;

    public Region(int codeRegion, String nomRegion, int populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.populationTotale = populationTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    @Override
    public String toString() {
        return nomRegion + " (Code Région: " + codeRegion + ") - Population : " + populationTotale;
    }
}
