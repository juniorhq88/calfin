/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.razones.Flujos;
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

        Flujos flujos = new Flujos();
        flujos.agregarFlujos(3000, 3000, 2000, 4000, 4000, 4000, 7000);

        System.out.println(TIR.calcularTIR(flujos, Double.parseDouble(args[0])));
    }
}
