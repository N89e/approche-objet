package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.CalculUtils;
import fr.diginamic.recensement.utils.InputUtils;

import java.util.*;

public class RecherchePopulationDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        // Afficher la liste des départements présents
        List<Ville> villes = recensement.getVilles();
        Set<String> departementsSet = new HashSet<>();

        for (Ville ville : villes) {
            String codeDep = ville.getCodeDepartement();
            if (codeDep != null && !codeDep.isEmpty()) {
                departementsSet.add(codeDep.trim());
            }
        }

        List<String> liste = new ArrayList<>(departementsSet);
        Collections.sort(liste);

        System.out.println("Liste des départements présents :");
        for (String dep : liste) {
            System.out.println(dep);
        }

        // Appel vers la méthode pour vérifier la conformiter des éléments
        String typeMode = "Depart";
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
