/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.razones;

import java.text.DecimalFormat;

/**
 *
 * @author Jose Carlos Palma
 */
public class TIR {
    
    
    public static final String pattern = "+###,###,##0.00000000;-###,###,##0.00000000";
    public static final DecimalFormat df = new DecimalFormat(pattern);
    
    
    private TIR() {
    }

    public static double calcularTIR(Flujos flujos, double inversion) {

        double tir = -0.9, tir2, van, vanprima, delta = -1.0;
        int count = 0;
        
        System.out.printf("%1$3s %2$28s  %3$28s  %4$28s  %5$28s  %6$28s\n", "i", "TIR(i)", "VAN(i)", "VAN'(i)", "TIR(i+1)", "Delta");
        
        do {
            van = VPN.calcularValorPresenteNeto(flujos, inversion, tir);
            vanprima = VPN.calcularVPNPrima(flujos, tir);
            tir2 = tir - (van / vanprima);
            delta = Math.abs(tir - tir2);
            System.out.printf("%1$3d  %2$28s  %3$28s  %4$28s  %5$28s %6$28s\n", count, f(tir), f(van), f(vanprima), f(tir2), f(delta));
            tir = tir2;
        } while (++count <= 20 && (int) (delta * 10000000) != 0);

        if (count > 100) {
            throw new TIRNotFoundException("TIR no encontrada [delta=" + delta + "]");
        }


        return tir;
    }
    
    private static String f(double val){
        return df.format(val);
    }
}
