/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.prestamos.Cuotas;
import calculadora.prestamos.Prestamo;
import calculadora.prestamos.TipoPagoAnual;
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

        //Flujos flujos = new Flujos();
        //flujos.agregarFlujos(3000, 3000, 2000, 4000, 4000, 7000);
        //TIR.calcularTIR(flujos, 18000);
        
        
        Cuotas c = Prestamo.calcularCuotaNivelada(18000, 0.22, 8, TipoPagoAnual.MENSUAL,1);
        c.print();
        Flujos f = c.getFlujos();
        f.restarAlFlujo(1, 450);
        double tir = TIR.calcularTIR(f, 18000);
        System.out.println("TIR: " + tir);
        System.out.println("CAT: " + ( Math.pow(1+tir, 8) - 1 ));
        
        //System.out.println(TIR.calcularTIR(flujos, Double.parseDouble(args[0])));
    }
}
