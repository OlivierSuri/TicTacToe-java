package tictactoe.model;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner sc;

    public InteractionUtilisateur() {
        sc = new Scanner(System.in);
    }


    // Méthode pour lire un entier avec validation
    public int getIntInput() {
        while (!sc.hasNextInt()) {
            sc.next(); // Vider le buffer
            System.out.println("Veuillez entrer un nombre valide :");
        }
        return sc.nextInt();
    }

    // Méthode pour lire un tableau de deux entiers (coordonnées)
    public int[] getCoordinatesInput() {
        int[] coordinates = new int[2];
        coordinates[0] = getIntInput(); // La vue affichera "Ligne :"
        coordinates[1] = getIntInput(); // La vue affichera "Colonne :"
        return coordinates;
    }
}
