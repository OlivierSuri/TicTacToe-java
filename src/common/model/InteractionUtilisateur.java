package common.model;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner sc;

    public InteractionUtilisateur() {
        sc = new Scanner(System.in);
    }

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

    public int getP4Input(){
        int col = getIntInput();
        return col;
    }

    public int[] getMoveInput(int nb){
        int row, col;
        col = getIntInput();
        if(nb==2){
            row = getIntInput();
            return new int[]{row, col};
        }
        return new int[]{col};
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
