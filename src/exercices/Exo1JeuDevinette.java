package exercices;

import java.util.Scanner;
import java.util.Random;

public class Exo1JeuDevinette {

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
        while (!success && nombreEssais != 0) {

            // À chaque boucle, le nombre d'essai décrémente
            nombreEssais--;

            // Suggestion rajoutée : Vérification de l'entrée de l'utilisateur (type valide : nombre) et de la borne (borne valide : 0à20 inclusivement)
            if (clavier.hasNextInt()) {
                resultat = clavier.nextInt();

                // Vérification des bornes
                while (resultat < 0 || resultat > 20) {
                    System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entre 0 et 20 insclusivement! ==>  ");

                    // Relancer une boucle en redemandant à l'utilisateur et en veillant à revérifier
                    while (!clavier.hasNextInt()) {
                        System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entier valide! ==>  ");
                    }

                    // On restock l'info et on reboucle pour revérifier les bornes, puis la validité du type
                    resultat = clavier.nextInt();
                }

            } else {

                // Boucle jusqu'à ce que l'utilisateur entre un entier
                while (!clavier.hasNextInt()) {
                    System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entier valide! ==>  ");
                    clavier.next();
                }
                // Stockage du nombre entier après être sur que c'est une entrée valide
                resultat = clavier.nextInt();

                // Vérification des bornes
                while (resultat < 0 || resultat > 20) {
                    System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entre 0 et 20 insclusivement! ==>  ");

                    // Relancer une boucle en redemandant à l'utilisateur et en veillant à revérifier
                    while (!clavier.hasNextInt()) {
                        System.out.print("Désolé, mais la valeur que vous venez d'entrer n'est pas acceptée!\nVeuillez entrer un nombre entier valide! ==>  ");
                        clavier.next();
                    }

                    // On restock l'info et on reboucle pour revérifier les bornes, puis la validité du type
                    resultat = clavier.nextInt();
                }

            }

            // Condition sur une valeur inférieur au résultat attendu
            if (resultat < nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.print("Désolé, vous avez perdu !");
                } else {
                    System.out.print("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre plus\ngrand que " + resultat + ", mais inférieur ou égal à 20. ==>  ");
                }

            // Condition sur une valeur inférieur au résultat attendu
            } else if (resultat > nombreAleatoire) {

                // Condition secondaire qui vérifie s'il reste encore un nombre d'essai afin d'éviter un message d'indice alors que le jeu est sur le point de s'arrêter
                if (nombreEssais == 0) {
                    System.out.print("Désolé, vous avez perdu !");
                } else {
                    System.out.print("Incorrect, il vous reste " + nombreEssais + " essais. Veuillez entrer un nombre plus\npetit que " + resultat + ", mais supérieur ou égal à 0. ==>  ");
                }

            // Sinon, si c'est ni inférieur, ni supérieur, alors l'utilisateur a deviné le résultat
            } else {
                // Calcul du nombre d'essais utilisés (5 - nombre d'essais restants = nombre d'essais utilisés)
                essaisUtilises = NOMBRE_TENTATIVES_AUTORISÉES - nombreEssais;
                System.out.print("Vous avez bien deviné le nombre, en " + essaisUtilises + " essais. Bravo!");

                // Variable d'état qui change pour ne plus refaire de boucle
                success=true;
            }

        }

    }
}
