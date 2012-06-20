/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.razones.TIR;

/**
 *
 * @author Jose Carlos Palma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TIR tir = new TIR();
        tir.setInversion(18000);
        tir.agregarFlujos(3000, 3000, 2000, 4000, 4000, 4000, 7000);
        
        System.out.println( tir.calcularTIR() );
    }
}
