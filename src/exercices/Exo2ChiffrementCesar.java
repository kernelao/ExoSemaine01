package exercices;

import java.util.Scanner;

public class Exo2ChiffrementCesar {



    public static void lancer() {

        int decalage = 4;

        Scanner clavier = new Scanner(System.in);

        System.out.print("Veuillez entrer une phrase à chiffrer ==>  ");
        String entreeAChiffrer = clavier.nextLine();

        int nbCaracteres = entreeAChiffrer.length();

        String resultatChiffre = "";

        for (int i = 0; i < nbCaracteres; i++) {


            char caractereExtrait = entreeAChiffrer.charAt(i);

            if (Character.isLetter(caractereExtrait)) {

                int numeroAsciiChar = (int)caractereExtrait;

                if (numeroAsciiChar >= 65 && numeroAsciiChar <= 90) {

                    int verificationBorne = numeroAsciiChar + decalage;

                    if (verificationBorne > 90) {

                        int decalageFin = 90 - numeroAsciiChar;
                        int decalageDebut = decalage - decalageFin;
                        numeroAsciiChar = 65 - 1 + decalageDebut;
                        caractereExtrait = (char)numeroAsciiChar;

                    } else {

                        numeroAsciiChar += decalage;
                        caractereExtrait = (char)numeroAsciiChar;

                    }

                    resultatChiffre += caractereExtrait;


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

                    resultatChiffre += caractereExtrait;

                }

            } else {
                resultatChiffre += caractereExtrait;
            }

        }
        System.out.println(resultatChiffre);

    }


}
