package fr.diginamic.chaines;

import java.util.Locale;

public class ManipulationChaine {
    String chaine = "Durand;Marcel;2 523.5";
    char premierCaractere = chaine.charAt(0);
    int longueurChaine = chaine.length();
    char c = 'D';
    int indexCaractere = chaine.indexOf(c);
    int start = chaine.indexOf(c);
    int end =  chaine.indexOf('d');
    String portionText = chaine.substring(start, end);
    String majusculeName = chaine.toUpperCase(Locale.of(portionText));
    String minisculeName = chaine.toLowerCase(Locale.of(portionText));
    String[] table = chaine.split(";");

    public char getPremierCaractere() {
        return premierCaractere;
    }

    public String[] getTable() {
        return table;
    }
}

