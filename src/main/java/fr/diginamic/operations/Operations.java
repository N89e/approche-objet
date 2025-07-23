package fr.diginamic.operations;

public class Operations {
    public Double calcul(double a, double b, char ope) {
        switch (ope) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/':
                if (a == 0 || b == 0) {
                    System.out.println("Impossible de déviser par 0 !");
                }
                    return a/b;
            default:
                System.out.println("Les opérateurs connus sont +, -, *, / ! ");
        }
        return null;
    }
}
