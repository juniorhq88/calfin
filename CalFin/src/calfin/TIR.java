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
public class TIR {
    
    public static final String pattern = "+###,###,##0.00000000000000;-###,###,##0.00000000000000";
    public static final DecimalFormat df = new DecimalFormat(pattern);
    
    private TIR(){}
    
    
    
    
    public static double calcular( VPN vpn ){
        
        double interes = 0.0;
        double kint;
        double v;
        double vprima;
        double delta;
        
        if( Main.debug ){
            System.out.printf("%1$24s  %2$24s  %3$24s  %4$24s  %5$24s\n", "TIR(i)", "VAN(i)", "VAN'(i)", "TIR(i+1)", "Delta");
        }
        
        for( int i = 0; i < vpn.getNumeroPeriodos(); i++ ){
            v = vpn.vpn(interes);
            vprima = vpn.vpnPrima(interes);
            kint = interes - ( v / vprima );
            delta = Math.abs(interes - kint);
            if( Main.debug ){
                System.out.printf("%1$24s  %2$24s  %3$24s  %4$24s  %5$24s\n", f(interes), f(v), f(vprima), f(kint), f(delta));
            }
            interes = kint;
        }
        
        
        return interes;
    }
    
    private static String f(double val){
        return df.format(val);
    }
}
