/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.prestamos.Cuotas;
import calculadora.prestamos.Prestamo;
import calculadora.prestamos.TipoPagoAnual;
import calculadora.razones.Flujos;

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
        
        
        Cuotas c = Prestamo.calcularCuotaNivelada(18000, 0.20, 8, TipoPagoAnual.MENSUAL);
        c.print();
        
        //System.out.println(TIR.calcularTIR(flujos, Double.parseDouble(args[0])));
    }
}
