package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AfficherTopVillesRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Entrez le nom de la région : ");
        String nomRegion = scanner.nextLine().trim();

        List<Ville> villesRegion = recensement.getVilles().stream()
                .filter(v -> v.getNomRegion().equalsIgnoreCase(nomRegion))
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        if (villesRegion.isEmpty()) {
            System.out.println("Aucune ville trouvée pour cette région.");
        } else {
            System.out.println("Top 10 des villes les plus peuplées de la région " + nomRegion + " :");
            villesRegion.forEach(System.out::println);
        }
    }
}
