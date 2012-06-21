/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.razones;

/**
 *
 * @author Jose Carlos Palma
 */
public class VPN {

    
    /**
     * Crea una nueva instancia de VPN.
     */
    private VPN() {
        
    }

    
    

    /**
     * Calcula el valor presente de los flujos con una tasa específica.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vp.png"/>
     *
     * @param flujos listado de flujos.
     * @param tasa es el valor de la tasa.
     * @return el valor presente.
     */
    public static double calcularValorPresente(Flujos flujos, double tasa) {
        double retVal = 0.0;

        for (int i = 1; i <= flujos.size(); i++) {
            retVal += flujos.getFlujo(i) / Math.pow(1.0 + tasa, i );
        }

        return retVal;
    }



    /**
     * Calcula el valor presente neto de los flujos con una tasa específica.<BR>
     * Es equivalente a calcularValorPresente menos la inversión inicial.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vpn.png"/>
     *
     * @param flujos listado de flujos.
     * @param tasa es el valor de la tasa.
     * @param inversion es la inversión inicial.
     * @return el valor presente neto.
     */
    public static double calcularValorPresenteNeto(Flujos flujos, double tasa, double inversion) {
        return calcularValorPresente(flujos, tasa) - inversion;
    }

    

    /**
     * Calcula la primera derivada del valor presente neto con una tasa
     * específica.<BR>Utiliza un modelo matemático para el calculo dado por la
     * formula:<BR> <img src="../../resources/vpnprima.png"/>
     *
     * @param flujos listado de flujos.
     * @param tasa es el valor de la tasa.
     * @return el valor VPN'
     */
    public static double calcularVPNPrima(Flujos flujos, double tasa) {
        double retVal = 0.0;
        for (int i = 1; i <= flujos.size(); i++) {
            retVal -= (flujos.getFlujo(i) * i ) / Math.pow(1.0 + tasa, (i + 1));
        }
        return retVal;
    }
    
}
