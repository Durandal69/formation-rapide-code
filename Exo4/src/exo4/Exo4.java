/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo4;

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
        System.out.println("Quel nombre voulez-vous tester ?");
        int nombrechoisit = scanner.nextInt(); //ça va lire la valeur choisit par l'user.
        
        boolean estPremier = estPremier(nombrechoisit);

        if (estPremier) {
            System.out.println("C'est un nombre premier.");
        } else {
            System.out.println("Ce n'est pas un nombre premier.");
        }
    }

    public static boolean estPremier(int nombrechoisit) {
        for (int diviseur = 2; diviseur <= nombrechoisit / 2; diviseur++) {

            if (nombrechoisit % diviseur == 0) {
                return false;

            }

        }
        return true;
    }
}
//n++ % > 0
