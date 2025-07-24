package fr.diginamic.recensement.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Recensement {

    private List<Ville> villes;

    public Recensement(String cheminFichierCsv) {
        villes = new ArrayList<>();
        chargerFichier(cheminFichierCsv);
    }

    private void chargerFichier(String cheminFichierCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichierCsv))) {
            String ligne;
            br.readLine(); // saut de la ligne header
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");

                if (parts.length == 10) {
                    int codeRegion = Integer.parseInt(parts[0].trim());
                    String nomRegion = parts[1].trim().toUpperCase();
                    String codeDepartement = parts[2].trim();
                    String codeCommune = parts[5].trim();
                    String nomCommune = parts[6].trim().toUpperCase();
                    String popStr = parts[9].replace(" ", "").trim();
                    int populationTotale = 0;
                    try {
                        populationTotale = Integer.parseInt(popStr);
                    } catch (NumberFormatException e) {
                        System.err.println("Population invalide pour la ligne : " + ligne);
                    }
                    Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
                    villes.add(ville);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ville> getVilles() {
        return villes;
    }

}
