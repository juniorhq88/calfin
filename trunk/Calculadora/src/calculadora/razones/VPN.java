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
public class VPN extends Flujos {

    private double inversion;
    private double tasa;

    /**
     * Crea una nueva instancia de VPN.
     */
    public VPN() {
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

    /**
     * Establece la tasa con la que se va a calcular VP y VPN.
     * <PRE>
     * Por ejemplo:
     *  1. Costo del dinero a largo plazo
     *  2. Tasa de rentabilidad a largo plazo de la empresa
     *  3. Rentabilidad mínima que se está exigiendo al proyecto
     *  4. Costo de capital de la empresa.
     *  5. costo de oportunidad.
     * </PRE>
     *
     * @param tasa es el valor de la tasa.
     */
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    /**
     * Devuelve la tasa.
     *
     * @return el valor de la tasa.
     */
    public double getTasa() {
        return tasa;
    }

    /**
     * Calcula el valor presente de los flujos con una tasa específica.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vp.png"/>
     *
     * @param tasa es el valor de la tasa.
     * @return el valor presente.
     */
    public double calcularValorPresente(double tasa) {
        double retVal = 0.0;

        for (int i = 0; i < flujos.size(); i++) {
            retVal += flujos.get(i) / Math.pow(1.0 + tasa, i + 1);
        }

        return retVal;
    }

    /**
     * Calcula el valor presente de los flujos con la tasa establecida.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vp.png"/>
     *
     * @return el valor presente.
     * @see calculadora.razones.VPN#setTasa(double)
     */
    public double calcularValorPresente() {
        return calcularValorPresente(this.tasa);
    }

    /**
     * Calcula el valor presente dada la tasa y los flujos.
     *
     * @param tasa es el valor de tasa.
     * @param flujos listado de flujos.
     * @return el valor presente.
     */
    public static double calcularValorPresente(double tasa, double... flujos) {
        VPN retVal = new VPN();
        retVal.setInversion(0);
        retVal.setTasa(tasa);
        retVal.setFlujos(flujos);
        return retVal.calcularValorPresente();
    }

    /**
     * Calcula el valor presente neto de los flujos con una tasa específica.<BR>
     * Es equivalente a calcularValorPresente menos la inversión inicial.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vpn.png"/>
     *
     * @param tasa es el valor de la tasa.
     * @return el valor presente neto (descontado).
     */
    public double calcularValorPresenteNeto(double tasa) {
        return calcularValorPresente(tasa) - inversion;
    }

    /**
     * Calcula el valor presente neto de los flujos con la tasa establecida.<BR>
     * Es equivalente a calcularValorPresente menos la inversión inicial.<BR>
     * Utiliza un modelo matemático para el calculo dado por la formula:<BR>
     * <img src="../../resources/vpn.png"/>
     *
     * @return el valor presente neto (descontado).
     * @see calculadora.razones.VPN#setTasa(double)
     */
    public double calcularValorPresenteNeto() {
        return calcularValorPresenteNeto(this.tasa);
    }

    /**
     * Calcula el valor presente neto dado la inversión inicial, la tasa y los
     * flujos.
     *
     * @param inversion es el valor de la inversión inicial.
     * @param tasa es el valor de tasa.
     * @param flujos listado de flujos.
     * @return el valor presente neto.
     */
    public static double calcularValorPresenteNeto(double inversion, double tasa, double... flujos) {
        return VPN.calcularValorPresente(tasa, flujos) - inversion;
    }

    /**
     * Calcula la primera derivada del valor presente neto con una tasa
     * específica.<BR>Utiliza un modelo matemático para el calculo dado por la
     * formula:<BR> <img src="../../resources/vpnprima.png"/>
     *
     * @param tasa es el valor de la tasa.
     * @return el valor VPN'
     */
    public double calcularVPNPrima(double tasa) {
        double retVal = 0.0;
        for (int i = 0; i < flujos.size(); i++) {
            retVal -= (flujos.get(i) * (i + 1)) / Math.pow(1.0 + tasa, (i + 2));
        }
        return retVal;
    }

    /**
     * Calcula la primera derivada del valor presente neto con la tasa
     * establecida.<BR>Utiliza un modelo matemático para el calculo dado por la
     * formula:<BR> <img src="../../resources/vpnprima.png"/>
     *
     * @return el valor VPN'
     * @see calculadora.razones.VPN#setTasa(double)
     */
    public double calcularVPNPrima() {
        return calcularVPNPrima(this.tasa);
    }
}
