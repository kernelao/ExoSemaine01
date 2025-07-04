package tableaux;

import static tableaux.SommationMatrices.creerMatrice;
import static tableaux.SommationMatrices.afficherMatrice;

public class SommationLignesColonnes {

    private static void sommerLignes(int[][] matrice){

        int totalLignes = 0;
        int indexLigne = 1;

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                totalLignes += matrice[i][j];
            }
            System.out.println("La ligne " + indexLigne + " : " + totalLignes);
            totalLignes = 0;
            indexLigne++;
        }
    }

    private static void sommerColonnes(int[][] matrice){

        int totalColonnes = 0;
        int indexColonne = 1;

        for (int i = 0; i < matrice[0].length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                totalColonnes += matrice[j][i];
            }
            System.out.println("La colonne " + indexColonne + " : " + totalColonnes);
            totalColonnes = 0;
            indexColonne++;
        }
    }

    public static void lancer() {

        int[][] matrice = creerMatrice(3,4);
        System.out.println("Matrice ==>  ");
        afficherMatrice(matrice);

        sommerLignes(matrice);
        sommerColonnes(matrice);

    }
}
