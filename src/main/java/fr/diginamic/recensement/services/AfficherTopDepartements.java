package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Departement;
import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.services.MenuService;

import java.util.*;
import java.util.stream.Collectors;

public class AfficherTopDepartements extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<String, Departement> mapDep = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            String codeDep = ville.getCodeDepartement();
            int pop = ville.getPopulationTotale();

            if (mapDep.containsKey(codeDep)) {
                Departement d = mapDep.get(codeDep);
                int nvPop = d.getPopulationTotale() + pop;
                mapDep.put(codeDep, new Departement(codeDep, nvPop));
            } else {
                mapDep.put(codeDep, new Departement(codeDep, pop));
            }
        }

        List<Departement> topDeps = mapDep.values().stream()
                .sorted((d1, d2) -> Integer.compare(d2.getPopulationTotale(), d1.getPopulationTotale()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top 10 des départements les plus peuplés :");
        for (Departement d : topDeps) {
            System.out.println(d);
        }
    }
}
