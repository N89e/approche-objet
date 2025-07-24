package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.List;
import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Entrez le nom de la ville recherchée : ");
        String nomVille = scanner.nextLine().trim();

        List<Ville> villes = recensement.getVilles();

        for (Ville ville : villes) {
            if (ville.getNomCommune().equalsIgnoreCase(nomVille)) {
                System.out.println("Population de " + ville.getNomCommune() + " : " + ville.getPopulationTotale());
                return;
            }
        }

        System.out.println("Aucune ville trouvée avec ce nom : " + nomVille);
    }
}
