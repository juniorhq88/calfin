/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.razones;

import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Palma
 */
public class TIR extends Flujos{
    
    private double inversion;
    
    
    public TIR(){
        flujos = new ArrayList<Double>();
    }
    
    /**
     * Establece la inversión inicial.
     *
     * @param inversion es el valor de la inversión inicial.
     */
    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    /**
     * Devuelve la inversión inicial.
     *
     * @return el valor de la inversión inicial.
     */
    public double getInversion() {
        return this.inversion;
    }
    
    
    public double calcularTIR(){
        VPN vpn = new VPN();
        vpn.setInversion(inversion);
        vpn.setFlujos(flujos);
        
        double tir = 0.0;
        double tir2;
        double van;
        double vanprima;
        double delta = -1.0;
        
        for(int i = 0; i < 200 && (int)(delta*10000000) != 0; i++){
            van = vpn.calcularValorPresenteNeto(tir);
            vanprima = vpn.calcularVPNPrima(tir);
            tir2 = tir - ( van / vanprima );
            delta = Math.abs(tir - tir2);
            
            tir = tir2;
        }//9.66968391467227%
        
        
        
        return tir;
    }
    
    
}
