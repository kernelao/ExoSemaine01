package exercices;

import java.util.Scanner;

public class Exo2ChiffrementCesar {

    public static void lancer() {

        // Déclaration du Scanner et des 2 variables qui stock l'entrée de l'utilisateur
        Scanner clavier = new Scanner(System.in);
        String resultatChiffre = "";
        int decalage;

        // Demande à l'utilisateur d'entrer une phrase à chiffrer
        System.out.print("Veuillez entrer une phrase à chiffrer ==>  ");
        String entreeAChiffrer = clavier.nextLine();

        // Calcul de la taille de la phrase, variable qu'on utilisera pour le nombre d'itération
        int nbCaracteres = entreeAChiffrer.length();

        // Demande à l'utilisateur d'entrer un nombre entier entre 1 et 25 inclusivement (système de vérification)
        System.out.print("Veuillez entrer une nombre entier compris entre 1 et 25 inclusivement ==>  ");

        // La boucle se reproduit à chaque fois qu'une des conditions est vrai -> pas un nombre entier, pas entre 1 et 25
        while (true) {

            if (!clavier.hasNextInt()) {

                System.out.print("Désolé, mais vous devez entrer une nombre entier valide ! ==>  ");
                clavier.nextLine();

                continue;
            }

            decalage = clavier.nextInt();

            if ( !(decalage >= 1) || !(decalage <= 25) ) {

                System.out.print("Désolé, mais vous devez entrer une nombre entre 1 et 20 ! ==>  ");
                clavier.nextLine();

                continue;
            }

            // Si on arrive ici, c'est qu'on est pas entrée dans une condition, tout est OK !
            break;
        }

        // Système de décalage avec la table ASCII
        for (int i = 0; i < nbCaracteres; i++) {

            // On itère autant de fois qu'on a de lettre (grâce à la méthode length() sur String)
            char caractereExtrait = entreeAChiffrer.charAt(i);

            // Cette méthode vérifie si le charactère est une lettre ou pas (utile dans notre situation)
            if (Character.isLetter(caractereExtrait)) {

                // Si c'est une lettre, on capture le numéro ASCII reliée
                int numeroAsciiChar = (int)caractereExtrait;

                /* On s'assurer de garder les minuscule, donc un système de décalage qui reste
                dans sa borne et recommence à la borne suppérieur si atteint sa limite */
                if (numeroAsciiChar >= 65 && numeroAsciiChar <= 90) {

                    // On analyse si le décalage sort de nos bornes
                    int verificationBorne = numeroAsciiChar + decalage;

                    // Si oui, on revient à la borne inférieur
                    if (verificationBorne > 90) {

                        int decalageFin = 90 - numeroAsciiChar;
                        int decalageDebut = decalage - decalageFin;
                        numeroAsciiChar = 65 - 1 + decalageDebut; // On s'assure d'enlever 1 décalage, car on l'effectue manuellement
                        caractereExtrait = (char)numeroAsciiChar; // On retransforme en caractère

                        // Si le décalage reste dans les bornes, on a pas besoin de loop sur les bornes
                    } else {

                        numeroAsciiChar += decalage;
                        caractereExtrait = (char)numeroAsciiChar;

                    }
                    
                    // On stock chaque caractère (a-z)
                    resultatChiffre += caractereExtrait;


                    // Le cas pour les majuscules ici, on reproduit la même logique
                    // *********** Je sais pas si on aurait pu éviter la répétition ***************
                } else if (numeroAsciiChar >= 97 && numeroAsciiChar <= 122) {

                    int verificationBorne = numeroAsciiChar + decalage;

                    if (verificationBorne > 122) {

                        int decalageFin = 122 - numeroAsciiChar;
                        int decalageDebut = decalage - decalageFin;
                        numeroAsciiChar = 97 - 1 + decalageDebut;
                        caractereExtrait = (char)numeroAsciiChar;

                    } else {

                        numeroAsciiChar += decalage;
                        caractereExtrait = (char)numeroAsciiChar;

                    }
                    // On stock chaque caractère (A-Z)
                    resultatChiffre += caractereExtrait;

                }

            } else {
                // On stock tout autre caractère qui n'est pas une lettre (donc chiffres ou caractères spéciaux)
                resultatChiffre += caractereExtrait;
            }

        }

        // On affiche la phrase après notre petit algorithme de chiffrement
        System.out.print(resultatChiffre);

    }
}
