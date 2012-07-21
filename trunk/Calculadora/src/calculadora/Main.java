/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import calculadora.prestamos.Cuotas;
import calculadora.prestamos.Prestamo;
import calculadora.prestamos.TipoTasa;

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
        
        
        Cuotas c = Prestamo.calcularCuotaNivelada(27000, 0.01, 12, TipoTasa.MENSUAL);
        c.print();
        
        //c = Prestamo.calcularSaldoInsoluto(18000, 0.22, 24, TipoTasa.MENSUAL, 1);
        //c.print();
        //Flujos f = c.getFlujos();
        //f.restarAlFlujo(1, 450);
        
        //Flujos f2 = new Flujos();
        //for( int i = 1; i <= 30; i++ ){
        //    f2.agregarFlujo(40000);
        //}
        
        //System.out.println( "TIR: " + TIR.calcularTIR(f2, 50000000) );
        
        //double tir = TIR.calcularTIR(f, 180000 - 450);
        //System.out.println("TIR: " + tir);
        //System.out.println("CAT: " + ( Math.pow(1+tir, 12) - 1 ));
        
        //System.out.println(TIR.calcularTIR(flujos, Double.parseDouble(args[0])));
    }
}
