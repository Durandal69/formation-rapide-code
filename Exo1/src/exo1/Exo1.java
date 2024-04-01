/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo1;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Stanislas
 */
public class Exo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        Scanner scanner = new Scanner(System.in);
        int i; // je déclare une variable qui est i
        do { 
            
            try {
                System.out.print("Quel est votre nombre ?");
                i=scanner.nextInt(); // elle lit ma valeur de i tapé au clavier
                if (i<=50) {
                    System.out.println(i+" est un nombre inférieur ou égal à 50.");
                } else if (0>i) {
                    System.out.println("GAME OVER");
                } else {
                    System.out.println(i+" est un nombre supérieur à 50.");
                }
            } 
            catch (InputMismatchException ime){
                System.out.println("Tu veux me niquer connard ?");
                i=-1;
            }
            
       
        } while (0<=i); // elle boucle tant que i est au dessus de 0
    }
    
}
