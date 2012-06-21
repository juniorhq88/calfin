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
    
    
    public static final String pattern = "+###,###,##0.0000000;-###,###,##0.0000000";
    public static final DecimalFormat df = new DecimalFormat(pattern);
    
    
    private TIR() {
    }

    public static double calcularTIR(Flujos flujos, double inversion) {

        double tir = -0.9, tir2, van, vanprima, delta = 0.0;
        int count = 0;
        
        System.out.printf("%1$3s %2$30s %3$30s %4$30s %5$30s %6$30s\n", "i", "TIR(i)", "VAN(i)", "VAN'(i)", "TIR(i+1)", "Delta");
        
        do {
            van = VPN.calcularValorPresenteNeto(flujos, tir, inversion);
            vanprima = VPN.calcularVPNPrima(flujos, tir);
            tir2 = tir - (van / vanprima);
            delta = Math.abs(tir - tir2);
            System.out.printf("%1$3d %2$30s %3$30s %4$30s %5$30s %6$30s\n", count, f(tir), f(van), f(vanprima), f(tir2), f(delta));
            tir = tir2;
        } while (++count <= 100 && (long) (delta * 10000000L) != 0L);

        if (count > 100) {
            throw new TIRNotFoundException("TIR no encontrada [delta=" + delta + "]");
        }


        return tir;
    }
    
    private static String f(double val){
        return df.format(val);
    }
}
