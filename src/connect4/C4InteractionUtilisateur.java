package connect4;

import java.util.Scanner;

public class C4InteractionUtilisateur {


    private final Scanner sc = new Scanner(System.in);

    //Choix de type de partie (pvp/pve)
    public int menuGameTypeChoice() {

        int gameTypeChoice;


        do {
            gameTypeChoice = getIntInput();
            if (gameTypeChoice < 1 || gameTypeChoice > 3) {
                System.out.println("Veuillez entrer un chiffre valide (1, 2 ou 3) :");
            }
        } while (gameTypeChoice < 1 || gameTypeChoice > 3);
        return gameTypeChoice;
    }

    public int getColumnInput(int cols) {
        int col;
        do {
            System.out.print("Choisissez une colonne (0 à " + (cols - 1) + ") : ");
            while (!sc.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre valide : ");
                sc.next();
            }
            col = sc.nextInt();
        } while (col < 0 || col >= cols);
        return col;
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
