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

        // Affichage initiale de la demande
        System.out.print("Veuillez entrer un nombre entier entre 0 et 20 inclusivement! ==>  ");

        // Boucle du programme, permet d'itérer jusqu'au nombre d'essais permis. Elle vérifie si l'utilisateur a obtenu le bon résultat, sinon, lui donne un indice.
        do {
            // À chaque boucle, le nombre d'essai décrémente
            nombreEssais--;

            // Suggestion rajoutée v2 : Vérification de l'entrée de l'utilisateur (type valide : nombre) et de la borne (borne valide : 0à20 inclusivement)
//            if (clavier.hasNextInt()) {
//                resultat = clavier.nextInt();
//            } else {
//                while (!clavier.hasNextInt()) {
//                    System.out.print("Veuillez entrer un nombre entier entre 0 et 20 inclusivement! ==>  ");
//                    clavier.next();
//                }
//                resultat = clavier.nextInt();
//            }

            // Il faudrait une boucle qui vérifie plusieurs condition et si l'une n'est pas respecté, on recommence depuis le début
            /* Le continue est adapté dans cette situation, si une condition n'est pas bonne (on capte l'erreur), alors on affiche
            un message à l'utilisateur, on utilise le "continue" pour ignorer tout le code de la boucle et directement recommencer la
            boucle car on a true. Si tous nos vérifications sont bonne, donc on rentre pas dans les conditions, alors on peut arriver
            à "break" pour ne plus reboucler. On aura obtenu la bonne réponse.*/

            while (true) {

                // On vérifie si c'est un nombre entier
                if (!clavier.hasNextInt()) {
                    System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entier valide! ==>  ");
                    clavier.next();
                    continue;
                }

                resultat = clavier.nextInt();

                // On vérifie si la valeur est comprise entre 0 et 20
                if (resultat < 0 || resultat > 20) {
                    System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entre 0 et 20 insclusivement! ==>  ");
                    continue;
                }

                break;
            }

            // Condition sur une valeur inférieure au résultat attendu
            if (resultat < nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.print("Désolé, vous avez perdu !");
                } else {
                    System.out.print("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre \nplus grand que " + resultat + ", mais inférieur ou égal à 20. ==>  ");
                }

                // Condition sur une valeur inférieure au résultat attendu
            } else if (resultat > nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.print("Désolé, vous avez perdu !");
                } else {
                    System.out.print("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre \nplus petit que " + resultat + ", mais supérieur ou égal à 0. ==>  ");
                }

                // Sinon, si c'est ni inférieur, ni supérieur, alors l'utilisateur a deviné le résultat
            } else {
                // Calcul du nombre d'essais utilisés (5 - nombre d'essais restants = nombre d'essais utilisés)
                essaisUtilises = NOMBRE_TENTATIVES_AUTORISÉES - nombreEssais;
                System.out.print("Vous avez bien deviné le nombre, en " + essaisUtilises + " essais. Bravo!");

                // Variable d'état qui change pour ne plus refaire de boucle
                success=true;
            }

        } while (!success && nombreEssais != 0);

    }
}
