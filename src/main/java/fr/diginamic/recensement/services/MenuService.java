package fr.diginamic.recensement.services;

import fr.diginamic.recensement.modele.Recensement;

import java.util.Scanner;

public abstract class MenuService {
    public abstract void traiter(Recensement recensement, Scanner scanner);
}
