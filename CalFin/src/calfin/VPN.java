/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calfin;

/**
 * Clase que encapsula la lógica del calculo del Valor Presente Neto.
 * @author Jose Carlos Palma
 */
public class VPN {

    private double flujos[];
    private double inversion;

    /**
     * 
     * @param periodos
     */
    public VPN(int periodos) {
        this.inversion = 0;
        this.flujos = new double[periodos];
        for (int i = 0; i < this.flujos.length; i++) {
            flujos[i] = 0;
        }
    }

    /**
     * 
     * @param inversion
     * @param flujos
     */
    public VPN(double inversion, double... flujos) {
        this.inversion = inversion;
        this.flujos = new double[flujos.length];
        System.arraycopy(flujos, 0, this.flujos, 0, this.flujos.length);
    }
    
    
    
    /**
     * Devuelve el número de periodos. Es equivalente a getPeriodos
     * @return número de periodos.
     * @see calfin.VPN#getPeriodos() 
     */
    public int size(){
        return flujos.length;
    }
    
    /**
     * Devuelve el número de periodos.
     * @return número de periodos.
     */
    public int getNumeroPeriodos(){
        return size();
    }

    /**
     * Establece el valor de la inversión inicial.
     * @param inversion es la inversión inicial.
     */
    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    /**
     * Devuelve el valor de la inversión inicial (período cero).
     * @return
     */
    public double getInversion() {
        return this.inversion;
    }

    /**
     * Establece los flujos netos (con sus respectivos signos), la cantidad
     * de flujos determina el número de periodos.
     * @param flujos conjunto de flujos
     */
    public void setFlujos(double... flujos) {
        this.flujos = new double[flujos.length];
        System.arraycopy(flujos, 0, this.flujos, 0, this.flujos.length);
    }

    /**
     * Devuelve los flujos netos.
     * @return un arreglo con los flujos netos.
     */
    public double[] getFlujos() {
        return this.flujos;
    }

    /**
     * Establece un flujo para un periodo. el periodo para el primer flujo es 1.
     * @param periodo es el número del periodo.
     * @param flujo es el flujo neto.
     */
    public void setFlujo(int periodo, double flujo) {
        if (periodo < 1 || periodo > this.flujos.length) {
            throw new IllegalStateException("Periodo fuera de rango");
        }
        this.flujos[periodo-1] = flujo;
    }

    /**
     * Devuelve  el flujo neto de un periodo.
     * @param periodo
     * @return
     */
    public double getFlujo(int periodo) {
        if (periodo < 1 || periodo > this.flujos.length) {
            throw new IllegalStateException("Periodo fuera de rango");
        }
        return this.flujos[periodo-1];
    }
    
    
    /**
     * Calcula el Valor Presente Neto (VPN) de los flujos a una tasa dada.
     * Se utiliza el modelo matemático:
     * <img src=""/>
     * Nota: es equivalente a VP - Inversión inicial.
     * @param tasa tipo de interés, por ejemplo:
     * <PRE>
     * 1. Costo del dinero a largo plazo
     * 2. Tasa de rentabilidad a largo plazo de la empresa
     * 3. Rentabilidad mínima que se está exigiendo al proyecto
     * 4. Costo de capital de la empresa.
     * 5. costo de oportunidad.
     * </PRE>
     * @return el valor presente neto.
     */
    public double vpn(double tasa) {
        return vp(tasa) - inversion;
    }
    
    
    /**
     * Devuelve el Valor Presente (VP) de los flujos a una tasa dada.
     * @param tasa tipo de interés, por ejemplo:
     * <PRE>
     * 1. Costo del dinero a largo plazo
     * 2. Tasa de rentabilidad a largo plazo de la empresa
     * 3. Rentabilidad mínima que se está exigiendo al proyecto
     * 4. Costo de capital de la empresa.
     * 5. costo de oportunidad.
     * </PRE>
     * @return el valor presente.
     */
    public double vp(double tasa){
        double retVal = 0.0;
        for (int i = 0; i < flujos.length; i++) {
            retVal += ( flujos[i] / Math.pow( 1.0 + tasa, i+1 ) );
        }
        return retVal;
    }
    
    /**
     * Devuelve la primera derivada del VPN.
     * @param tasa
     * @return
     */
    public double vpnPrima(double tasa){
        double retVal = 0.0;
        for (int i = 0; i < flujos.length; i++) {
            retVal -= ( (flujos[i] * (i+1)) / Math.pow( 1.0 + tasa, i+2 ) );
        }
        return retVal;
    }
    
    
}
