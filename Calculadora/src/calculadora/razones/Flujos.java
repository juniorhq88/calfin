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
public class Flujos {
    
    
    protected ArrayList<Double> flujos;
    
    
    public Flujos() {
    }

    /**
     * Agrega el flujo al final.
     *
     * @param flujo es el valor del flujo.
     */
    public void agregarFlujo(double flujo) {
        flujos.add(flujo);
    }

    /**
     * Agrega los flujos al final.
     *
     * @param flujos es el listado de flujos.
     */
    public void agregarFlujos(double... flujos) {
        for (double f : flujos) {
            agregarFlujo(f);
        }
    }

    /**
     * Agrega los flujos al final.
     *
     * @param flujos es el listado de flujos.
     * @see calculadora.razones.VPN#agregarFlujos(double...)
     */
    public void agregarFlujos(ArrayList<Double> flujos) {
        for (Double f : flujos) {
            agregarFlujo(f);
        }
    }

    /**
     * Devuelve el valor del flujo para un periodo específico.<BR><B><I>Nota:
     * los períodos comienzan de 1.</I></B>
     *
     * @param periodo es el período del flujo.
     * @return el valor del flujo.
     */
    public double getFlujo(int periodo) {
        if (periodo < 1 || periodo > flujos.size()) {
            throw new IllegalStateException("Periodo fuera de rango");
        }
        return flujos.get(periodo - 1);
    }

    /**
     * Devuelve el listado de flujos.
     *
     * @return un arreglo con los flujos.
     */
    public double[] getFlujos() {
        double[] retVal = new double[flujos.size()];
        for (int i = 0; i < retVal.length; i++) {
            retVal[i] = flujos.get(i);
        }
        return retVal;
    }

    /**
     * Devuelve el listado de flujos.
     *
     * @return una lista con los flujos.
     */
    public ArrayList<Double> getFlujosLista() {
        return (ArrayList<Double>) flujos.clone();
    }

    /**
     * Resta al flujo del periodo el valor del monto. <B><I>Nota: los periodos
     * comienzan de 1.</I></B>
     *
     * @param periodo es el periodo del flujo.
     * @param monto es el valor que se va a restar.
     */
    public void restarAlFlujo(int periodo, double monto) {
        sumarAlFlujo(periodo, -monto);
    }

    
    /**
     * Establece el valor del flujo para un periodo específico.<BR><B><I>Nota:
     * los periodos comienzan de 1.</I></B>
     *
     * @param periodo es el periodo del flujo.
     * @param flujo es el valor del flujo.
     */
    public void setFlujo(int periodo, double flujo) {
        if (periodo < 1 || periodo > flujos.size()) {
            throw new IllegalStateException("Per\u00edodo fuera de rango");
        }
        flujos.set(periodo - 1, flujo);
    }


    /**
     * Estable los flujos.
     *
     * @param flujos es el listado de flujos.
     */
    public void setFlujos(double... flujos) {
        this.flujos.clear();
        agregarFlujos(flujos);
    }


    /**
     * Estable los flujos.
     *
     * @param flujos es el listado de flujos.
     */
    public void setFlujos(ArrayList<Double> flujos) {
        this.flujos.clear();
        agregarFlujos(flujos);
    }

    /**
     * Suma al flujo del periodo el valor del monto. <B><I>Nota: los periodos
     * comienzan de 1.</I></B>
     *
     * @param periodo es el periodo del flujo.
     * @param monto es el valor que se va a sumar.
     */
    public void sumarAlFlujo(int periodo, double monto) {
        if (periodo < 1 || periodo > flujos.size()) {
            throw new IllegalStateException("Per\u00edodo fuera de rango");
        }
        flujos.set(periodo - 1, flujos.get(periodo - 1) + monto);
    }

}
