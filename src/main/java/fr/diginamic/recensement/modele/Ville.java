package fr.diginamic.recensement.modele;

public class Ville {
    private int codeRegion;
    private String nomRegion;
    private String codeDepartement;
    private String codeCommune;
    private String nomCommune;
    private int populationTotale;

    public Ville(int codeRegion, String nomRegion, String codeDepartement, String codeCommune, String nomCommune, int populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.populationTotale = populationTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public int getPopulationTotale() {

        return populationTotale;
    }

    @Override
    public String toString() {
        return nomCommune + " (Code Dept: " + codeDepartement + ") - Population : " + populationTotale;
    }
}
