package view;

import java.util.Scanner;

public class Interaction {
    private Scanner sc;

    public Interaction() {
        sc = new Scanner(System.in);
    }

    public int getMenuApp(){
        int MenuAppChoice;
        do {
            MenuAppChoice = getIntInput();
            if (MenuAppChoice < 1 || MenuAppChoice > 3) {
                System.out.println("Veuillez entrer un chiffre valide (1, 2 ou 3) :");
            }
        } while (MenuAppChoice < 1 || MenuAppChoice > 3);
        return MenuAppChoice;
    }

    // Méthode pour lire un entier avec validation
    public int getIntInput() {
        while (!sc.hasNextInt()) {
            sc.next(); // Vider le buffer
            System.out.println("Veuillez entrer un nombre valide :");
        }
        return sc.nextInt();
    }
}
