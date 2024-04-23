/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stanislas
 */
public class Exo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de nombre premier voulez-vous ?");
        int quantiteVoulu = scanner.nextInt(); //ça va lire la valeur choisit par l'user.
        int i = 1;
        ArrayList<Integer> listeDesPremiers = new ArrayList();
        while (listeDesPremiers.size() <= quantiteVoulu) {
            if (estPremier(i) == true) {
                
                listeDesPremiers.add(i);
            } 
            i++;
        }   
        System.out.println(listeDesPremiers.toString());
    }

    /**
     * Cette fonction offre une valeur true ou false en fonction du nombre testé
     * pour savoir si celui-ci est premier ou non.
     *
     * @param nombreATester
     * @return
     */
    public static boolean estPremier(int nombreATester) {
        for (int diviseur = 2; diviseur <= nombreATester / 2; diviseur++) {

            if (nombreATester % diviseur == 0) {
                return false;
            }
        }
        return true;
    }
}
