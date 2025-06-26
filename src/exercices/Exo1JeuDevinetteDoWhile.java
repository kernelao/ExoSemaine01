package exercices;

import java.util.Scanner;
import java.util.Random;

public class Exo1JeuDevinetteDoWhile {

    final static int BORNE_NOMBRE_ALEATOIRE = 20;
    final static int NOMBRE_TENTATIVES_AUTORISÉES = 5;

    public static void lancer() {

        // Génération du nombre aléatoire
        Random random = new Random();
        int nombreAleatoire = random.nextInt(BORNE_NOMBRE_ALEATOIRE + 1);

        // Génération du clavier
        Scanner clavier = new Scanner(System.in);
        // Initialisation de la variable de résultat de l'utilisateur
        int resultat = 0;
        // Initialisation de la variable d'état du jeu
        boolean success = false;
        // Initialisation de la variable dynamique du nombre d'essai
        int nombreEssais = NOMBRE_TENTATIVES_AUTORISÉES;
        // Initialisation de la variable qui permettra de calculer le nombre d'essais utilisés
        int essaisUtilises = 0;

        // Boucle du programme, permet d'itérer jusqu'au nombre d'essais permis. Elle vérifie si l'utilisateur a obtenu le bon résultat, sinon, lui donne un indice.
        do {
            // À chaque boucle, le nombre d'essai décrémente
            nombreEssais--;
            System.out.println("Veuillez entrer un nombre entier entre 0 et 20 inclusivement!");
            resultat = clavier.nextInt();

            // Condition sur une valeur inférieure au résultat attendu
            if (resultat < nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.println("Désolé, vous avez perdu !");
                } else {
                    System.out.println("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre plus grand que " + resultat + ", mais inférieur ou égal à 20.");
                }

                // Condition sur une valeur inférieure au résultat attendu
            } else if (resultat > nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.println("Désolé, vous avez perdu !");
                } else {
                    System.out.println("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre plus petit que " + resultat + ", mais supérieur ou égal à 0.");
                }

                // Sinon, si c'est ni inférieur, ni supérieur, alors l'utilisateur a deviné le résultat
            } else {
                // Calcul du nombre d'essais utilisés (5 - nombre d'essais restants = nombre d'essais utilisés)
                essaisUtilises = NOMBRE_TENTATIVES_AUTORISÉES - nombreEssais;
                System.out.println("Vous avez bien deviné le nombre, en " + essaisUtilises + " essais. Bravo!");

                // Variable d'état qui change pour ne plus refaire de boucle
                success=true;
            }

        } while (!success && nombreEssais != 0);

    }
}
