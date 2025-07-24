package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;

import java.util.Scanner;

public class Quitter extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Fin de l’application. Merci !");
        System.exit(0);
    }
}
