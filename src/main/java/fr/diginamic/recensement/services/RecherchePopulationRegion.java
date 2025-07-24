package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.CalculUtils;
import fr.diginamic.recensement.utils.InputUtils;

import java.util.*;

public class RecherchePopulationRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        // Afficher la liste des régions présentes
        List<Ville> villes = recensement.getVilles();
        Set<String> regionSet = new HashSet<>();

        for (Ville ville : villes) {
            String nomReg = ville.getNomRegion();
            if (nomReg != null && !nomReg.isEmpty()) {
                regionSet.add(nomReg.trim());
            }
        }

        List<String> liste = new ArrayList<>(regionSet);
        Collections.sort(liste);

        System.out.println("Liste des départements présents :");
        for (String dep : liste) {
            System.out.println(dep);
        }
        System.out.print("Entrez le nom de la région recherchée : ");

        String typeMode = "Region";
        String name = InputUtils.lireCodeDepartement(typeMode, scanner, liste);

        // Calcul de la population totale pour ce département
        int populationTotale = CalculUtils.calculPopulation(name, villes);

        if (populationTotale > 0) {
            System.out.println("Population totale du département " + name + " : " + populationTotale);
        } else {
            System.out.println("Département trouvé mais population = 0");
        }
    }
}
