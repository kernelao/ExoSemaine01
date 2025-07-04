package tableaux;

import java.util.Scanner;
import java.util.Random;

public class TableauValeursAleatoires {

    public static void lancer() {

        // On s'assure que l'utilisateur ne génère pas moins de 1 nombre et que sa soit un entier
        int nombreAGenerer = demanderNombreUtilisateur();

        // On génère les nombres aléatoires et on les stock dans un tableau qu'on récupère
        int[] tableauValeurAleatoire = stockerChiffresTableau(nombreAGenerer);

        // On vérifie combien de fois chaque chiffre existe
        repetitionChiffresTableau(tableauValeurAleatoire);

    }

    public static int demanderNombreUtilisateur() {

        Scanner clavier = new Scanner(System.in);
        int nombreAGenerer;

        System.out.print("Veuillez entrer un nombre entier compris entre 0 et 20 inclusivement!  ==>   ");

        while (true) {

            if (!clavier.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre entier valide!  ==>   ");
                clavier.next();
                continue;
            }

            nombreAGenerer = clavier.nextInt();

            if (nombreAGenerer <= 0) {
                System.out.print("Veuillez entrer un nombre plus grand que 0 !  ==>   ");
                clavier.next();
                continue;
            }

            break;
        }


        return nombreAGenerer;

    }

    private static int[] stockerChiffresTableau(int nombreAGenerer) {

        Random random = new Random();
        int nombreAleatoire;

        int[] tableauValeurAleatoire = new int[nombreAGenerer];

        for (int i = 0; i < tableauValeurAleatoire.length; i++) {

            nombreAleatoire = random.nextInt(21);
            tableauValeurAleatoire[i] = nombreAleatoire;
        }
        return tableauValeurAleatoire;
    }

    private static void repetitionChiffresTableau(int[] tableauValeurAleatoire) {

        for (int i = 0; i < tableauValeurAleatoire.length; i++) {

            int repetition = 1;
            System.out.print("Pour la valeur " + (i + 1) + " : <" + tableauValeurAleatoire[i] + ">, elle se retrouve -> ");

            for (int j = i + 1; j < tableauValeurAleatoire.length; j++) {

                if (tableauValeurAleatoire[i] == tableauValeurAleatoire[j]) {
                    repetition++;
                }
            }
            System.out.println("  " + repetition + ".");
        }
    }
}
