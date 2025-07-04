package tableaux;

import java.util.Random;

public class TranspositionTableau {

    private static int[][] demanderTableau2D() {

        // Créer un tableau 2D (taille aléatoire)
        Random random = new Random();
        int borne1 = random.nextInt(8);
        int borne2 = random.nextInt(4);
        int[][] tableau = new int[borne1 + 2][borne2 + 2];

        // Remplir le tableau de valeurs aléatoires
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = random.nextInt(21);
            }
        }

        // Affichage du tableau en matrice
        System.out.println("Tableau de départ :");
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j] + "  ");
            }
            System.out.println();
        }

        // Retourner le tableau 2D aléatoire
        return tableau;
    }

    private static int[][] transposerTableau2D(int[][] tableau) {

        // Créer un tableau de même taille que le tableau reçu en paramètre
        int[][] tableauTranspose = new int[tableau[0].length][tableau.length];
        int taille1 = tableau.length;
        int taille2 = tableau[0].length;

        // Dans la boucle, on prend chaque élément de départ (exemple 1,2, le mettre dans tableau transposé 2,1)
        for (int i = 0; i < taille1; i++) {
            for (int j = 0; j < taille2; j++) {
                tableauTranspose[j][i] = tableau[i][j];
            }
        }
        // Affichage
        System.out.println("Tableau de transposé :");
        for (int i = 0; i < tableauTranspose.length; i++) {
            for (int j = 0; j < tableauTranspose[i].length; j++) {
                System.out.print(tableauTranspose[i][j] + "  ");
            }
            System.out.println();
        }

        return tableauTranspose;
    }

    public static void lancer() {

        // Créer un tableau 2D et l'afficher
        int[][] tableau2D = demanderTableau2D();
        // Transposer le trableau de départ et l'afficher
        int[][] tableauTranspose = transposerTableau2D(tableau2D);

    }
}
