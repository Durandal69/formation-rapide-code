/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo2;

import java.util.Scanner;

/**
 *
 * @author Stanislas
 */
public class Exo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Combien d'étage voulez-vous ?");
        int nbEtage = scanner.nextInt(); // elle lit ma valeur de floor tapé au clavier
        String s = "*"; // c'est ma structure d'étages
        for (int floor = 1; floor <= nbEtage; floor++) {
            
            if (floor == 1) {
                System.out.println("^");
            } else {
                
                System.out.println("/"+s+"\\");
                s = s+"**";    
            }
            
        } 
        if (nbEtage < 0) {
                System.err.println("On fait pas une cave ici.");
        } else if (nbEtage == 0) {
            System.err.println("Bravo, t'as un terrain PLAT. Et elle est où ma pyramide connard ?");
        }

    }

}


