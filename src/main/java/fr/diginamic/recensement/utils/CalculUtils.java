package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.modele.Ville;

import java.util.List;

public class CalculUtils {

    public static int calculPopulation(String name, List<Ville> villes) {
        int populationTotale = 0;
        for (Ville ville : villes) {
            if (ville.getCodeDepartement().equalsIgnoreCase(name) || ville.getNomRegion().equalsIgnoreCase(name)) {
                populationTotale += ville.getPopulationTotale();
            }
        }
        return populationTotale;
    }
}
