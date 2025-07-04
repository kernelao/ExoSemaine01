package tableaux;

import java.util.Random;

public class SommationMatrices {

    private static int[][] sommationMatrices(int[][] matrice1, int[][] matrice2) {

        // Vérification de la taille des deux matrices
        if (matrice1.length != matrice2.length) {
            System.out.println("Les matrices ne sont pas de la même taille !");
            return null;
        }

        if (matrice1[0].length != matrice2[0].length) {
            System.out.println("Les matrices ne sont pas de la même taille !");
            return null;
        }

        // Nouveau tableau
        int[][] sommeMatrice = new int[matrice1.length][matrice2[0].length];

        for (int i = 0; i < matrice1.length; i++) {
            for (int j = 0; j < matrice2[0].length; j++) {
                sommeMatrice[i][j] = matrice1[i][j] + matrice2[i][j];
            }
        }

        return sommeMatrice;
    }

    public static int[][] creerMatrice(int taille1, int taille2) {

        Random random = new Random();

        int[][] matrice = new int[taille1][taille2];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matrice[i][j] = random.nextInt(10);
            }
        }

        return matrice;
    }

    public static void afficherMatrice(int[][] matrice) {

        if (matrice == null) {
            System.out.println("Le matrice n'existe pas !");
            return;
        }

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + "    ");
            }
            System.out.println();
        }

    }

    public static void lancer() {

        int[][] matrice1 = creerMatrice(4,7);
        int[][] matrice2 = creerMatrice(4,12);

        System.out.println("Matrice 1: ");
        afficherMatrice(matrice1);

        System.out.println("Matrice 2: ");
        afficherMatrice(matrice2);

        int[][] matriceSommee = sommationMatrices(matrice1, matrice2);
        System.out.println("Matrice Sommée: ");
        afficherMatrice(matriceSommee);

    }

}
