package tableaux;

import java.util.Scanner;
import java.math.*;

public class SommeTableauxTries {


    private static int demanderTailleTableau() {

        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrer le nombre d'éléments dans le tableau ==>  ");
        int entreeUtilisateur;

        while (true) {

            if (!clavier.hasNextInt()) {
                System.out.println("Désolé. Entrez un nombre entier valide! ==>   ");
                clavier.nextLine();
                continue;
            }

            entreeUtilisateur = clavier.nextInt();

            if (entreeUtilisateur <= 0) {
                System.out.println("Désolé. Entrez un nombre plus grand que 0! ==>   ");
                clavier.nextLine();
                continue;
            }

            break;
        }

        return entreeUtilisateur;

    }

    private static int[] demanderRemplirTableau(int taille) {

        int[] tableauARemplir = new int[taille];
        int nombre;

        for (int i = 0; i < taille; i++) {
            nombre = TableauValeursAleatoires.demanderNombreUtilisateur();
            tableauARemplir[i] = nombre;
        }

        return tableauARemplir;

    }

    private static int[] trierTableau(int[] tableau) {

        for (int i = 0; i < tableau.length - 1; i++) {

            for (int j = i + 1; j < tableau.length; j++) {

                int valeurMin = tableau[i];

                if (valeurMin > tableau[j]) {

                    int temp = tableau[i];
                    tableau[i] = tableau[j];
                    tableau[j] = temp;

                }
            }
        }
        return tableau;
    }

    private static int[] sommerTableau(int[] tableau1, int[] tableau2) {

        int taille1 = tableau1.length;
        int taille2 = tableau2.length;

        int tailleSomme = Math.min(taille1, taille2);
        int tailleTotal = Math.max(taille1, taille2);

        int[] tableauSommer = new int[tailleTotal];

        for (int i = 0; i < tailleSomme; i++) {
            tableauSommer[i] = tableau1[i] + tableau2[i];
        }

        if (tailleSomme == tailleTotal) {
            return tableauSommer;
        } else {

            if (taille1 > taille2) {

                for (int i = taille2; i < taille1; i++) {
                    tableauSommer[i] = tableau1[i];
                }
            } else {

                for (int i = taille1; i < taille2; i++) {
                    tableauSommer[i] = tableau2[i];
                }
            }
            return tableauSommer;
        }
    }

    public static void lancer() {

        // Demander à l'utilisateur une taille de tableau, nombre d'éléments
        System.out.print("Tableau 1 ---  ");
        int tailleTableau1 = demanderTailleTableau();
        System.out.print("Tableau 2 ---  ");
        int tailleTableau2 = demanderTailleTableau();

        // Demander à l'utilisateur de remplir le tableau (on aurait pu utiliser random)
        System.out.print("Tableau 1 ---  ");
        int[] tableau1 = demanderRemplirTableau(tailleTableau1);
        System.out.print("Tableau 2 ---  ");
        int[] tableau2 = demanderRemplirTableau(tailleTableau2);

        // Trier chacun des tableaux
        int[] tableauTrie1 = trierTableau(tableau1);
        int[] tableauTrie2 = trierTableau(tableau2);

        // Sommer les deux tableaux et le trier
        int[] tableauSommer = sommerTableau(tableau1, tableau2);
        int[] tableauSommerTrie = trierTableau(tableauSommer);

        // Affichage
        for (int i = 0; i < tableauSommer.length; i++) {
            System.out.println(tableauSommer[i]);
        }
    }
}