/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

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
        theGame(mainJ1, mainJ2);
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

    /**
     *
     * @param paquetDeCartes
     * @return un paquet mélangé (de cartes) sous forme d'un tableau de String.
     */
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
        for (int carteJ1 = 0; carteJ1 < paquetmelange.length; carteJ1 = carteJ1 + 2) { // pas sur que ce soit utile de commenter ici mais bon. On distribue les cartes quoi. La première à J1 et la deuxième à J2 et on recommence.
            mainJ1.add(paquetmelange[carteJ1]);
            mainJ2.add(paquetmelange[carteJ1 + 1]);

        }
    }

    public static int valeurCarte(String carte) {
        String valeur;
        valeur = carte.split("-")[1];
        switch (valeur) {   // ici on réattribut avec le switch une valeur a des cartes qui n'ont pas de valeur numéraire au départ.
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

    public static void jouerUneManche(ArrayList<String> mainJ1, ArrayList<String> mainJ2, ArrayList<String> leButin) {
        int valeurCarteJ1 = valeurCarte(mainJ1.getFirst());
        int valeurCarteJ2 = valeurCarte(mainJ2.getFirst());
            // A partir de là, on regarde les différents cas de figure du jeu avec en premier, la bataille, qui renvoie à un autre élément que les mains des joueurs, à savoir le tas de cartes à gagner, le butin;
        if (valeurCarteJ1 == valeurCarteJ2) {
            System.out.println("BATAILLE !!!");
            leButin.add(mainJ1.removeFirst());
            leButin.add(mainJ2.removeFirst());
            leButin.add(mainJ1.removeFirst());
            leButin.add(mainJ2.removeFirst());
            jouerUneManche(mainJ1, mainJ2, leButin);

        } else {

            if (valeurCarteJ1 < valeurCarteJ2) {
                mainJ2.add(mainJ1.removeFirst());
                mainJ2.addLast(mainJ2.removeFirst());
                mainJ2.addAll(leButin);
                leButin.clear();

            } else {
                if (valeurCarteJ1 > valeurCarteJ2) {
                    mainJ1.add(mainJ2.removeFirst());
                    mainJ1.addLast(mainJ1.removeFirst());
                    mainJ1.addAll(leButin);
                    leButin.clear();
                }
            }
        }
    }

    public static void theGame(ArrayList<String> mainJ1, ArrayList<String> mainJ2) {
        int nombreDeManche = 0;
        try { // ça c'est car on a eu un bug ! et fallait l'identifier et le corriger après.
        while (mainJ1.size() > 0 && mainJ2.size() > 0) { // les résolutions de parties se déroule grâce à ça.
            nombreDeManche++;
            jouerUneManche(mainJ1, mainJ2, new ArrayList());
            System.out.println("");
            System.out.println("Manche " + nombreDeManche);
            System.out.println("J1 : " + mainJ1.toString());
            System.out.println("J2 : " + mainJ2.toString());
        }
        } catch (NoSuchElementException premierBug) {
            System.out.println("L'un des deux joueurs n'a plus de carte, fin de partie.");
        }
        if (mainJ1.size() == 0) {
            System.out.println("J2 a gagné !");
        } else {
            System.out.println("J1 a gagné !");
        }
    }

}
