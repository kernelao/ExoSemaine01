package tableaux;

import java.util.Scanner;
import java.util.Random;

public class InverserTableau {

    public static int[] inverserTableau(int[] tableau) {

        // On obtient la taille du tableau
        int tailleTableau = tableau.length;

        // On crée un nouveau tableau qui a la même taille
        int[] tableauInverse = new int[tailleTableau];

        // Variable pour l'index du tableau final, lui sera rempliée de l'index 0 à la fin
        int index = 0;

        // On parcourt le tableau à l'envers, on extrait donc la dernière valeur qu'on place en ordre dans le tableau inversé
        for (int i = tailleTableau - 1; i >= 0; i--) {
            tableauInverse[index] = tableau[i];
            index++;
        }

        // Pour test, mettre la fonction en void et sans return
//        for (int i = 0; i < tailleTableau; i++) {
//            System.out.print(tableauInverse[i] + "   ");
//        }

        return tableauInverse;

    }

    public static void lancer() {

        Scanner clavier = new Scanner(System.in);
        int entreeUtilisateur;
        System.out.print("Entrez un entier valide  pour la taile de tableau ! ==>   ");

        while (true) {

            if (!clavier.hasNextInt()) {
                System.out.print("Veuillez entrez un nombre entier valide ! ===>   ");
                clavier.nextLine();
                continue;
            }

            entreeUtilisateur = clavier.nextInt();

            if (entreeUtilisateur <= 0) {
                System.out.println("Veuillez entrez un nombre positif plus grand que 1 ! ===>   ");
                clavier.nextLine();
                continue;
            }

            if (entreeUtilisateur >= 126) {
                System.out.println("Veuillez entrez un nombre petit, moins de 126 ! ===>   ");
                clavier.nextLine();
                continue;
            }

            break;

        }

        // ---- On crée un tableau avec des valeurs aléatoire pour l'utilisateur
        int[] tableauUtilisateur = new int[entreeUtilisateur];
        for (int i = 0; i < entreeUtilisateur; i++) {

            Random random = new Random();
            int nombreAleatoire = random.nextInt(30);
            tableauUtilisateur[i] = nombreAleatoire;

        }

        // Affichage du tableau
        System.out.println("Tableau de départ :");
        for (int i = 0; i < tableauUtilisateur.length; i++) {
            if (i == tableauUtilisateur.length - 1) {
                System.out.print(tableauUtilisateur[i] + "\n");
            } else {
                System.out.print(tableauUtilisateur[i] + " - ");
            }
        }

        // On utilise la fonction pour inverser le tableau
        int[] tableauInverse = inverserTableau(tableauUtilisateur);

        // Affichage du tableau inversé
        System.out.println("Tableau inversée :");
        for (int i = 0; i < tableauInverse.length; i++) {
            if (i == tableauUtilisateur.length - 1) {
                System.out.print(tableauInverse[i]);
            } else {
                System.out.print(tableauInverse[i] + " - ");
            }
        }



    }
}