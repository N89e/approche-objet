package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AfficherTopVillesFrance extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Ville> topVilles = recensement.getVilles().stream()
                .sorted(Comparator.comparingInt(Ville::getPopulationTotale).reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top 10 des villes les plus peuplées de France :");
        topVilles.forEach(System.out::println);
    }
}
