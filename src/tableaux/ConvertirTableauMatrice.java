package tableaux;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ConvertirTableauMatrice {


    private static int[][] demanderTableau2D() {

        Random random = new Random();
        int nombreAleatoire;

        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez le nombre de lignes dans votre tableau ===>  ");
        int nbLignes = clavier.nextInt();
        System.out.print("Entrez le nombre de colonnes dans votre tableau ===>  ");
        int nbColonnes = clavier.nextInt();

        int[][] tableau = new int[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                nombreAleatoire = random.nextInt(11);
                tableau[i][j] = nombreAleatoire;
            }
        }

        return tableau;
    }




    public static void lancer() {

        // Demander à l'utilisateur un tableau 2D
        int[][] tableau = demanderTableau2D();

        // Affichage du tableau en matrice
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }


    }

}
