/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo1;

import java.io.IOException;

/**
 *
 * @author Stanislas
 */
public class Exo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Quel est votre nombre ?");
        int i=System.in.read();
        if (i<=50) {
            System.out.println("c'est un nombre inférieur ou égal à 50.");
        }
        else {
            System.out.println("c'est un nombre supérieur à 50.");
        }
        
    }
    
}
