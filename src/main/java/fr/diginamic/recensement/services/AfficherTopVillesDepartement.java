package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AfficherTopVillesDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Entrez le code du département : ");
        String codeDep = scanner.nextLine().trim();

        List<Ville> villesDep = recensement.getVilles().stream()
                .filter(v -> v.getCodeDepartement().equalsIgnoreCase(codeDep))
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        if (villesDep.isEmpty()) {
            System.out.println("Aucune ville trouvée pour ce département.");
        } else {
            System.out.println("Top 10 des villes les plus peuplées du département " + codeDep + " :");
            villesDep.forEach(System.out::println);
        }
    }
}
