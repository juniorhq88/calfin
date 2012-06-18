/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calfin;

import java.text.DecimalFormat;

/**
 *
 * @author Jose Carlos Palma
 */
public class Main {
    
    public static boolean debug = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if( args.length > 0 ){
            for( String s: args ){
                if( s.trim().matches("^[-]?(debug|d)$") )
                    Main.debug = true;
            }
        }
        
        CuotaNivelada cn = new CuotaNivelada(18000, 0.22, 8, TipoPagoAnual.MENSUAL);
        
        cn.calcular();
        
        System.out.println( f( cn.getCuotaNivelada() ) );
        
        
    }
    
    public static String f(double d){
        return new DecimalFormat("+###,###,##0.00000000000000;-###,###,##0.00000000000000").format(d);
    }
}
