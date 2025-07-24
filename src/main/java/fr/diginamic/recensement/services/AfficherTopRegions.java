package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Region;
import fr.diginamic.recensement.modele.Ville;

import java.util.*;
import java.util.stream.Collectors;

public class AfficherTopRegions extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<Integer, Region> mapRegion = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            int codeRegion = ville.getCodeRegion();
            String nomRegion = ville.getNomRegion();
            int pop = ville.getPopulationTotale();

            if (mapRegion.containsKey(codeRegion)) {
                Region r = mapRegion.get(codeRegion);
                int nvPop = r.getPopulationTotale() + pop;
                mapRegion.put(codeRegion, new Region(codeRegion, nomRegion, nvPop));
            } else {
                mapRegion.put(codeRegion, new Region(codeRegion, nomRegion, pop));
            }
        }

        List<Region> topRegions = mapRegion.values().stream()
                .sorted((r1, r2) -> Integer.compare(r2.getPopulationTotale(), r1.getPopulationTotale()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top 10 des régions les plus peuplées :");
        for (Region r : topRegions) {
            System.out.println(r);
        }
    }
}
