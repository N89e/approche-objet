package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

import java.util.Scanner;

public class TestOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char ope;
        do {
            System.out.println("Choisir type d'opérations parmis : \n +, -, *, / ");
            ope = scan.next().charAt(0);
            if (ope != '+' && ope != '-' && ope != '*' && ope != '/') {
                System.out.println("Les opérateurs connus sont +, -, *, / ! \n");
            }

        } while (ope != '+' && ope != '-' && ope != '*' && ope != '/');

        System.out.println("Veuillez sélectionner un autre nombre :");
        int a = scan.nextInt();
        System.out.println("Veuillez sélectionner un nombre :");
        int b = scan.nextInt();
        Operations operations = new Operations();
        System.out.println("Voici le résultat de votre opérations : " + operations.calcul(a, b, ope));
    }
}
