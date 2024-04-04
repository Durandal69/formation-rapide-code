/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo3;

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
        String[] jeudecartes;
        jeudecartes = generationDesCartes();
        System.out.println(Arrays.toString(jeudecartes));
        melangeDesCartes(jeudecartes);
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

    public static void melangeDesCartes(String[] paquetDeCartes) {

        String[] paquetmelange = new String[52];
        for (int carte = 0; carte < paquetDeCartes.length; carte++) {
            int melange = (int) (Math.random() * 52);
            if (paquetmelange[melange] == null) {

                paquetmelange[melange] = paquetDeCartes[carte];
            } else {
                erreurMelange(paquetDeCartes[carte], paquetmelange);    // permet l'appel et le lien avec la fonction suivante, paquetDeCartes deviendra carte et paquetmelange deviendra paquet (dans la fonction suivante)
            }
        }
    }
    
    public static void erreurMelange(String carte, String[] paquet) {
        for (int indexPaquet=0; indexPaquet < paquet.length ; indexPaquet++) {
            if (paquet[indexPaquet] != null) {
                continue;
            } else {
                paquet[indexPaquet] = carte;
                break;
            } 
        }
    }
}
