/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Stanislas
 */
public class Exo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] jeudecartes;   // C'est mon tableau avec mon jeu de carte. Je déclare un tableau de chaînes de caractère (String) qui s'appelle "jeudecartes"
        jeudecartes = generationDesCartes();    // Faut lire comme en jap' (droite à gauche), la fonction generationDesCartes renvoie à un tableau de String "jeudecartes"
        System.out.println(Arrays.toString(jeudecartes));   // Ici j'affiche toutes les valeurs du tableau
        jeudecartes = melangeDesCartes(jeudecartes);  // Ici la fonction melangeDesCartes prend en paramètre le jeudecartes. ça veut dire que paquetDeCartes = jeudecartes et donc que leurs valeurs changent après la résolution de la fonction
        System.out.println(Arrays.toString(jeudecartes));
        ArrayList<String> mainJ1 = new ArrayList();
        ArrayList<String> mainJ2 = new ArrayList();
        laDistribution(mainJ1, mainJ2, jeudecartes);
        System.out.println(mainJ1.toString());
        System.out.println(mainJ2.toString());
    }

    /**
     * la génération d'un paquet de cartes.
     *
     * @return le paquet de cartes
     */
    public static String[] generationDesCartes() {
        String[] jeuDeCartes = new String[52];
        String[] typeDeCartes = {"coeur", "carreau", "pique", "trefle"};
        String[] valeurDeCartes = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
        int i = 0;

        for (int indexType = 0; indexType < typeDeCartes.length; indexType++) {
            for (int indexValeur = 0; indexValeur < valeurDeCartes.length; indexValeur++) {
                jeuDeCartes[i] = typeDeCartes[indexType] + "-" + valeurDeCartes[indexValeur];
                i++;
            }
        }
        return jeuDeCartes;
    }

    public static String[] melangeDesCartes(String[] paquetDeCartes) {

        String[] paquetmelange = new String[52];
        for (int carte = 0; carte < paquetDeCartes.length; carte++) {
            int melange = (int) (Math.random() * 52);
            if (paquetmelange[melange] == null) {

                paquetmelange[melange] = paquetDeCartes[carte];
            } else {
                paquetmelange = erreurMelange(paquetDeCartes[carte], paquetmelange);    // permet l'appel et le lien avec la fonction suivante, paquetDeCartes deviendra carte et paquetmelange deviendra paquet (dans la fonction suivante)
            }
        }
        return paquetmelange;
    }

    public static String[] erreurMelange(String carte, String[] paquet) {
        for (int indexPaquet = 0; indexPaquet < paquet.length; indexPaquet++) {
            if (paquet[indexPaquet] == null) {
                paquet[indexPaquet] = carte;
                break;
            }
        }
        return paquet;
    }

    public static void laDistribution(ArrayList<String> mainJ1, ArrayList<String> mainJ2, String[] paquetmelange) {
        for (int carteJ1 = 0; carteJ1 < paquetmelange.length; carteJ1 = carteJ1 + 2) {
            mainJ1.add(paquetmelange[carteJ1]);
            mainJ2.add(paquetmelange[carteJ1 + 1]);

        }
    }

    public static int valeurCarte(String carte) {
        String valeur;
        valeur = carte.split("-")[1];
        switch (valeur) {
            case "As":
                return 14;
            case "Roi":
                return 13;
            case "Dame":
                return 12;
            case "Valet":
                return 11;
            default:
                return Integer.valueOf(valeur);

        }
    }

    public static void leJeu(ArrayList<String> mainJ1, ArrayList<String> mainJ2) {
        int valeurCarteJ1 = valeurCarte(mainJ1.getFirst());
        int valeurCarteJ2 = valeurCarte(mainJ2.getFirst());
        if (valeurCarteJ1 < valeurCarteJ2) { // on pause ici, faut maintenant add la carte de J1 dans J2 puis suppr dans J1 cette carte. Soit par fonction (merci nano) soit par des lignes de code à bouffer (mais plus facile)
            
            
        }
    }
}
